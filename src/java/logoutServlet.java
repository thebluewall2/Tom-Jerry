import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
 
public class logoutServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        request.getRequestDispatcher("index.jsp").include(request, response);
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        output.println("Thank you for using XYZ Web Services! You've logged out your account.");
        output.close();
    }
            
}
