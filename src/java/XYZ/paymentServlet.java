
package XYZ;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class paymentServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet paymentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet paymentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
