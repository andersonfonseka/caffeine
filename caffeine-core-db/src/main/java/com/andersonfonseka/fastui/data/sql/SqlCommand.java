package com.andersonfonseka.fastui.data.sql;

import com.andersonfonseka.fastui.data.domain.Database;
import com.andersonfonseka.fastui.data.domain.Table;

public abstract class SqlCommand {
	
	private Database database;
	
	private Table table;
	
	public SqlCommand(Database database, Table table) {
		super();
		this.database = database;
		this.table = table;
	}

	public Database getDatabase() {
		return database;
	}

	public Table getTable() {
		return table;
	}

	public abstract String generate();
	
	
}
