package com.andersonfonseka.fastui.data.sql;

import com.andersonfonseka.fastui.data.domain.Database;
import com.andersonfonseka.fastui.data.domain.Table;

public class SelectRawCommand extends SqlCommand {

	public SelectRawCommand(Database database, Table table) {
		super(database, table);
	}

	public String generate() {

		StringBuilder builder = new StringBuilder();

		builder.append("SELECT * FROM " + getTable().getName().toUpperCase());

		return builder.toString() + ";";
	}

}
