package com.andersonfonseka.fastui.data.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {

	private Long id;

	private String name;
	
	private Database database;

	public Table(Long id, String name, Database database) {
		super();
		this.id = id;
		this.name = name;
		this.database = database;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Database getDatabase() {
		return database;
	}

	private List<Column> columns = new ArrayList<>();

	public void addTable(Column column) {
		this.columns.add(column);
	}

	public List<Column> getColumns() {
		return Collections.synchronizedList(columns);
	}
	
}
