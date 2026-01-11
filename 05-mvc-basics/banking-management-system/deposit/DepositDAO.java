package deposit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import connection.DBConnect;
import bean.BankBean;

public class DepositDAO {

    public boolean deposit(BankBean bean) {
        boolean result = false;
        Connection con = null;
        PreparedStatement updateAccount = null;
        PreparedStatement insertTxn = null;

        try 
        {
            con = DBConnect.getConnection();
            con.setAutoCommit(false); // Transactional

            // 1. Update account balance
            updateAccount = con.prepareStatement(
                "UPDATE bankaccount SET accbal = accbal + ? WHERE accno = ?"
            );
            updateAccount.setDouble(1, bean.getDepositAmount());
            updateAccount.setString(2, bean.getAccno());
            int rows = updateAccount.executeUpdate();

            if(rows == 1) {
                // 2. Record transaction
                String txnId = java.util.UUID.randomUUID().toString();
                insertTxn = con.prepareStatement(
                    "INSERT INTO transaction (accno, transactionid, transactiontime, amount) VALUES (?, ?, ?, ?)"
                );
                insertTxn.setString(1, bean.getAccno());
                insertTxn.setString(2, txnId);
                insertTxn.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                insertTxn.setDouble(4, bean.getDepositAmount());

                int txnRows = insertTxn.executeUpdate();

                if(txnRows == 1) {
                    con.commit();
                    result = true;
                } else {
                    con.rollback();
                }
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources...
            try { if(insertTxn != null) insertTxn.close(); } catch(Exception e) {}
            try { if(updateAccount != null) updateAccount.close(); } catch(Exception e) {}
            try { if(con != null) con.close(); } catch(Exception e) {}
        }
        return result;
    }
}
