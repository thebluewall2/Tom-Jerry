
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

        <!--History-->
        <div data-role="content" class="ui-content" class="table1">

            <form action="/XYZDriverAssociation/ClaimServlet" style="width:400px" method="post">

                <center>Claim Amount</center>              
                <input type="number" name="ClaimAmount" placeholder="0.00">

                <center>Claim Reason</center>
                <textarea style="resize:none" type="submit"  name="ClaimReason" placeholder="The reason for this claim is..."></textarea>                

                <input type="submit" value="Submit">

            </form>
            <br><br>

            <form action="/XYZDriverAssociation/view/ClaimHistory.jsp" style="width:400px" method="post">

                <input type="submit" value="View All Claim History">

            </form>
       
            <jsp:include page="footer.jsp" />
    </body>
</html>
