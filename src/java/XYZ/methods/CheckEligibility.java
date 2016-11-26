/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author yusuk
 */
public class CheckEligibility {
    
    public static String check(String mem_id) throws SQLException{            
        
        String query ="SELECT dor FROM members WHERE id='"+mem_id+"'";
        ResultSet rs = OpenConnectionSQL.getData(query);        
        
        
        Date DOR = rs.getDate("dor");                          
                  
        Calendar sixmonthsago = Calendar.getInstance();  //Get current date/month i.e 27 Feb, 2012                        
        sixmonthsago.add(Calendar.MONTH, -6);   //Go to date, 6 months ago 27 July, 2011
        sixmonthsago.set(Calendar.DAY_OF_MONTH, 1); //set date, to make it 1 July, 2011
        
        Date DateSixMonthsAgo =  (Date) sixmonthsago.getTime();
       
        if(DOR.before(DateSixMonthsAgo) || (DOR.equals(DateSixMonthsAgo)))//can claim
        {
            return "Eligible";
        } 
        else if (DOR.after(DateSixMonthsAgo))//cannot claim
        {
            return "NotEligible";
        }
        else
        return "Error";
    }
}


