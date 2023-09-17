package Package01;

import java.sql.*;

public class ConnClass 
{
	Connection conn;
	Statement statement;
	public ConnClass()
	{
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql:///bank", "root", "codeforjava123");
			statement=conn.createStatement();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
