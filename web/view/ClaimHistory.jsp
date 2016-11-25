
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

        <sql:setDataSource var="c_history" driver="com.mysql.jdbc.Driver"
                           url= "jdbc:mysql://localhost:3306/xyz_assoc"
                           user= "root"
                           password = ""/>

        <sql:query dataSource="${c_history}" var="result">
            SELECT * from claims WHERE mem_id = "${sessionScope.memberID}";
        </sql:query>


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
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${count=count+1}"/></td> 
                        <td><c:out value="${row.mem_id}"/></td>
                        <td><c:out value="${row.date}"/></td>
                        <td><c:out value="${row.rationale}"/></td>
                        <td><c:out value="${row.status}"/></td>
                        <td><c:out value="${row.amount}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
