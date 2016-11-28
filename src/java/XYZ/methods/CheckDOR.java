/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


/**
 *
 * @author yusuk
 */
public class CheckDOR {
    
    public static String checkdor(String member_id) throws SQLException{            
                   
              String queryforDOR = "SELECT * FROM Members WHERE id ='"+member_id+"';";  
              
        ResultSet resultset = OpenConnectionSQL.getData(queryforDOR); 
        
        Date DOR = null;         
        
        if(resultset.next())
        {
            DOR = resultset.getDate("dor");  //get date of register        
        }                        
        
        Calendar today = Calendar.getInstance();  //Get current date/month i.e 27 Feb, 2012                        
        today.add(Calendar.MONTH, -6);   //Go to date, 6 months ago 27 July, 2011
        today.set(Calendar.DAY_OF_MONTH, 1); //set date, to make it 1 July, 2011
        
        Date sixmonthsago =  (Date) today.getTime();
       
       
        if(DOR.before(sixmonthsago) || (DOR.equals(sixmonthsago)))//can claim
        {
            return "Eligible";
        } 
        else if (DOR.after(sixmonthsago))//cannot claim
        {
            return "NotEligible";
        }
       
        return "";
    
}
}


