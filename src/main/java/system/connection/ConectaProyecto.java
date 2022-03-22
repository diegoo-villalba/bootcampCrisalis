package system.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectaProyecto
 */
@WebServlet("/ConectaProyecto")
public class ConectaProyecto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ConectaProyecto() {
		super();
	}
	
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//URL de la BBDD
		String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=prueba;"
				+ "encrypt=true;trustServerCertificate=true";
		
		//Usuario para conectar a la BBDD
		String user = "sa";
		
		//Contraseña para conectar a la BBDD
		String pass = "123456";
		
		//Driver SQL SERVER de la BBDD
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			//Escribimos en el navegador para ver si efectivamente conectamos haciendo uso de PrintWriter
			out.print("Nombre de la base de BBDD: " + jdbcURL + "<br>");
			
			//Cargamos el DRIVER JDBC
			Class.forName(driver);
			
			//Utilizamos metodo getConnection que nos pide URL, User y Pass
			Connection myConnection = DriverManager.getConnection(jdbcURL, user, pass);

			out.print("Conexión exitosa!");
			
			//Cerramos la conexión
			myConnection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
