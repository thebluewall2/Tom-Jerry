package XYZ.methods;

import java.sql.Timestamp;

public class userPayment {
    
    private String memberID;
    private float amount;
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

    public userPayment(String memberID, String firstName, String lastName, int invoiceNumber, String paymentMethod, Timestamp paymentDate, float amount) 
    {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    
    public userPayment(String memberID, float amount, String status, String cash) 
    {
        this.memberID = memberID;
        this.amount = amount;
    }

    public String getMemberID() 
    {
        return memberID;
    }

    public float getAmount() 
    {
        return amount;
    }

}