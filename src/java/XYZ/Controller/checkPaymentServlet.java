
package XYZ.Controller;

import XYZ.methods.CheckPayment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class checkPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                            
        HttpSession session = request.getSession();
        String memberID = (String) session.getAttribute("memberID");
        
        float balance = CheckPayment.checkPayment(memberID);
        request.setAttribute("balance", balance);
        
        RequestDispatcher rd = request.getRequestDispatcher("view/userPayment.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
