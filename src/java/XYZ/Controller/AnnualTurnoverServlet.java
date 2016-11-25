
package XYZ.Controller;

import static XYZ.methods.AnnualTurnover.getAnnualTurnover;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnualTurnoverServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //creating an array to store the 2 floats, annualTurnover[0] 
        //is total income and annualTurnover[1] is total payouts
        float[] annualTurnover = new float[2];

        annualTurnover = getAnnualTurnover();

        request.setAttribute("totalIncome", annualTurnover[0]);
        request.setAttribute("totalPayouts", annualTurnover[1]);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/adminAnnual.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }


}
