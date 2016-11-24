
<!DOCTYPE html>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <title> XYZ Driver Association </title>
</head>

<body>
    
     <div data-role="page">
         <div  data-role="header" data-position="fixed" >
            <table border="0">
                <tr>
                    <td>
                        <a href="/XYZDriverAssociation/view/adminHome.jsp"><img src="view/images/XYZLOGO.png" width="200" height="100" alt="XYZ" /></a>
                    </td>
                </tr>
            </table>
        </div>
  

    <!-- Your body starts here!-->
    <div align="center" >
    <!-- check if the user has been redirected to this page after a failed login -->
        
        <c:if test="${requestScope.loginError eq true}" >
            Invalid login details. Please try again.
        </c:if>
        
        
        <br>
        <br>
        <form action="loginServlet.do" method="POST" style="width:400px;font-family: Helvetica-light"> 
            Username : <br>
            <input type="text" name="username">
            
            <br>
            
            Password : <br>
            <input type="password" name="password">
            
            <br><br>
            <input type="SUBMIT" value="Submit">
        </form>
    </div>

    
    <br><br>
    
    <center><a href="view/signUp.jsp">Sign Up</a></center> 
    
    <jsp:include page="view/footer.jsp" />
    
</body>
</html>

