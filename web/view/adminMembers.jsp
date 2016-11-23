
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
    <jsp:include page="headerAdmin.jsp" />
        
    <h1> Approve Provisional Members </h1>
    <form action="/XYZDriverAssociation/approveServlet" style="width:400px" method="post">
        
        <center>Enter Member's Username</center>              
        <input type="text" name="approveUsername" placeholder="e.g. me-aydin"><BR>

        <br>
        <input type="submit" value="Approve">
        
    </form>
    <jsp:include page="footer.jsp" />
    
    
</body>
</html>

