package com.nt.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb",
                "root",
                "password"
        );
    }
}
