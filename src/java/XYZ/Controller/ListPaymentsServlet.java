package XYZ.Controller;

import XYZ.methods.ListPayments;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListPaymentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String mem_id = (String) session.getAttribute("memberID");
        
        List<ListPaymentsServlet> paymentList = ListPayments.getAllPayments(mem_id);
        
        request.setAttribute("paymentList", paymentList);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/viewAllPayments.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //do nothing
    }

}
