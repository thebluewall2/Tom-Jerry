package XYZ.methods;

import java.sql.*;

public class Login {

    public static String verifyLogin(String username, String password) {

        String sql_query = "SELECT * from users";
        ResultSet rs = OpenConnectionSQL.getData(sql_query);

        try {
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
            OpenConnectionSQL.closeConn();
            OpenConnectionSQL.closeResultSet();
        }

        return "non-member";

    }

}
