package com.andersonfonseka.fastui.data.domain;

public class Column {
	
	private Integer id;
	
	private String name;
	
	private String type;
	
	private Integer size;
	
	private Integer nullable;
	
	private boolean primaryKey;
	
	private boolean foreignKey;
	
	private String fkTable;
	
	private String fkReferencedColumn;
	
	private String autoIncrement;

	public Column(Integer id, String name, String type, Integer size, Integer nullable) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.size = size;
		this.nullable = nullable;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Integer getSize() {
		return size;
	}

	public boolean isNullable() {
		return nullable.intValue() == 0 ? true : false;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public boolean isForeignKey() {
		return foreignKey;
	}

	public String getFkTable() {
		return fkTable;
	}
	
	public String getFkReferencedColumn() {
		return fkReferencedColumn;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public boolean isAutoIncrement() {
		return autoIncrement.equals("YES") ? true : false;
	}

	public void setAutoIncrement(String autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	public void setForeignKey(boolean foreignKey) {
		this.foreignKey = foreignKey;
	}

	public void setFkTable(String fkTable) {
		this.fkTable = fkTable;
	}

	public void setFkReferencedColumn(String fkReferencedColumn) {
		this.fkReferencedColumn = fkReferencedColumn;
	}
	
}
