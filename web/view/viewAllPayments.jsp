<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Payments</title>
    </head>
    <body>
        <jsp:include page="headerUser.jsp" />      

        <div align="center">

            <h1> All Payments </h1>

            <br>

            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Type of Payment</th>
                    <th>Amount</th>
                    <th>Date</th>       
                </tr>    

                <c:forEach items="${requestScope.paymentList}" var="row"> 

                    <tr>                                                                                                        
                        <td><c:out value="${row.paymentID}"/></td> 
                        <td><c:out value="${row.paymentType}"/></td>
                        <td><c:out value="${row.paymentAmount}"/></td>
                        <td><c:out value="${row.paymentDate}"/></td>                                
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>
