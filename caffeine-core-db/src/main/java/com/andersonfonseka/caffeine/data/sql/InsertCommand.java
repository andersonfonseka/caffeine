package com.andersonfonseka.caffeine.data.sql;

import java.util.function.Consumer;

import com.andersonfonseka.caffeine.data.domain.Column;
import com.andersonfonseka.caffeine.data.domain.Database;
import com.andersonfonseka.caffeine.data.domain.Table;

public class InsertCommand extends SqlCommand {

	public InsertCommand(Database database, Table table) {
		super(database, table);
	}

	public String generate() {

		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO " + getTable().getName().toUpperCase() + " (");

		getTable().getColumns().forEach(new Consumer<Column>() {

			@Override
			public void accept(Column t) {
				if (!t.isAutoIncrement()) {
					builder.append(t.getName() + ", ");	
				}
			}
		});
		
		StringBuilder builderValues = new StringBuilder(builder.toString().substring(0, builder.toString().length()-2));

		builderValues.append(") VALUES (");	

		getTable().getColumns().forEach(new Consumer<Column>() {

			@Override
			public void accept(Column t) {
				if (!t.isAutoIncrement()) {
					builderValues.append("?, ");	
				}
			}
		});
		
		StringBuilder result = new StringBuilder(builderValues.toString().substring(0, builderValues.toString().length()-2));
		
		result.append(")");	
		
		return result.toString().toUpperCase()+";";
	}

}
