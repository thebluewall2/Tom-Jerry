<!DOCTYPE html>

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
        <title>All Claim</title>
    </head>
    <body>

        <jsp:include page="headerAdmin.jsp" />      
        
        

        <div align="center">

            <h1> All Claim </h1>
            
              <form action="/XYZDriverAssociation/AdminApprovalServlet" style="width:400px" method="post">

                <input type="submit" value="Claim Approvals">

            </form>
            
            <br>
            
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Member ID</th>
                    <th>Date of Claim</th>
                    <th>Reason of Claim</th>
                    <th>Amount</th>
                    <th>Status</th>                    
                </tr>    
                  
                <c:forEach items="${tablelist}" var="row"> 
                    
                <tr>                                                                                                        
                    <td><c:out value="${row.id}"/></td> 
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
