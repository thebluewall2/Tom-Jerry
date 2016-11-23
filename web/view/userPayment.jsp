

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="pageDesign.css"/>
        <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

    </head>

    <body>
        <jsp:include page="headerUser.jsp" />

        <h1> Payment </h1>
        <form action="userHome.jsp" method="POST" style="width: 400px">
            Payment Method: 
            <select name="paymentMethod">
                <option value="Cash">Cash</option>
                <option value="Card">Card</option>
            </select>
            Amount: <input type="text" name ="amount" placeholder="£0.00"><br>
            Payment Date:
                <input type="date" name="paymentDate"/>
            <br>
            
            <input type="submit" value="Confirm">
        </form>

        <jsp:include page="footer.jsp" />
    </body>
</html>

