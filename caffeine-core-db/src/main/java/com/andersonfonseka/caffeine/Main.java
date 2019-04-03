package com.andersonfonseka.caffeine;

import java.util.Optional;
import java.util.function.Consumer;

import com.andersonfonseka.caffeine.data.ColumnManager;
import com.andersonfonseka.caffeine.data.ConnectionManager;
import com.andersonfonseka.caffeine.data.DatabaseManager;
import com.andersonfonseka.caffeine.data.TableManager;
import com.andersonfonseka.caffeine.data.domain.Database;
import com.andersonfonseka.caffeine.data.domain.Table;
import com.andersonfonseka.caffeine.data.sql.DeleteCommand;
import com.andersonfonseka.caffeine.data.sql.InsertCommand;
import com.andersonfonseka.caffeine.data.sql.SelectFilteredByPKCommand;
import com.andersonfonseka.caffeine.data.sql.SelectFilteredCommand;
import com.andersonfonseka.caffeine.data.sql.SelectJoinedCommand;
import com.andersonfonseka.caffeine.data.sql.SelectRawCommand;
import com.andersonfonseka.caffeine.data.sql.SqlCommand;
import com.andersonfonseka.caffeine.data.sql.UpdateCommand;

public class Main {


	public static void main(String[] args) throws Exception {
		
		ConnectionManager connectionManager = new ConnectionManager();
		DatabaseManager databaseManager = new DatabaseManager(connectionManager.getDatabaseMetaData());
		
		Optional<Database> database = databaseManager.getDatabases().stream()
																	.filter(x -> x.getName().equals("sakila"))
																	.findAny();
		
		TableManager tableManager = new TableManager(connectionManager.getDatabaseMetaData(), database.get());
		tableManager.getTables();
		
		database.get().getTables().forEach(n -> {
				try {
					ColumnManager columnManager = new ColumnManager(connectionManager.getDatabaseMetaData(), n);
					columnManager.getColumns();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		);
		
		connectionManager.close();
		
		database.get().getTables().forEach(new Consumer<Table>() {

			@Override
			public void accept(Table t) {
				
				SqlCommand sqlCommand = new SelectRawCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				sqlCommand = new SelectJoinedCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				sqlCommand = new SelectFilteredCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				sqlCommand = new SelectFilteredByPKCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				sqlCommand = new InsertCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				sqlCommand = new UpdateCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				sqlCommand = new DeleteCommand(database.get(), t);
				System.out.println(sqlCommand.generate());
				
				System.out.println("--------------------------------------------------------------------------------------");
			}
		});
		

	}

}
