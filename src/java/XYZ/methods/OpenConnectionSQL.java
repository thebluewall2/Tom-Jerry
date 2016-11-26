/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author yusuk
 */
public class OpenConnectionSQL {
    
    //mysql username pw
    static String user = "root";
    static String password = "password";
    static Connection conn = null;

    
    public OpenConnectionSQL()
    {
        
    }
    
    public void OpenConnection() //String user, String password
    {        
        
        try {
            
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz_assoc",user, password);
                
        if (conn != null) 
        {                
                System.out.println("You made it, take control your database now!");
        }
        else 
        {
               System.out.println("Connection failure");
        }
        
            }catch(Exception e)
            {
                
            }
        
                   
    }
    
        public static Connection OpenConnectionReturnConn() //String user, String password
    {        
        
        try {
            
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz_assoc",user, password);
                
        if (conn != null) 
        {                
                return conn;
        }
        else 
        {
               System.out.println("Connection failure");
               return null;
        }
        
            }catch(Exception e)
            {
                
            }
        
          return null;         
    }
 
  public void CloseConn()
{
    try{
    conn.close();
    }catch(Exception e)
    {
        
    }
}
  
  
}

