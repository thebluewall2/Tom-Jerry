
package XYZ.Controller;

import XYZ.methods.AnnualTurnover;
import java.io.IOException;
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
        //annualTurnover[2] is total members
        double[] annualTurnover = new double[3];
        double totalPaymentPerMember;

        annualTurnover = AnnualTurnover.getAnnualTurnover();
        totalPaymentPerMember = annualTurnover[1] / Math.round(annualTurnover[2]); 

        request.setAttribute("totalIncome", annualTurnover[0]);
        request.setAttribute("totalPayouts", annualTurnover[1]);
        request.setAttribute("totalMembers", Math.round(annualTurnover[2])); //so that it doesnt print 2.0 members
        request.setAttribute("totalPerMember", Math.round(totalPaymentPerMember * 100) / 100.0);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/adminAnnual.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //do nothing
    }


}
