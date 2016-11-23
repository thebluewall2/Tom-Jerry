
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
        <h1><center>Claims History</center></h1>
        <br>
        
        
<table>
  <thead>
    <tr>
      <th>Username</th>
      <th>Full name</th>
      <th>Claim Date</th>
      <th>Claim Amount</th>
      <th>Claims Reason</th>
      <th>Claim Status</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>met-aydin</strong></td>
      <td>Mehmet aydin</td>
      <td>13/11/2017</td>
      <td>10$</td>
      <td>For no reason aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa</td>
      <td>Approved</td> 
    </tr>
    <tr>
      <td><strong>rich3rd</strong></td>
      <td>Ng Ter Jing</td>
      <td>20/11/2016</td>
      <td>10$</td>
      <td>For no reason</td>
      <td>Submitted</td> 
    </tr>
    <tr>
      <td><strong>khaixiang14</strong></td>
      <td>Carson Lim Khai Xiang</td>
      <td>11/6/2016</td>
      <td>100$</td>
      <td>Why u ask</td>
      <td>Suspended</td> 
    </tr>
  </tbody>
</table>
</div>        
  
    
    <jsp:include page="/view/footer.jsp" />
</body>
</html>
