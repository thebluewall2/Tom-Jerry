package XYZ.methods;

import java.sql.*;

public class CheckPayment {

    public static float checkPayment(String memberID) {

        String sql_query = "SELECT balance from Members where id='" + memberID + "' LIMIT 1";
        ResultSet rs = OpenConnectionSQL.getData(sql_query);
        float balance = 0;

        try {
            rs.next();
            balance = rs.getFloat("balance");
            
            OpenConnectionSQL.closeConn();
            OpenConnectionSQL.closeResultSet();
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return balance;
    }

}
