/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Adrian
 */
public class MembershipStatus {
    public static String getMembershipStatus(String username) {
        String membershipStatus = "";
        
        try {
       
            String sql_query = "SELECT status, expiry from users where id =" + "'" + username + "'";
            ResultSet rs = OpenConnectionSQL.getData(sql_query); 
            
            rs.next(); 
            membershipStatus = rs.getString("status");                      
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return membershipStatus;
    }
}
