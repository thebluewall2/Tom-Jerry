/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author yusuk
 */
public class AddClaim {
    public AddClaim(){
        
    }
    
    public boolean AddClaimtoDB(Double d,String string)
    {
       OpenConnectionSQL openconn = new OpenConnectionSQL();
       
      // create a Statement from the connection
        

        // insert the data
        try{
//            String query = "INSERT INTO claims ('id', 'mem_id', 'date', 'rationale', 'status', 'amount')" +
//                                    "VALUES ('4', 'liewsoonhen', '2015-12-12', 'Just need more money', 'APPROVED' '100')";
            
            Statement statement = openconn.connection.createStatement();
            
//            statement.executeUpdate(SQLStatment);
//              statement.executeQuery(query);
       
                // the mysql insert statement
               String query = " insert into claims (id, mem_id, date, rationale, status, amount)"
                 + " values (?, ?, ?, ?, ?, ?)";

               // create the mysql insert preparedstatement
               PreparedStatement preparedStmt = openconn.connection.prepareStatement(query);
               preparedStmt.setString (1, "4");
               preparedStmt.setString (2, "liewsoonhen");
               preparedStmt.setString (3, "2015-12-12");
               preparedStmt.setString (4, "Just need more money");
               preparedStmt.setString (5, "APPROVED");
               preparedStmt.setInt    (6, 100);

         // execute the preparedstatement
         preparedStmt.execute();


            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
       //close sql connection
       openconn.CloseConn();
       
       return true;//return to servlet
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