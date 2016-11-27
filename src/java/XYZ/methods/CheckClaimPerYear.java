/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.ResultSet;

/**
 *
 * @author yusuk
 */
public class CheckClaimPerYear {
    
    public static String checkclaim(int number)
    {                                      
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
