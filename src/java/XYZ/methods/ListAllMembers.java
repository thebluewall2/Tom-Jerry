package XYZ.methods;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListAllMembers {

    private String id;
    private String name;
    private String address;
    private Date dob;
    private Date dor;
    private String status;
    private float balance;

    public ResultSet ListMembers() {
        String query = "Select * from Members;";

        ResultSet rs = OpenConnectionSQL.getData(query);

        return rs;
    }
    
    public ResultSet ListMembersWithOutstandingBalances() {
        String query = "SELECT * from Members where balance > 0";
        
        ResultSet rs = OpenConnectionSQL.getData(query);
        
        return rs;
    }

    public ResultSet ListProvisionalMembers() {
        String query = "SELECT * from Members where status='APPLIED'";
        
        ResultSet rs = OpenConnectionSQL.getData(query);
        
        return rs;
    }
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDor() {
        return dor;
    }

    public void setDor(Date dor) {
        this.dor = dor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
