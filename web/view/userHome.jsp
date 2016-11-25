
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>

    <body>    

        <jsp:include page="headerUser.jsp" />
        <br>
        <br>
        <br>   

        <h1><center>Welcome to XYZ Driver Association</center></h1>  


        <c:if test="${requestScope.popupbox1 eq true}">
            <jsp:include page="PopUpBox.jsp" />
        </c:if>



        <jsp:include page="footer.jsp" />

    </body>


</html>

