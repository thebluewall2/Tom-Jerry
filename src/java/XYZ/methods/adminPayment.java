package XYZ.methods;

import java.sql.Timestamp;

public class adminPayment 
{
    private String id;
    private String memberID;
    private int invoiceNumber;
    private String paymentMethod;
    private float amount;
    private Timestamp date;
    
    public String getID()
    {
        return id;
    }
    
    public String getMemberID() 
    {
        return memberID;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }

    public int getInvoiceNumber() 
    {
        return invoiceNumber;
    }

    public float getAmount() 
    {
        return amount;
    }

    public Timestamp getDate() 
    {
        return date;
    }

    public adminPayment(String id, String memberID, int invoiceNumber, float amount, String paymentMethod, Timestamp date) 
    {
        this.id =id;
        this.memberID = memberID;
        this.invoiceNumber = invoiceNumber;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
    }


    public adminPayment(String id,String userName, int invoiceNumber, float amount, String paymentMethod) 
    {
        this.id = id;
        this.memberID = memberID;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    
   
}