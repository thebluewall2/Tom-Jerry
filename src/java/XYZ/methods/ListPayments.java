package XYZ.methods;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListPayments {
    int paymentID;
    String paymentType;
    double paymentAmount;
    Date paymentDate;
    
    public static List getAllPayments(String memberID) {
        String sql_query = "SELECT * from payments where mem_id='" + memberID + "' order by id desc";
        List <ListPayments> paymentList = new ArrayList<ListPayments>();
        ResultSet rs = OpenConnectionSQL.getData(sql_query);
        
        try {
            while (rs.next()) {
                ListPayments newPayment = new ListPayments();
                
                newPayment.setPaymentID(rs.getInt("id"));
                newPayment.setPaymentType(rs.getString("type_of_payment"));
                newPayment.setPaymentAmount(rs.getDouble("amount"));
                newPayment.setPaymentDate(rs.getDate("date"));
                
                paymentList.add(newPayment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return paymentList;
    }
    
    public void setPaymentID(int id) {
        paymentID = id;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public int getPaymentID() {
        return paymentID;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    public double getPaymentAmount() {
        return paymentAmount;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }
    
}
