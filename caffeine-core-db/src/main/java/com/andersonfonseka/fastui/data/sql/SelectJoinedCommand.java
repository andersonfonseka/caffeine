package com.andersonfonseka.fastui.data.sql;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.andersonfonseka.fastui.data.domain.Column;
import com.andersonfonseka.fastui.data.domain.Database;
import com.andersonfonseka.fastui.data.domain.Table;

public class SelectJoinedCommand extends SqlCommand {

	public SelectJoinedCommand(Database database, Table table) {
		super(database, table);
	}

	public String generate() {

		StringBuilder builder = new StringBuilder();

		builder.append("SELECT * FROM " + getTable().getName().toUpperCase() + ", ");

		Supplier<Stream<Column>> results = () -> getTable().getColumns().stream().filter(x -> x.isForeignKey());

		results.get().forEach(new Consumer<Column>() {
			@Override
			public void accept(Column t) {
				builder.append(t.getFkTable().toUpperCase() + ", ");
			}
		});

		String result = builder.toString();

		if (result.substring(result.length() - 2, result.length() - 1).equals(",")) {
			result = result.substring(0, result.length() - 2);
		}

		StringBuilder builderConditional = new StringBuilder(result);

		if (results.get().count() > 0) {

			builderConditional.append(" WHERE ");

			results.get().forEach(new Consumer<Column>() {
				@Override
				public void accept(Column t) {
					builderConditional.append(
							getTable().getName() + "." + t.getName() + " = " + t.getFkTable().toUpperCase() + "."
									+ getDatabase().getTable(t.getFkTable()).getColumns().get(0).getName() + " AND ");
				}
			});
		}

		result = builderConditional.toString().toUpperCase();

		if (result.substring(result.length() - 5, result.length()).equals(" AND ")) {
			result = result.substring(0, result.length() - 5);
		}

		return result + ";";
	}

}
