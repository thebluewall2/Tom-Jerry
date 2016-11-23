package XYZ.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import XYZ.methods.AddClaim;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yusuk
 */
public class AddClaimServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
             String ClaimAmount = request.getParameter("ClaimAmount");                                       
             String ClaimReason = request.getParameter("ClaimReason");
             
             out.println("Amount:"+ClaimAmount);
             out.println("Reason:"+ClaimReason);
         
             
             AddClaim claim = new AddClaim();
             boolean ClaimSuccess = claim.AddClaimtoDB(Double.parseDouble(ClaimAmount), ClaimReason);
             //ClaimSuccess= false;
             if(ClaimSuccess)
             {
                   out.println("Claim successfully added!"); // think how to display claim successsful text
                   String message = ("Claim success, Amount is:"+ClaimAmount+" and the Reason is: "+ClaimReason);
                   request.setAttribute("message", message);
                   request.getRequestDispatcher("view/userHome.jsp").forward(request, response);
          //        RequestDispatcher rd = request.getRequestDispatcher("/view/userHome.jsp");
          //         rd.forward(request, response); // include will put both pages together // forward just the new one
                    //msg pop success
             }
             else
             {
                 out.println("Claim failure");
                 String message = ("Claim fail");
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