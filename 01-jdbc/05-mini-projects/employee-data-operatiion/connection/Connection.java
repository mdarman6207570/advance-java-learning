package com.task.day02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Program01 {
public static void main(String[] args) {
//Class.forName("com.task.day02.B");
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl", 
					"system", "manager");
	System.out.println(con);
	System.out.println("Connection stablished!!");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
