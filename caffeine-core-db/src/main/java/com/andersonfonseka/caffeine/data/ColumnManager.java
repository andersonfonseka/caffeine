package com.andersonfonseka.caffeine.data;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

import com.andersonfonseka.caffeine.data.domain.Column;
import com.andersonfonseka.caffeine.data.domain.Table;
import com.andersonfonseka.caffeine.util.SQLTypeUtil;

public class ColumnManager {

	private DatabaseMetaData dbmd;

	private Table table;

	private SQLTypeUtil sqlTypes;

	public ColumnManager(DatabaseMetaData dbmd, Table table) throws Exception {
		this.dbmd = dbmd;
		this.table = table;
		sqlTypes = new SQLTypeUtil();
	}

	public void getColumns() throws SQLException {

		ResultSet set3 = dbmd.getColumns(this.table.getDatabase().getName(), null, this.table.getName(), null);

		while (set3.next()) {

			Column column = new Column(set3.getInt(17), set3.getString(4), sqlTypes.getType(set3.getString(5)),
					Integer.valueOf(set3.getString(7)), Integer.valueOf(set3.getString(11)));

			column.setAutoIncrement(set3.getString(23));
			
			table.addTable(column);

		}

		ResultSet set4 = dbmd.getPrimaryKeys(this.table.getDatabase().getName(), null, this.table.getName());

		while (set4.next()) {

			String pkName = set4.getString(4);

			table.getColumns().stream().filter(x -> x.getName().equals(pkName)).findAny()
					.map(new Function<Column, Column>() {
						public Column apply(Column t) {
							t.setPrimaryKey(true);
						
							return t;
						}
					});
		}

		ResultSet setFK = dbmd.getImportedKeys(this.table.getDatabase().getName(), null, this.table.getName());

		while (setFK.next()) {

			String fkName = setFK.getString(4);
			String tableFKName = setFK.getString(3);
			String referencedColumnFKName = setFK.getString(8);

			table.getColumns().stream().filter(x -> x.getName().equals(referencedColumnFKName)).findAny()
					.map(new Function<Column, Column>() {
						public Column apply(Column t) {
							t.setForeignKey(true);
							t.setFkTable(tableFKName);
							t.setFkReferencedColumn(fkName);
							return t;
						}
					});
		}

	}
}
