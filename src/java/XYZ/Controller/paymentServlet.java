
package XYZ.Controller;

import XYZ.methods.userPayment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class paymentServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    }
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String memberID = (String)session.getAttribute("memberID"); 
        String paymentMethod = request.getParameter("type_of_payment");
        float amount = Float.parseFloat(request.getParameter("amount"));        
        
        System.out.println(paymentMethod + amount );
        userPayment.userPayment(memberID ,paymentMethod, amount);
    }
        
    

}
