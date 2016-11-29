

<html>    
    <head>
        <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    </head>

    <body>
        <jsp:include page="headerAdmin.jsp"/>   

        <h1> Annual Turnover </h1>
        <div data-role="content" class="ui-content" class="table1">
            <table width="400px">
                <thead>
                    <tr>
                        <th>Total Income </th>
                        <th> ${requestScope.totalIncome} </th>
                    </tr>
                </thead>
                <tbody align="center">
                    <tr>
                        <td>Total Payouts </td>
                        <td> ${requestScope.totalPayouts} </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <br><br>
    <center>
        XYZ Driver Association has a total of ${requestScope.totalMembers} members. Based on the total payouts, each member
        will be charged $${requestScope.totalPerMember} + $10 for the annual membership fee. <br>
        
        <a href='/XYZDriverAssociation/chargeAllMembers.do?fee=${requestScope.totalPerMember + 10}'>Charge all members 
            ($${requestScope.totalPerMember + 10}) </a>
    </center>

    <jsp:include page="footer.jsp" />

</body>
</html>