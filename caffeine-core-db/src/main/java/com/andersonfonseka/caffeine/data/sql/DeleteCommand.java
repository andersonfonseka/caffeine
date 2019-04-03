package com.andersonfonseka.caffeine.data.sql;

import java.util.function.Consumer;

import com.andersonfonseka.caffeine.data.domain.Column;
import com.andersonfonseka.caffeine.data.domain.Database;
import com.andersonfonseka.caffeine.data.domain.Table;

public class DeleteCommand extends SqlCommand {

	public DeleteCommand(Database database, Table table) {
		super(database, table);
	}

	public String generate() {

		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM " + getTable().getName().toUpperCase());

		builder.append(" WHERE ");	

		getTable().getColumns().forEach(new Consumer<Column>() {

			@Override
			public void accept(Column t) {
				if (t.isPrimaryKey()) {
					builder.append(t.getName() + "=? AND ");	
				}
			}
		});
		
		StringBuilder result = new StringBuilder(builder.toString().substring(0, builder.toString().length()-5));
		
		return result.toString().toUpperCase()+";";
	}

}
