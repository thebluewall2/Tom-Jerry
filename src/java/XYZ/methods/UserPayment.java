package XYZ.methods;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserPayment {


    public static void userPayment(String memberID, String paymentMethod, float amount) {
        Date date = new Date();
        float balance = 0;
        java.sql.Date paymentDate = new java.sql.Date(date.getTime());

            String sql_query = "INSERT into payments (mem_id, type_of_payment, amount, date) "
                    + "VALUES ('" + memberID + "', '" + paymentMethod + "', " + amount
                    + ", '" + paymentDate + "')";

            OpenConnectionSQL.executeQuery(sql_query);
            
            sql_query = "SELECT balance from Members where id='" + memberID + "' LIMIT 1";
            ResultSet rs = OpenConnectionSQL.getData(sql_query);
            
            try {
                rs.next();
                balance = rs.getInt("balance");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            sql_query = "UPDATE Members SET balance='" + (balance - amount) + "' WHERE id='" + memberID + "'";
            OpenConnectionSQL.executeQuery(sql_query);
            
            OpenConnectionSQL.closeConn();
    }

}
