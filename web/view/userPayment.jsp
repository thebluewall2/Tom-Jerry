
<<!DOCTYPE html>
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
        
        <h1> Payment </h1>
        <form action="userHome.jsp" method="POST" style="width: 400px">
            First Name: <input type="text" name="firstName" placeholder="First Name"><br>
            Last Name: <input type="text" name ="lastName" placeholder="Surname"><br>
            Amount: <input type="text" name ="amount" placeholder="£0.00"><br>
            Payment Method: 
            <select name="paymentMethod">
                <option value="Cash">Cash</option>
                <option value="Card">Card</option>
            </select>
            Payment Date: <input type="date" name="paymentDate" placeholder="DD/MM/YYYY"><br>
            <input type="submit" value="Confirm">
        </form>

        <jsp:include page="footer.jsp" />
</body>
</html>

