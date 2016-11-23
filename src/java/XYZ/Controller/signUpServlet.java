package XYZ.Controller;

import XYZ.methods.Login;
import XYZ.methods.SignUp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signUpServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        
        String userInfo[] = new String[2];
        
        System.out.println(name + address + dob);
        
        userInfo = SignUp.SignUpNewMember(name, address, dob);
        
        request.setAttribute("username", userInfo[0]);
        request.setAttribute("password", userInfo[1]);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/signUpSuccess.jsp");
        rd.forward(request, response);
    }

}
