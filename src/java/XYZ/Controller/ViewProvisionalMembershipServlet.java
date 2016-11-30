package XYZ.Controller;


import XYZ.methods.ListAllMembers;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewProvisionalMembershipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ListAllMembers listAllMembers = new ListAllMembers();

            ResultSet resultset = listAllMembers.ListProvisionalMembers();
            List<ListAllMembers> tablelist;
            tablelist = new ArrayList<ListAllMembers>();
            //error is here coldnt load while or something wrong

            while (resultset.next()) {
                ListAllMembers listOfMembers = new ListAllMembers();

                listOfMembers.setId(resultset.getString("id"));
                listOfMembers.setName(resultset.getString("name"));
                listOfMembers.setAddress(resultset.getString("address"));
                listOfMembers.setDob(resultset.getDate("dob"));
                listOfMembers.setDor(resultset.getDate("dor"));
                listOfMembers.setStatus(resultset.getString("status"));
                listOfMembers.setBalance(resultset.getFloat("balance"));

                tablelist.add(listOfMembers);
            }
            request.setAttribute("tablelist", tablelist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/view/listProvisionalMembers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //do nothing
    }

}
