
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    </head>
    <body>        
        <jsp:include page="headerAdmin.jsp" />

        <h1> List of Members </h1>

    <center>
        <a href="/XYZDriverAssociation/ViewOutstandingBalancesServlet.do">View all members with outstanding balances only.</a>
        <br>
        <a href="/XYZDriverAssociation/ViewProvisionalMembershipServlet.do">View provisional members only.</a>
    </center>
    <br>

    <div data-role="content" class="ui-content" class="table1">
        <table width="1200px">

            <thead>
                <tr>

                    <th>Member ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Date of Birth</th>
                    <th>Date of Registration</th>
                    <th>Status</th>
                    <th>Balance</th>
                    <th>Action</th>                    
                </tr>    
            </thead>


            <c:forEach items="${tablelist}" var="row"> 

                <tr>                                                                                                        

                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td><c:out value="${row.address}"/></td>                    
                    <td><c:out value="${row.dob}"/></td>
                    <td><c:out value="${row.dor}"/></td>
                    <td><c:out value="${row.status}"/></td>
                    <td><c:out value="${row.balance}"/></td>
                    <td> 
                        <c:if test="${row.status eq 'SUSPENDED'}">
                            <button><a href="/XYZDriverAssociation/ReapproveUserServlet?id=${row.id}">Resume</a></button> 
                        </c:if>
                        <c:if test="${row.status eq 'APPROVED'}">
                            <button><a href="/XYZDriverAssociation/SuspendServlet?id=${row.id}">Suspend</a></button>  
                        </c:if>
                        <c:if test="${row.status eq 'APPLIED'}">
                            <button><a href="/XYZDriverAssociation/ReapproveUserServlet?id=${row.id}">Approve</a></button> 
                        </c:if>

                    </td>     
                </tr>
            </c:forEach>


        </table>

        <h1>There is total of ${number} members.</h1>


        <jsp:include page="footer.jsp" />

    </div>
</body>
</html>

