package com.andersonfonseka.caffeine.data;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.caffeine.data.domain.Database;

public class DatabaseManager {

	private DatabaseMetaData dbmd;

	private List<Database> databases = new ArrayList<Database>();

	public DatabaseManager(DatabaseMetaData dbmd) throws SQLException {
		this.dbmd = dbmd;
	}

	public List<Database> getDatabases() throws SQLException {
		ResultSet set = dbmd.getCatalogs();

		while (set.next()) {

			String catalogName = set.getString(1);
			Database database = new Database(0L, catalogName);
			this.databases.add(database);
		}
		return this.databases;
	}
}
