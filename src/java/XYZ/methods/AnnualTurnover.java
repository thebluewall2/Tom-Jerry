
package XYZ.methods;

import java.sql.*;
import java.util.Calendar;

public class AnnualTurnover {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";

    static final String USER = "root";
    static final String PASS = "";

    public static float[] getAnnualTurnover() 
    {
        Connection con = null;
        Statement statement = null;
        
        //annualTurnover[0] is total income, annualTurnover[1] is total payout
        float[] annualTurnover = new float[2];

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        float totalIncome = 0;
        float totalPayouts = 0;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();         
            String sql_query;
            Calendar cal = Calendar.getInstance();
            
            //get total income first
            
            sql_query = "SELECT * from payments";
            rs = statement.executeQuery(sql_query);
            
            totalIncome = getTotalAmount(rs, cal, currentYear);
            
            //now get total payouts
            
            sql_query = "SELECT * from claims where status='APPROVED'";
            rs = statement.executeQuery(sql_query);
            
            totalPayouts = getTotalAmount(rs, cal, currentYear);
            
            annualTurnover[0] = totalIncome;
            annualTurnover[1] = totalPayouts;

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
        return annualTurnover;
    }

    public static float getTotalAmount(ResultSet rs, Calendar cal, int currentYear) {
        float totalPayouts = 0;

        try {
            while (rs.next()) {
                //converting the sql datetime format to int to be compared with currentYear
                java.sql.Date date = rs.getDate("date");
                cal.setTime(date);

                if (cal.get(Calendar.YEAR) == currentYear) {
                    totalPayouts += rs.getFloat("amount");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPayouts;

    }

}
