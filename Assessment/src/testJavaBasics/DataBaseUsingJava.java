package testJavaBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUsingJava {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection DBConnect = DriverManager.getConnection("jdbc:mysql://root@localhost/javaselenium_database");
		
	Statement Createsql= 	DBConnect.createStatement();
	
	ResultSet ExecuteQuery = Createsql.executeQuery("select * from loginpage");
	
	while(ExecuteQuery.next()) {
		System.out.println("ID : "+ExecuteQuery.getInt(1)+" UserName : "+ExecuteQuery.getString(2)+" Password : "+ExecuteQuery.getString(3));
	}
	
	}

}
