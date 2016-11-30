<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="headerAdmin.jsp" />

        <h1> List of Members </h1>

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
            <jsp:include page="footer.jsp" />

        </div>
    </body>
</html>
