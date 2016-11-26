/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.Controller;

import XYZ.methods.AddClaim;
import XYZ.methods.CheckEligibility;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ClaimServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            HttpSession session = request.getSession(); 
                                   
            String ClaimAmount = request.getParameter("ClaimAmount");
            String ClaimReason = request.getParameter("ClaimReason");
            String mem_id = (String) session.getAttribute("memberID");
            
//            String checkingDOR = CheckEligibility.check(mem_id);
//            
//            if(checkingDOR.equals("Eligible"))
//            {
//                
//            }
//            else if(checkingDOR.equals("NotEligible"))
//            {
//                String message = ("Members must be registered for 6 months to make a claim");
//                request.setAttribute("message", message); 
//                request.setAttribute("popupbox1", true);
//                request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);
//            }
//            else{
//                System.out.println("error");
//            }
//            //check eligibility function 6months and 2 claim per year
            
            AddClaim claim = new AddClaim();
            String ClaimSuccess = claim.AddClaimtoDB(mem_id,Integer.parseInt(ClaimAmount), ClaimReason);
            
            //open connection                
                            
                
            if (ClaimSuccess.equals("success")) {                
                String message = ("Claim success, Amount is : " + ClaimAmount + ".00 and the Reason is : " + ClaimReason);
                request.setAttribute("message", message); 
                request.setAttribute("popupbox1", true);
                request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);

            } else {                
                String message = ("claim failure");
                request.setAttribute("message", message);
                request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);
                //can go back to home or continue adding claim
                //msg pop failure
            }

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
            Logger.getLogger(ClaimServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClaimServlet.class.getName()).log(Level.SEVERE, null, ex);
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
