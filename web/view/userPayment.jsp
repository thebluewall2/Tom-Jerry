

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
        <div data-role="content" class="table1">
            <table width="400px">
                <thead>
                    <tr>
                        <th>Outstanding Balance</th>
                        <th> ${requestScope.balance}</th>
                    </tr>
                </thead>
            </table>
        </div>
        <br><br>
        <form action="/XYZDriverAssociation/paymentServlet" method="POST" style="width: 400px">
            Payment Method: 
            <select name="paymentMethod">
                <option value="Cash">Cash</option>
                <option value="Card">Card</option>
            </select>
            Amount: <input type="text" name ="amount" placeholder="£0.00"><br>
            <br>

            <input type="submit" value="Confirm" >

        </form>

        <jsp:include page="footer.jsp" />
    </body>
</html>


