<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    
    <style type="text/css">
        table.first_table 
        {
            float: left;
            width: 800px;
            height: 100px;
            align:center;
        }

        .clear 
        {
            clear: both;
        }

        img 
        {
            float: left;
            width: 200px;
            margin-left: 2%;
            height: 100px;
        }
        
        table.second_table 
        {
            width: 100%;
        }

    </style>
</head>

<body>


<div data-role="page">
  <div data-role="header" data-position="fixed">
    <table border="0">
        <tr>
            <td>
                <img src="images/XYZLOGO.png" width="300" height="300" alt="XYZ"/>
                <div class="clear"></div>
            </td>
        
        <td>
      <table border="0" class="first_table" cellspacing="60">
          <tbody>
              <tr>
                <td><a href="index.jsp">Home</a></td>
                <td><a href="members.jsp">Members</a></td>
                <td><a href="outstanding.jsp">Outstanding Balances</a></td>
                <td><a href="annual.jsp">Annual Turnover</a></td>
              </tr>
          </tbody>
      </td>
      </tr>
      </table>
    </table>
  </div>

  <div data-role="main" class="ui-content">
      <h1>Home</h1>
      //TO-DO
  </div>

  <div data-role="footer" data-position="fixed">
    <h1>Copyright © 2016 by Tom and Jerry</h1>
  </div>
</div>

</body>
</html>

