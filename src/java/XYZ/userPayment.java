package XYZ;

import java.sql.Timestamp;

public class userPayment {
    
    private String userName;
    private float amount;
    private String status;
    private String cash;
    private String firstName;
    private String lastName;
    private int invoiceNumber;
    private String paymentMethod;
    private Timestamp paymentDate;

    public Timestamp getPaymentDate() 
    {
        return paymentDate;
    }

    public int getInvoiceNumber() 
    {
        return invoiceNumber;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }

    public userPayment(String firstName, String lastName, int invoiceNumber, String paymentMethod, Timestamp paymentDate, float amount, String status, String cash) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.status = status;
        this.cash = cash;
        this.invoiceNumber = invoiceNumber;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    
    public userPayment(String userName, float amount, String status, String cash) 
    {
        this.userName = userName;
        this.amount = amount;
        this.status = status;
        this.cash = cash;
    }

    public String getUserName() 
    {
        return userName;
    }

    public float getAmount() 
    {
        return amount;
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