<html>    
<head>
    <link type="text/css" rel="stylesheet" href="kxcss.css"/>
    <link type="text/css" rel="stylesheet" href="pageDesign"/>
</head>
<body>
    <div data-role="page" align="center">
        <div data-role="header">
        <jsp:include page="/view/headerUser.jsp" />
        </div>
        
        
    <!--History-->
<div data-role="main" class="ui-content">
    
    <form action="/XYZDriverAssociation/ClaimServlet" method="POST">
        
        <center>Claim Amount</center>      
        <input type="number" rows="1" cols="1" name="ClaimAmount" placeholder="0.00">

        <center>Claim Reason</center>
        <textarea style="resize:none" type="submit" rows="3" cols="50" name="ClaimReason" placeholder="The reason for this claim is..."></textarea>

        <br>
        <input type="submit" value="Submit">
        
    </form>
        <h1><center>Claims History</center></h1>
        
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
      <td>Approved</td> 
    </tr>
  </tbody>
</table>
</div>        
  
    
    <div data-role="footer">
    <jsp:include page="/view/footer.jsp" />
    </div>
    </div>
</body>
</html>
