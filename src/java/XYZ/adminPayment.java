package XYZ;

import java.sql.Timestamp;

public class adminPayment 
{
    private String userName;
    private int invoiceNumber;
    private String paymentMethod;
    private float amount;
    private Timestamp date;
    private String cash;
    private String status;

    public adminPayment(String userName, int invoiceNumber, float amount, String paymentMethod, Timestamp date, String cash, String status) 
    {
        this.invoiceNumber = invoiceNumber;
        this.userName = userName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.cash = cash;
        this.status = status;
    }

    public adminPayment(String userName, int invoiceNumber, float amount, String paymentMethod, Timestamp date) 
    {
        this.invoiceNumber = invoiceNumber;
        this.userName = userName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
    }

    public adminPayment(String userName, int invoiceNumber, float amount, String paymentMethod) 
    {
        this.userName = userName;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public String getUserName() 
    {
        return userName;
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
    
    public String getStatus() 
    {
        return status;
    }

    public String getCash() 
    {
        return cash;
    }
   
}