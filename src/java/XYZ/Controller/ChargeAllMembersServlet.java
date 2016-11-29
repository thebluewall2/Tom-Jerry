package XYZ.Controller;

import XYZ.methods.ChargeAllMembers;
import XYZ.methods.OpenConnectionSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChargeAllMembersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        float fee = Float.parseFloat(request.getParameter("fee"));
        
        ChargeAllMembers.chargeMembers(fee);
        
        request.setAttribute("fee", fee);
        RequestDispatcher rd = request.getRequestDispatcher("/view/chargeSuccess.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
