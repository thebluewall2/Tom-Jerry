package XYZ.methods;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenConnectionSQL {

    static String user = "root";
    static String password = "";
    static String db_url = "jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void OpenConnection() //String user, String password
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, user, password);

            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String sql_query) {

        try {
            OpenConnection();
            stmt.executeUpdate(sql_query);
            closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet getData(String sql_query) {
        OpenConnection();

        try {
            rs = stmt.executeQuery(sql_query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public static void closeResultSet() {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
}
