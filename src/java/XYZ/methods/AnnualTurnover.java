package XYZ.methods;

import java.sql.*;
import java.util.Calendar;

public class AnnualTurnover {

    public static double[] getAnnualTurnover() {
        //annualTurnover[0] is total income, annualTurnover[1] is total payout
        double[] annualTurnover = new double[3];

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        double totalIncome = 0;
        double totalPayouts = 0;
        int totalMembers = 0;
        ResultSet rs;

        Calendar cal = Calendar.getInstance();

        //get total income first
        String sql_query = "SELECT * from payments";
        rs = OpenConnectionSQL.getData(sql_query);

        totalIncome = getTotalAmount(rs, cal, currentYear);

        //now get total payouts
        sql_query = "SELECT * from claims where status='APPROVED'";
        rs = OpenConnectionSQL.getData(sql_query);

        totalPayouts = getTotalAmount(rs, cal, currentYear);
        
        sql_query = "SELECT count(*) from members where status='APPROVED'";
        rs = OpenConnectionSQL.getData(sql_query);
        
        try {
            rs.next();
            totalMembers = rs.getInt("count(*)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        annualTurnover[0] = totalIncome;
        annualTurnover[1] = totalPayouts;
        annualTurnover[2] = totalMembers;
        
        OpenConnectionSQL.closeConn();
        OpenConnectionSQL.closeResultSet();

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
