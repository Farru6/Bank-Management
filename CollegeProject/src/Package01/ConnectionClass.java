package Package01;
import java.sql.*;


public class ConnectionClass 
{
	Connection conn;
	Statement statement;
	public ConnectionClass()
	{
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql:///bankManagement", "root", "codeforjava123");
			statement=conn.createStatement();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
