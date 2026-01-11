package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_TableCreation
{
    public static void main(String[] args) 
    {
        String className = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "arman";
        String password = "rohan";

        String createProductTable = """
                CREATE TABLE product (
                    id NUMBER PRIMARY KEY,
                    name VARCHAR2(50),
                    price NUMBER(10,2),
                    quantity NUMBER
                )
                """;

        try {
            // Load Oracle Driver
            Class.forName(className);
            System.out.println("Driver loaded successfully!");

            // Create connection
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
          
            try (con;stmt)
            {
                System.out.println("Connection created!");
                System.out.println("Statement created!");

                stmt.execute(createProductTable);
                System.out.println("Product table created successfully!");

            } // Auto-closes stmt and con here

        }
        catch (ClassNotFoundException e) 
        {
            System.out.println("Oracle Driver not found!");
            e.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
