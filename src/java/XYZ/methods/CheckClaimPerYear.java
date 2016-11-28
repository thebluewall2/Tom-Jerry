/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 *
 * @author yusuk
 */
public class CheckClaimPerYear {
    
    public static String checkclaim(String member_id) throws SQLException
    {                   
        
        String queryforCheckClaim = "SELECT * FROM claims WHERE mem_id ='"+member_id+"';";  
               
        int number=0;
        ResultSet resultset = OpenConnectionSQL.getData(queryforCheckClaim); 
        
        int currentYear = Calendar.getInstance().get((Calendar.YEAR));
        Calendar cal = Calendar.getInstance();
      
        try{
            while(resultset.next())
            {
                Date date = resultset.getDate("date");
                cal.setTime(date);
                
                if(cal.get(Calendar.YEAR) == currentYear)
                {
                    number++;
                }
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
 
        
       if (number<2) 
       {
           
           return "Eligible";
       }
       else if(number==2 || number>2)
       {
           return "NotEligible";           
       }              
                
        return "";        
    }
}
