/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.Controller;

import XYZ.methods.ViewClaim;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yusuk
 */
public class UserViewClaimServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        try {
             HttpSession session = request.getSession(); 
             String mem_id = (String) session.getAttribute("memberID");              
             String memberStatus = (String) session.getAttribute("memberStatus");    
        
             ViewClaim v_claim = new ViewClaim();
                          
             ResultSet resultset = v_claim.ListClaim(mem_id,memberStatus);
                       
             List<ViewClaim> tablelist = new ArrayList<ViewClaim>();
             //error is here couldnt load while or something wrong
             int number = 0;
                                 
                    while(resultset.next())
                   {
                       ViewClaim listClaim = new ViewClaim();      
                       
                       listClaim.setId(resultset.getInt("id"));
                       listClaim.setMem_id(resultset.getString("mem_id"));                       
                       listClaim.setDate(resultset.getDate("date"));
                       listClaim.setRationale(resultset.getString("rationale"));
                       listClaim.setAmount(resultset.getInt("amount"));
                       listClaim.setStatus(resultset.getString("status"));
                       
                       tablelist.add(listClaim);
                       number++; // keep track of numbers of item
                   }
                             
//        }
            
             request.setAttribute("number",number);
             request.setAttribute("tablelist",tablelist);             

             request.getRequestDispatcher("/view/ClaimHistory.jsp").forward(request, response); // put to userhome to test whether list can be added
  
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserViewClaimServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserViewClaimServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
