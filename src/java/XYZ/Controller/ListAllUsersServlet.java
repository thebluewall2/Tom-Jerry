/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.Controller;

import XYZ.methods.ListAllMembers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian
 */
public class ListAllUsersServlet extends HttpServlet {

int number;
String test;    
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
            throws ServletException, IOException {
        
try {
        ListAllMembers listAllMembers = new ListAllMembers();
        
         ResultSet resultset = listAllMembers.ListMembers();
         List<ListAllMembers> tablelist;
         tablelist = new ArrayList<ListAllMembers>();
             //error is here coldnt load while or something wrong
             number = 0;
                                                            
                    while(resultset.next())
                   {
                       ListAllMembers listOfMembers = new ListAllMembers();      
                       
                       listOfMembers.setId(resultset.getString("id"));
                       listOfMembers.setName(resultset.getString("name"));                       
                       listOfMembers.setAddress(resultset.getString("address"));
                       listOfMembers.setDob(resultset.getDate("dob"));                       
                       listOfMembers.setDor(resultset.getDate("dor"));
                       listOfMembers.setStatus(resultset.getString("status"));
                       listOfMembers.setBalance(resultset.getFloat("balance"));
                       
                       tablelist.add(listOfMembers);
                       number++; // keep track of numbers of item
                   }
                    request.setAttribute("tablelist",tablelist); 
            }catch (SQLException e) {
                e.printStackTrace();
            }
     
     
          
      
            request.setAttribute("test", test);
             request.setAttribute("number", number);
                         

             request.getRequestDispatcher("/view/adminMembers.jsp").forward(request, response);
                
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
        processRequest(request, response);
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
        processRequest(request, response);
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
