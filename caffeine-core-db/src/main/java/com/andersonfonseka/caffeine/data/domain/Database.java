package com.andersonfonseka.caffeine.data.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
	
	private Long id;
	
	private String name;
	
	public Database(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private List<Table> tables = new ArrayList<>();
	
	public void addTable(Table table) {
		this.tables.add(table);
	}
	
	public List<Table> getTables() {
		return Collections.synchronizedList(tables);
	}
	
	public Table getTable(String tableName) {
		return this.tables.stream().filter(x -> x.getName().equals(tableName)).findAny().get();
	}
	
}
