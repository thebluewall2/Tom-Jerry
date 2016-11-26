/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

/**
 *
 * @author yusuk
 */
public class Approval {
  
    public static void ClaimApproval(String id){
        
        String query = "UPDATE claims SET status='APPROVED' WHERE id='"+id+"';";
        
        OpenConnectionSQL.executeQuery(query);
        
        
    }
    
}
