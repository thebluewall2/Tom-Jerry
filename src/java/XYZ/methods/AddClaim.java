/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yusuk
 */
public class AddClaim {
    
    Statement stmt = null;
    
    public AddClaim(){
        
    }
    
    public String AddClaimtoDB(int ClaimAmount,String ClaimReason)
    {
       
       OpenConnectionSQL openconn = new OpenConnectionSQL();
       
        openconn.OpenConnection();
      // create a Statement from the connection
        
        
        // insert the data
        try{
//           stmt = (Statement)openconn.conn.createStatement();                   
//           String query = "INSERT INTO claims (id, mem_id, date, rationale, status, amount) values (5, 'happyman', '2015-12-11', 'i dont know', 'SUSPENDED', 1000)";            
           
        int id;
        String mem_id;
        String date;
        String rationale;
        String status;
        int amount;

       String query = "INSERT INTO claims"
				+ "(id, mem_id, date, rationale, status, amount) "
               + "VALUES (?,?,?,?,?,?)";
          
        PreparedStatement ps = null;
       ps = openconn.conn.prepareStatement(query);
//       String query2 = "SELECT * from claims ";


       id = 5;
       mem_id = "happyman";
       date = "2015-12-11";
       status = "SUSPENDED";
       rationale = ClaimReason;
       amount = ClaimAmount;
       
                ps.setInt(1, id);
		ps.setString(2, mem_id);
		ps.setString(3, date);
		ps.setString(4, rationale);
                ps.setString(5, status);
                ps.setInt(6, amount);
                
		// execute insert SQL stetement
		ps.executeUpdate();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
       //close sql connection
       openconn.CloseConn();
       
       return "success";//return to servlet
    }
}


// METHOD how to get data from mysql
//     try{
//                    stmt = conn.createStatement();                    
//                    String sql;
//                    sql = "SELECT * FROM members;";               
//                    ResultSet rs = stmt.executeQuery(sql);
//                    
//                    while(rs.next())
//                    {
//                        System.out.println(rs.getString("id"));
//                        System.out.println(rs.getString("name"));
//                        System.out.println(rs.getString("address"));
//                        System.out.println(rs.getString("dob"));
//                        System.out.println(rs.getString("dor"));
//                        System.out.println(rs.getString("status"));
//                        System.out.println(rs.getString("balance"));
//                        
//                    }
//                }catch(Exception e)
//                {
//                    System.out.println(e);
//                }