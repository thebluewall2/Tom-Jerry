/*package XYZ;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import XYZ.userPayment;
import XYZ.adminPayment;
import XYZ.PaymentStatus;

public class databaseConnection 
{

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    public databaseConnection() 
    {
        
    }

    public void connection(Connection connection) 
    {
        connection = connection;
    }

    private ArrayList rsToList() throws SQLException {
        ArrayList aList = new ArrayList();

        int cols = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            String[] s = new String[cols];
            for (int i = 1; i <= cols; i++) {
                s[i - 1] = rs.getString(i);
            }
            aList.add(s);
        } // while    
        return aList;
    } //rsToList

    private String makeTable(ArrayList list) {
        StringBuilder b = new StringBuilder();
        String[] row;
        b.append("<table border=\"3\">");
        for (Object s : list) {
            b.append("<tr>");
            row = (String[]) s;
            for (String row1 : row) {
                b.append("<td>");
                b.append(row1);
                b.append("</td>");
            }
            b.append("</tr>\n");
        } // for
        b.append("</table>");
        return b.toString();
    }//makeHtmlTable

    private void select(String query) {
        //Statement statement = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //statement.close();
        } catch (SQLException e) {
            System.out.println("way way" + e);
            //results = e.toString();
        }
    }

    private boolean insertMembershipFeeCharge(String userName) {
        PreparedStatement ps = null;

        int result = -1;
        try {
            ps = connection.prepareStatement("INSERT INTO payment (`userName`, `amount`, `status`, `cash`) VALUES (?,?,?,?)", Statement.SUCCESS_NO_INFO);
            ps.setString(1, userName);
            ps.setFloat(2, 2.0f);
            ps.setString(3, PaymentStatus.DUE.toString());
            ps.setString(4, "REGISTRATION FEE");
            result = ps.executeUpdate();
            ps.close();

            if (result == 1) {
                System.out.println("Details updated!");
            } else {
                return false;
            }

        } catch (SQLException ex) {
        }
        return true;
    }

    
    public adminPayment insertPayment(adminPayment payment) {
        PreparedStatement ps = null;

        String userName = payment.getUserName();
        int invoiceNumber = payment.getInvoiceNumber();
        float amount = payment.getAmount();
        java.sql.Timestamp date = payment.getDate();

        adminPayment responsePayment = null;

        try 
        {
            ps = connection.prepareStatement("INSERT INTO payments (`userName`, `invoiceNumber`, `amount`, `paymentMethod`, `date`) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userName);
            ps.setInt(2, invoiceNumber);
            ps.setFloat(3, amount);
            ps.setString(4, payment.getPaymentMethod());
            ps.setTimestamp(5, date);
            ps.executeUpdate();

            ResultSet key = ps.getGeneratedKeys();
            key.next();
            int result = key.getInt(1);
            ps.close();

            updateChargeStatus(invoiceNumber, PaymentStatus.PENDING);

            //get inserted payment        
            ps = connection.prepareStatement("SELECT * FROM payments WHERE id = ?");
            ps.setInt(1, result);
            ResultSet rs = ps.executeQuery();
            rs.next();
            responsePayment = new adminPayment(rs.getString("userName"), rs.getInt("invoiceNumber"), rs.getFloat("amount"), rs.getString("paymentMethod"), rs.getTimestamp("date"));

        } catch (SQLException ex) {
        }

        return responsePayment;
    }

    public List<adminPayment> getUnpaidChargesForUser(String userName) 
    {
        List<adminPayment> resultList = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM payment WHERE userName = ? AND status = ? OR status = ?");
            ps.setString(1, userName);
            ps.setString(2, PaymentStatus.DUE.toString());
            ps.setString(3, PaymentStatus.DECLINED.toString());
            ResultSet rs = ps.executeQuery();
            
            resultList<adminPayment> = new ArrayList<>();
            while (rs.next()) {
                resultList.add(new Charge(rs.getInt("id"), rs.getInt("user_id"), rs.getFloat("amount"), rs.getString("status"), rs.getString("note")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultList;
    }

    public List<userPayment> getChargesWhereStatus(PaymentStatus status) {

        List<userPayment> resultList = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT charges.id,members.name,charges.amount, payments.id as payment_id, payments.payment_type, payments.date as payment_date, charges.status,charges.note FROM charges JOIN members ON charges.user_id = members.id JOIN payments on charges.id = payments.charge_id WHERE charges.status = ?");
            ps.setString(1, status.toString());
            ResultSet rs = ps.executeQuery();
            resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(new Charge(rs.getInt("id"), rs.getString("name"), rs.getInt("payment_id"), rs.getString("payment_type"), rs.getTimestamp("payment_date"), rs.getFloat("amount"), rs.getString("status"), rs.getString("note")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultList;
    }

    public List<adminPayment> getAllPaymentsForUser(String userName) {

        List<adminPayment> resultList = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT payments.id,payments.mem_id,payments.charge_id,payments.payment_type,payments.amount,payments.date,charges.note,charges.status FROM payments JOIN charges ON payments.charge_id = charges.id WHERE mem_id = ?");
            ps.setInt(1, userName);
            ResultSet rs = ps.executeQuery();
            resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(new Payment(rs.getInt("id"), rs.getInt("mem_id"), rs.getInt("charge_id"), rs.getFloat("amount"), rs.getString("payment_type"), rs.getTimestamp("date"), rs.getString("note"), rs.getString("status")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultList;
    }

 
    public userPayment getCharge(int chargeId) {

        userPayment result = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM charges WHERE id = ?");
            ps.setInt(1, chargeId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = new userPayment(rs.getString("userName"), rs.getFloat("amount"), rs.getString("status"), rs.getString("cash"));

        } catch (SQLException ex) {
        }

        return result;
    }
    
    int getDueOrDeclinedChargeCount(int userId) {
        int count = -1;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(id) FROM charges WHERE user_id = ? AND status != ?");
            ps.setInt(1, userId);
            ps.setString(2, PaymentStatus.APPROVED.toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
        }

        return count;
    }

    void insertCharge(int userId, float amount, String note) {
        PreparedStatement ps = null;

        try {
            //insert charge
            ps = connection.prepareStatement("INSERT INTO charges (`user_id`, `amount`, `note`, `status`) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setFloat(2, amount);
            ps.setString(3, note);
            ps.setString(4, PaymentStatus.DUE.toString());
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
        }
    }

  

    public List<adminPayment> getPayments() {
        List<adminPayment> resultList = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT payments.id,payments.mem_id,payments.charge_id,payments.payment_type,payments.amount,payments.date,charges.note,charges.status FROM payments JOIN charges ON payments.charge_id = charges.id");
            ResultSet resultSet = ps.executeQuery();
            resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new adminPayment(resultSet.getString("userName"),resultSet.getInt("invoiceNumber"), resultSet.getFloat("amount"), resultSet.getString("paymentMethod"), resultSet.getTimestamp("date"), resultSet.getString("cash"), resultSet.getString("status")));
            }
        } catch (SQLException ex) {
        }
        return resultList;
    }

}*/