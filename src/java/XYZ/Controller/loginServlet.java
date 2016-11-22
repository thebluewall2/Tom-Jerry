package XYZ.Controller;

import XYZ.methods.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //do nothing
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String memberStatus = Login.verifyLogin(username, password);
        
        if (memberStatus.equals("ADMIN")) {
            response.sendRedirect("view/adminHome.jsp");
        } else if (memberStatus.equals("APPLIED") || (memberStatus.equals("APPROVED"))) {
            response.sendRedirect("view/userHome.jsp");
        } else {
            request.setAttribute("loginError", true);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

}
