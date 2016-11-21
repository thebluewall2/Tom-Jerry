package XYZ.methods;

import java.sql.*;

public class userPayment {
    
    private String id;
    private String memberID;
    private float amount;
    private String firstName;
    private String lastName;
    private int invoiceNumber;
    private String paymentMethod;
    private Timestamp paymentDate;
    
    static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/XYZ_Assoc?autoReconnect=true&useSSL=false";
    
    static final String USER ="root";
    static final String PASS ="aaaaa1";
            

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
    
    public String getMemberID() 
    {
        return memberID;
    }

    public float getAmount() 
    {
        return amount;
    }
    
    public String getID()
    {
        return id;
    }


    public userPayment(String id, String memberID, String firstName, String lastName, int invoiceNumber, String paymentMethod, Timestamp paymentDate, float amount) 
    {
        this.id = id;
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        
    }

    
    public userPayment(String id, String memberID, float amount, String status, String cash) 
    {
        this.id=id;
        this.memberID = memberID;
        this.amount = amount;
    }
    
    public static boolean userPayment (String userID, String memberID, String paymentMethod, float amount, Timestamp paymentDate)
    {
        Connection con = null;
        Statement statement = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER,PASS);
            statement = con.createStatement();
            
            String sql_query = "SELECT * from payments";
            ResultSet resultSet = statement.executeQuery(sql_query);
            
            while (resultSet.next())
            {
                String id = resultSet.getString("id");
                String mem_id = resultSet.getString("mem_id");
                String typeOfPayment = resultSet.getString("type_of_payment");
                String amountToPay = resultSet.getString("amount");
                String date = resultSet.getString("date");
                return true;
            }
                
        }
        
        catch (SQLException e)
        {
            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally 
        {
            try
            {
                if (statement != null)
                    con.close();
            }catch(SQLException e)
            {
                
            }
        }
        
        try
        {
            if (con != null)
            {
                con.close();
            }
        }catch (SQLException e)
        {
            
        }
        return false;
        
        
    
    }


}