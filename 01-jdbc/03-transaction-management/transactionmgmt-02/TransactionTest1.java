package com.nt.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nt.util.DBConnection;

public class TransactionTest1 {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getCon()) {

            con.setAutoCommit(false);   // start transaction

            PreparedStatement ps1 =
              con.prepareStatement("UPDATE account SET balance=balance-1000 WHERE accno=101");
            ps1.executeUpdate();

            PreparedStatement ps2 =
              con.prepareStatement("UPDATE account SET balance=balance+1000 WHERE accno=102");
            ps2.executeUpdate();

            con.commit();   // success
            System.out.println("Transaction Completed");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Transaction Failed");
        }
    }
}
