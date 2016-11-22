package XYZ.methods;

import java.sql.*;

public class Login {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static String verifyLogin(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            String sql_query = "SELECT * from users";
            ResultSet rs = stmt.executeQuery(sql_query);
            
            while (rs.next()) {
                String id = rs.getString("id");
                String pass = rs.getString("password");
                
                if (username.equals(id) && password.equals(pass)) {
                    return rs.getString("status");
                }   
            }
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) 
                    conn.close();
            } catch (SQLException e) {
                //do nothing
            }
            
            try {
                if (conn != null) {
                    conn.close();
                } 
            } catch (SQLException e) {
                //do nothing
            }
        }
        
        
        
        return "non-member";
        
    }
    
    
}
