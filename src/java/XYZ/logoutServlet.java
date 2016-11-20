package XYZ;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
 
public class logoutServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getParameter("action");
        response.setContentType("text/html");
        logout(request);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    private void logout(HttpServletRequest request) 
    {
        request.getSession().invalidate();
        request.setAttribute("message", "You've logged out your account.");
    }
    /*
    private void insertPayment(databaseConnection dataCon, HttpServletRequest request) 
    {

        HttpSession session = request.getSession();

        String userName = ((String) request.getSession().getAttribute("userName"));
        int invoiceNumber = Integer.valueOf(request.getParameter("invoiceNumber"));
        String paymentMethod = (String) request.getParameter("p");

        userPayment userPayment = dataCon.getCharge(invoiceNumber);
        adminPayment adminPayment = new adminPayment(userName, userPayment.getInvoiceNumber(), userPayment.getAmount(), paymentMethod);

        adminPayment responsePayment = dataCon.insertPayment(payment);
        userPayment = dataCon.getCharge(invoiceNumber);

        session.setAttribute("paymentamount", String.valueOf(responsePayment.getAmount()));
        session.setAttribute("paymenttype", String.valueOf(responsePayment.getPaymentMethod()));
        session.setAttribute("chargenote", userPayment.getCash());
        session.setAttribute("chargestatus", userPayment.getStatus());
        session.setAttribute("paymentid", String.valueOf(responsePayment.getInvoiceNumber()));
        session.setAttribute("paymentmessage", "Payment added successfully!");
    }*/
            
}