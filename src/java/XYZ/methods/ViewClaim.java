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
public class ViewClaim {
     
    Statement stmt = null;
    ResultSet rs = null;
    
    public ViewClaim(){
        
    }
    
    public String ListClaim(String memb_id){
        
        OpenConnectionSQL openconn = new OpenConnectionSQL();
       
        openconn.OpenConnection();
               
        try{            
            String query = "SELECT * FROM claims WHERE mem_id ='"+ memb_id +"' ";
                
    
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        String createtable = "";//output table
        
              
        return createtable;
    }
}
