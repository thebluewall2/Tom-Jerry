package XYZ.methods;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserPayment {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";

    static final String USER = "root";
    static final String PASS = "";

    public static void userPayment(String memberID, String paymentMethod, float amount) {
        Connection con = null;
        Statement statement = null;

        Date date = new Date();
        java.sql.Date paymentDate = new java.sql.Date(date.getTime());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();

            String sql_query = "INSERT into payments (mem_id, type_of_payment, amount, date) "
                    + "VALUES ('" + memberID + "', '" + paymentMethod + "', " + amount
                    + ", '" + paymentDate + "')";

            statement.executeUpdate(sql_query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

        }

    }

}
