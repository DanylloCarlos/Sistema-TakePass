package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	private static Connection c;
	private static String url;
	private static String driver;
	
	public static Connection novaConexao() throws ClassNotFoundException, SQLException {
		url = "jdbc:mysql://localhost/bdEventos";
		driver = "com.mysql.jdbc.Driver";
		c = null;
		
		Class.forName(driver);
		c = DriverManager.getConnection(url, "root", "123");
		
		return c;
	}
	
}
