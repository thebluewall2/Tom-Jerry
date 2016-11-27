/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XYZ.Controller;

import XYZ.methods.AddClaim;
import XYZ.methods.CheckClaimPerYear;
import XYZ.methods.CheckDOR;
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
public class ClaimServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            HttpSession session = request.getSession();               
            String memberStatus = (String) session.getAttribute("memberStatus");    
            String mem_id = (String) session.getAttribute("memberID");
                             
            String ClaimAmount = request.getParameter("ClaimAmount");
            if(ClaimAmount.isEmpty())
            {
                ClaimAmount = "-999";            //reassign -999 to claim amount if field is empty
            }                                    
            String ClaimReason = request.getParameter("ClaimReason");
             if(ClaimAmount.isEmpty())
            {
                ClaimReason = "";            //reassign -999 to claim amount if field is empty
            }           
                        
//            CHECK MONTHS
            String checkingDOR = CheckDOR.checkdor(mem_id);

            if(checkingDOR.equals("Eligible"))
            {
                //do nothing and proceed
            }
            else if(checkingDOR.equals("NotEligible"))
            {
                String message = ("Members must be registered for 6 months to make a claim");
                request.setAttribute("message", message); 
                request.setAttribute("popupbox1", true);
                request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);
            }
            else{
                String message = ("Something is wrong with the system please retry the operation.");
                request.setAttribute("message", message); 
                request.setAttribute("popupbox1", true);
                request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);
            }
            
//          CHECK CLAIM PER YEAR

//          check claim by listing claims user made
            ViewClaim v_claim = new ViewClaim();

            ResultSet resultset = v_claim.ListClaim(mem_id,memberStatus);

            List<ViewClaim> tablelist = new ArrayList<ViewClaim>();
            
            int number = 0;

                while(resultset.next())
               {
                   ViewClaim listClaim = new ViewClaim();      

                   listClaim.setId(resultset.getInt("id"));                                             
                   tablelist.add(listClaim);
                   number++; // keep track of numbers of item
               }           

            String CheckClaimPyear = CheckClaimPerYear.checkclaim(number);

            if(CheckClaimPyear.equals("Eligible"))
       {
           //do nothing and proceed
       }
       else if(CheckClaimPyear.equals("NotEligible"))
       {
           String message = ("You had already made 2 claims this year, only 2 claim is allowed per year.");
           request.setAttribute("message", message); 
           request.setAttribute("popupbox1", true);
           request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);
       }
       else{
           String message = ("Something is wrong with the system please retry the operation.");
           request.setAttribute("message", message); 
           request.setAttribute("popupbox1", true);
           request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);
       }
  
            AddClaim claim = new AddClaim();
            String ClaimSuccess = claim.AddClaimtoDB(mem_id,Integer.parseInt(ClaimAmount), ClaimReason);//open connection and pass parameters from jsp           
                
            if (ClaimSuccess.equals("success")) {                
                String message = ("Claim success, Amount is : " + ClaimAmount + ".00 and the Reason is : " + ClaimReason);
                request.setAttribute("message", message); 
                request.setAttribute("popupbox1", true);
                request.getRequestDispatcher("/view/userHome.jsp").forward(request, response);

            } else if (ClaimSuccess.equals("failure")) {                                              
                String message = ("Claim failure, some of the fields are not filled");
                request.setAttribute("message", message);
                request.setAttribute("popupbox1", true);
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
