package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	private static final String URL= "jdcb:oracle:thin:@localhost:1521:xe";
	private static final String USER= "Universidad";
	private static final String	PASSWORD= "oracle123";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);			
		}catch(SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException("Error al conectar la base de datos");
		}
		
		
	}
}
