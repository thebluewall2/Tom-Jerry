package XYZ.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUp {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "aaaaa1";
    
    public static void main(String[] args) {
        SignUpNewMember("James Bond", "12", "30/03/1995");
    }
    
    public static void SignUpNewMember(String name, String address, String dateOfBirth) {

        String username = generateUsername(name);
        String password = generatePassword(dateOfBirth);

        Connection conn = null;
        Statement stmt = null;

        //get today's date and convert to sql date format for DOR
        Date date = new Date();
        java.sql.Date dor = new java.sql.Date(date.getTime());

        //convert dateOfBirth to String, and to sql date format for dob
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = null;
        try {
            birthDate = df.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dob = new java.sql.Date(birthDate.getTime());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql_query = "INSERT into users "
                    + "VALUES ('" + username + "', '" + password + "', " + "'APPLIED')";
            System.out.println(sql_query);
            stmt.executeUpdate(sql_query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
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

    }

    public static String generateUsername(String name) {
        String username;
        String[] splitter = name.split(" ", 2);
        splitter[0] = splitter[0].substring(0, 2);
        splitter[0] = splitter[0].concat("-");

        username = splitter[0].concat(splitter[1]);
        username = username.toLowerCase();

        return username;
    }

    public static String generatePassword(String dob) {
        String[] splitter = dob.split("/", 3);
        splitter[2] = splitter[2].substring(2, 4);

        String password = splitter[0].concat(splitter[1]);
        password = password.concat(splitter[2]);

        return password;
    }

}
