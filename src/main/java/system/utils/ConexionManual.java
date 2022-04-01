package system.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionManual {
	
	Connection connection;
	
	private String url="jdbc:sqlserver://localhost:1433;databaseName=prueba;encrypt=true;trustServerCertificate=true";
	private String user="sa";
	private String pass="123456";
	
	public Connection Conexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e){
			
			e.printStackTrace();
			
		}
		
		return connection;
	}

}
