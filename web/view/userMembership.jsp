
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <link type="text/css" rel="stylesheet" href="pageDesign.css"/>
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
        
    <jsp:include page="headerUser.jsp" />
        
    <h1> Membership </h1>
    
    <h2> Membership Status </h2>
    <%= request.getAttribute("membershipStatus")%>
    
    <h2> Membership Expiry Date </h2>
    <%=(String)(request.getAttribute("expiryDate"))%>
   
    
    <jsp:include page="footer.jsp" />

</body>
</html>

