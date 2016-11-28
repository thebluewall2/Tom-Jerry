/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.methods;

import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author yusuk
 */
public class ViewClaim {            
        private int id;
        private String mem_id;
        private Date date;
        private String rationale;
        private int amount;
        private String status;

    public ResultSet ListClaim(String member_id,String target){
        
       
        String selectedquery = "";
        
        String queryadmin = "SELECT * FROM claims order by id desc;";        
        String query = "SELECT * FROM claims WHERE mem_id ='"+member_id+"' order by id desc;";  
        String querysubmitted ="SELECT * FROM claims WHERE status ='SUBMITTED' order by id desc";
        
        if(target.equals("ADMIN"))
        {
             selectedquery = queryadmin;
        }
        else if (target.equals("APPLIED") || (target.equals("APPROVED"))) 
        {
             selectedquery = query;
        }
        else if (target.equals("SUBMITTED"))
        {
            selectedquery = querysubmitted;
        }
       
                
        ResultSet rs = OpenConnectionSQL.getData(selectedquery);                          
         
        return rs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
