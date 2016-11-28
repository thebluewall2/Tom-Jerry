
<!DOCTYPE html>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <title>Claim History</title>
    </head>
    <body>

        <jsp:include page="headerUser.jsp" />        

        <div align="center">

            <h1> Claim History</h1>
            
            
            <table border="1">
                <tr>
                    <th>No</th>
                    <th>Member ID</th>
                    <th>Date of Claim</th>
                    <th>Reason of Claim</th>
                    <th>Status</th>
                    <th>Amount</th>
                </tr>    
                
                <c:set var="count" value="0"/>    
                <c:forEach items="${tablelist}" var="row"> 
                    
                <tr>                                                                                                        
                    <td><c:out value="${count}"/></td> 
                    <td><c:out value="${row.mem_id}"/></td>
                    <td><c:out value="${row.date}"/></td>
                    <td><c:out value="${row.rationale}"/></td>                   
                    <td><c:out value="${row.amount}"/></td>
                    <td><c:out value="${row.status}"/></td>
                </tr>
                </c:forEach>
               
              
            </table>
                    
                    <h1>There is total of ${number} claims.</h1>
        </div>
    </body>
</html>
