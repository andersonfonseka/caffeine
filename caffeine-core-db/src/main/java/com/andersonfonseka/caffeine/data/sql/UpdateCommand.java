package com.andersonfonseka.caffeine.data.sql;

import java.util.function.Consumer;

import com.andersonfonseka.caffeine.data.domain.Column;
import com.andersonfonseka.caffeine.data.domain.Database;
import com.andersonfonseka.caffeine.data.domain.Table;

public class UpdateCommand extends SqlCommand {

	public UpdateCommand(Database database, Table table) {
		super(database, table);
	}

	public String generate() {

		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE " + getTable().getName().toUpperCase() + " SET ");

		getTable().getColumns().forEach(new Consumer<Column>() {

			@Override
			public void accept(Column t) {
				if (!t.isAutoIncrement()) {
					builder.append(t.getName() + "=?, ");	
				}
			}
		});
		
		StringBuilder builderValues = new StringBuilder(builder.toString().substring(0, builder.toString().length()-2));

		builderValues.append(" WHERE ");	

		getTable().getColumns().forEach(new Consumer<Column>() {

			@Override
			public void accept(Column t) {
				if (t.isPrimaryKey()) {
					builderValues.append(t.getName() + "=? AND ");	
				}
			}
		});
		
		StringBuilder result = new StringBuilder(builderValues.toString().substring(0, builderValues.toString().length()-5));
		
		return result.toString().toUpperCase()+";";
	}

}
