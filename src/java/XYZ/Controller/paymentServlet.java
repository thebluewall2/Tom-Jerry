package XYZ.Controller;

import XYZ.methods.userPayment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class paymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String memberID = (String) session.getAttribute("memberID");
        String paymentMethod = request.getParameter("paymentMethod");
        float amount = Float.parseFloat(request.getParameter("amount"));

        userPayment.userPayment(memberID, paymentMethod, amount);
        response.sendRedirect("view/userHome.jsp");
    }

}
