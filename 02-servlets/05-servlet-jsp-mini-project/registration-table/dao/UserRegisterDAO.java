package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegisterDAO 
{
    public int insertRecord(UserBean ub)
    {
        String query = "INSERT INTO registration (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, MAILID, PHONE) VALUES(?,?,?,?,?,?)";
        int rowCount = 0;
        
        try
        {
            Connection con = DBConnect.connect();
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, ub.getU_name());
            pstmt.setString(2, ub.getU_password());
            pstmt.setString(3, ub.getU_fname());
            pstmt.setString(4, ub.getU_lname());
            pstmt.setString(5, ub.getU_mail());
            pstmt.setString(6, ub.getU_phone());
            
            rowCount = pstmt.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error inserting record: " + e.getMessage());
        }
        
        return rowCount;
    }
}
