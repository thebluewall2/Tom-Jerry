/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

/**
 *
 * @author Adrian
 */
public class ReapproveUser {
     public static void reapproveUser (String memberID) {
        String query = "UPDATE Members SET status='APPROVED' WHERE id='"+memberID+"';";
        OpenConnectionSQL.executeQuery(query);
        
        query = "UPDATE users SET status='APPROVED' WHERE id='" + memberID + "';";
        OpenConnectionSQL.executeQuery(query);
    }
}
