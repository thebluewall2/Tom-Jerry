/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class ListAllMembers {
    private String id;
    private String name;
    private String address;
    private Date dob;
    private Date dor;
    private String status;
    private float balance;
    
    
     public ResultSet ListMembers() {
         String query = "Select * from Members;";
         
          ResultSet rs = OpenConnectionSQL.getData(query);
          
          return rs;
     }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDor() {
        return dor;
    }

    public void setDor(Date dor) {
        this.dor = dor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
   
    
    
//        static ResultSet rs = null;
//    static Connection conn = null;
//    static Statement stmt = null;
//    
//    public static String listAllUsers() throws SQLException {
////        conn =  OpenConnectionSQL.OpenConnectionReturnConn();
//        String sql_query = "SELECT * from users";
//        rs = OpenConnectionSQL.getData(sql_query);
//        
//        return makeTable(rsToList(rs));
//    }
//    
//     private static ArrayList rsToList(ResultSet rs) throws SQLException {
//        ArrayList aList = new ArrayList();
//
//        int cols = rs.getMetaData().getColumnCount();
//        while (rs.next()) { 
//          String[] s = new String[cols];
//          for (int i = 1; i <= cols; i++) {
//            s[i-1] = rs.getString(i);
//          } 
//          aList.add(s);
//        } // while    
//        return aList;
//    } //rsToList
// 
//    private static String makeTable(ArrayList list) {
//        StringBuilder b = new StringBuilder();
//        String[] row;
//        b.append("<table border=\"3\">");
//        for (Object s : list) {
//          b.append("<tr>");
//          row = (String[]) s;
//            for (String row1 : row) {
//                b.append("<td>");
//                b.append(row1);
//                b.append("</td>");
//            }
//          b.append("</tr>\n");
//        } // for
//        b.append("</table>");
//        return b.toString();
//    }//makeHtmlTable
}
