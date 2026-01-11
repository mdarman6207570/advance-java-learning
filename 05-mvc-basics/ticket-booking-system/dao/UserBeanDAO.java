package implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection_provider.DBConnect;

public class UserBeanDAO 
{

    public int verify(String uname, String upwd) 
    {
        int result = 0;

        try (Connection con = DBConnect.getConnection()) 
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM validation WHERE username=? AND password=?");
            ps.setString(1, uname);
            ps.setString(2, upwd);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                result = 1; 
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        return result; 
    }
}
