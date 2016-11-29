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
public class Suspend {
    public static void suspendUser (String memberID) {
        String query = "UPDATE Members SET status='SUSPENDED' WHERE id='"+memberID+"';";
        OpenConnectionSQL.executeQuery(query);
        
        query = "UPDATE users SET status='SUSPENDED' WHERE id='"+memberID+"';";
        OpenConnectionSQL.executeQuery(query);
    }
}
