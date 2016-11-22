/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author yusuk
 */
public class OpenConnectionSQL {
    
    //mysql username pw
    static String user = "root";
    static String password = "";
    Connection connection = null;
    
    public OpenConnectionSQL()
    {
        
    }
    
    public void OpenConnectionSQL() //String user, String password
    {
        Connection conn = null;
        Statement stmt = null;
//        String user = "root";
//        String password = "";
        
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println(e);                
		e.printStackTrace();
		return;
	}

        try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz_assoc",user, password);

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

        if (conn != null) {
		System.out.println("You made it, take control your database now!");
                
            // METHOD how to get data from mysql
     try{
                    stmt = conn.createStatement();                    
                    String sql;
                    sql = "SELECT * FROM members;";               
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    while(rs.next())
                    {
                        System.out.println(rs.getString("id"));
                        System.out.println(rs.getString("name"));
                        System.out.println(rs.getString("address"));
                        System.out.println(rs.getString("dob"));
                        System.out.println(rs.getString("dor"));
                        System.out.println(rs.getString("status"));
                        System.out.println(rs.getString("balance"));
                        
                    }
                }catch(Exception e)
                {
                    System.out.println(e);
        
            }
        }
        else
                System.out.println("Connection failure");
    }

    
  public void CloseConn()
{
    try{
    connection.close();
    }catch(Exception e)
    {
        
    }
}
  
  
}

