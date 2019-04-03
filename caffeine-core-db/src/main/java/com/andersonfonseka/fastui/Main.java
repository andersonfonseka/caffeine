package com.andersonfonseka.fastui;

import java.util.Optional;
import java.util.function.Consumer;

import com.andersonfonseka.fastui.data.ColumnManager;
import com.andersonfonseka.fastui.data.ConnectionManager;
import com.andersonfonseka.fastui.data.DatabaseManager;
import com.andersonfonseka.fastui.data.TableManager;
import com.andersonfonseka.fastui.data.domain.Database;
import com.andersonfonseka.fastui.data.domain.Table;
import com.andersonfonseka.fastui.data.sql.DeleteCommand;
import com.andersonfonseka.fastui.data.sql.InsertCommand;
import com.andersonfonseka.fastui.data.sql.SelectFilteredByPKCommand;
import com.andersonfonseka.fastui.data.sql.SelectFilteredCommand;
import com.andersonfonseka.fastui.data.sql.SelectJoinedCommand;
import com.andersonfonseka.fastui.data.sql.SelectRawCommand;
import com.andersonfonseka.fastui.data.sql.SqlCommand;
import com.andersonfonseka.fastui.data.sql.UpdateCommand;

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
