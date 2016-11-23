package XYZ.methods;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckPayment {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";

    static final String USER = "root";
    static final String PASS = "";


    public static float checkPayment(String memberID) {
        Connection con = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();
            
            String sql_query = "SELECT balance from members where id='" + memberID + "' LIMIT 1";
            ResultSet rs = statement.executeQuery(sql_query);

            rs.next();
            
            return rs.getFloat("balance");

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
        return -1;
    }

}
