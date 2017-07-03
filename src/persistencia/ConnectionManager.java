package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	   // JDBC driver ac� us� MYSQL usen el que quieran
	   //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   
	   //Aca va la IP y el motor de la base
	   //static final String DB_URL = "jdbc:mysql://localhost/EMP";

	   //  Credenciales usuario y password de la base
	   //static final String USER = "username";
	   //static final String PASS = "password";
	
		static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		static final String DB_URL = "jdbc:sqlserver://192.168.0.104:1433";
		static final String USER = "lau";
		static final String PASS = "lau";
		
	
	private ConnectionManager(){
		
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		 try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		return conn;
	}
	
	
}
