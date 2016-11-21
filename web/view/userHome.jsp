
<!DOCTYPE html>
<html>
<head>
   <link type="text/css" rel="stylesheet" href="pageDesign.css"/>
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
            <p><center>${message}</center></p>
            <!-- for removal <c:remove var="message" scope="session" />  -->
    <jsp:include page="footer.jsp" />

</body>


</html>

