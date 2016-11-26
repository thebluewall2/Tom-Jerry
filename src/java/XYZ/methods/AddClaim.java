/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yusuk
 */
public class AddClaim {
    
    Statement stmt = null;
    ResultSet rs = null;
    
    public String AddClaimtoDB(String mem_id,int ClaimAmount,String ClaimReason)
    {
       
       OpenConnectionSQL openconn = new OpenConnectionSQL();
       
        openconn.OpenConnection();
        
        // insert the data
        try{
         
        String query = "INSERT INTO claims (mem_id, date, rationale, status, amount) VALUES (?,now(),?,?,?)";
          
        PreparedStatement ps = null;
        ps = openconn.conn.prepareStatement(query);
                                                                  
		ps.setString(1, mem_id);		
		ps.setString(2, ClaimReason);                
                ps.setString(3, "SUBMITTED");
                ps.setInt(4, ClaimAmount);
                
                
		// execute insert SQL stetement
		ps.executeUpdate();
                

        }catch(Exception e)
        {
            System.out.println(e);
        }
        
       //close sql connection
       openconn.closeConn();
       
       return "success";//return to servlet with success string to determind successfully added claim
    }
}

