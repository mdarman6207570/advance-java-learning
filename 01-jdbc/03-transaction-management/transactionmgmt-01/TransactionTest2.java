package com.nt.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionTest2 {

    public static void main(String[] args) {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb",
                    "root",
                    "password");

            con.setAutoCommit(false);  // TX begin

            Statement st = con.createStatement();
            st.executeUpdate(
              "UPDATE account SET balance=balance-500 WHERE accno=101");

            // ERROR: wrong column name (forces rollback)
            st.executeUpdate(
              "UPDATE account SET balanc=balance+500 WHERE accno=102");

            con.commit();
            System.out.println("Transaction Success");

        } catch (Exception e) {
            try {
                con.rollback();  // rollback
                System.out.println("Transaction Rolled Back");
            } catch (Exception ex) {}
            e.printStackTrace();
        }
    }
}
