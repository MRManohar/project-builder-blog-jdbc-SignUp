package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public Connection getConnection() throws Exception {
//		Register the driver class
		Class.forName("oracle.jdbc.OracleDriver");
		
//		Creating a connection object
		Connection con = null;
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","123456");
		
		if(con != null)
			System.out.println("Connection established");
		else
			System.out.println("Connection not established");
		
		return con;		
	}
}
