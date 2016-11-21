package XYZ.Controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
 
public class logoutServlet extends HttpServlet
{
    @Override
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
 
}