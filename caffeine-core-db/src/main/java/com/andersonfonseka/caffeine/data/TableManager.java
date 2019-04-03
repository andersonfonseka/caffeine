package com.andersonfonseka.caffeine.data;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.andersonfonseka.caffeine.data.domain.Database;
import com.andersonfonseka.caffeine.data.domain.Table;

public class TableManager {

	private DatabaseMetaData dbmd;
	
	private Database database;

	public TableManager(DatabaseMetaData dbmd, Database database) throws SQLException {
		this.dbmd = dbmd;
		this.database = database;
	}

	public void getTables() throws SQLException {
		
		ResultSet set = dbmd.getTables(this.database.getName(), null, null, new String[]{"TABLE"});

		while (set.next()) {

			String tableName = set.getString(3);
			Table table = new Table(0L, tableName, this.database);
			database.addTable(table);

		}
	}
}
