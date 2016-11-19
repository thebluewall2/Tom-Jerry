<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <link type="text/css" rel="stylesheet" href="view/navigationBar.css"/>
</head>

<body>
<!-- This is whole web page-->
<div data-role="page">
 <!--This is header-->
  <div id="container" data-position="fixed" >
         <table border="0" class="first_table">
            <tr>
                <td>
                    <a href="userHome.jsp"><img src="images/XYZLOGO.png" width="300" height="300" alt="XYZ"/></a>
                </td>
            
                <td>
                    <ul>
                        <li><a href="userHome.jsp">Home</a></li>
                        <li><a href="userMembership.jsp">Membership</a></li>
                        <li><a href="userPayment.jsp">Payment</a></li>
                        <li><a href="userClaim.jsp">Claim Subsidy</a></li>
                        <li><a href="userSettings.jsp">Settings</a></li>
                        <li><a href="/XYZDriverAssociation/logoutServlet.do">LogOut</a></li>
                    </ul>
                </td>
            </tr>
        </table>
   </div>
  
 
 <!-- This is footer -->
  <div data-role="footer" data-position="fixed">
    <h2 style="font-size: 12px">Copyright © 2016 by Tom and Jerry</h2>
  </div>
 
</div>
</body>
</html>

