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
            
        }

        .clear 
        {
            clear: both;
        }

        img 
        {
            float: left;
            width: 200px;
            margin-left: 0%;
            height: 100px;
        }
        
        table.second_table 
        {
            width: 100%;
        }
        
        body {
	background: #333;
	text-align: center;
}

        #container {
	display: inline-block;
	padding: 5px;
	margin: 50px;
	background: rgba(0,0,0,0.1);
	position: relative;
	
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	border-radius: 100px;

	-webkit-box-shadow: inset 0px 1px 2px 0px rgba(0,0,0,0.4), 0px 1px 1px 0px rgba(255,255,255,.1);
	-moz-box-shadow: inset 0px 1px 2px 0px rgba(0,0,0,0.4), 0px 1px 1px 0px rgba(255,255,255,.1);
	box-shadow: inset 0px 1px 2px 0px rgba(0,0,0,0.4), 0px 1px 1px 0px rgba(255,255,255,.1);

	-webkit-transition: all .2s ease;
	-moz-transition: all .2s ease;
	-ms-transition: all .2s ease;
	-o-transition: all .2s ease;
	transition: all .2s ease;
}

        #container ul 
        {
	padding: 0;
	height: 40px;
	margin: 0;
	list-style: none;
	overflow: hidden;
	
	-webkit-box-shadow: inset 0px 1px 1px 0px rgba(255,255,255,.2), 0px 1px 2px 0px rgba(0,0,0,0.5);
	-moz-box-shadow: inset 0px 1px 1px 0px rgba(255,255,255,.2), 0px 1px 2px 0px rgba(0,0,0,0.5);
	box-shadow: inset 0px 1px 1px 0px rgba(255,255,255,.2), 0px 1px 2px 0px rgba(0,0,0,0.5);
	
	background: #5c6063;
	background-image: -moz-linear-gradient(top, rgba(0,0,0,0) 0%, rgba(0,0,0,0.3) 100%);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.3)));
	background-image: -webkit-linear-gradient(top, rgba(0,0,0,0) 0%,rgba(0,0,0,0.3) 100%);
	background-image: -o-linear-gradient(top, rgba(0,0,0,0) 0%,rgba(0,0,0,0.3) 100%);
	background-image: -ms-linear-gradient(top, rgba(0,0,0,0) 0%,rgba(0,0,0,0.3) 100%);
	background-image: linear-gradient(top, rgba(0,0,0,0) 0%,rgba(0,0,0,0.3) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00000000', endColorstr='#4d000000',GradientType=0 );
	
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	border-radius: 100px;
        }

        #container ul li 
        {
	background: rgba(255,255,255,0.0);
	float: left;
	text-align: center;
	border-right: 1px solid #666;
	border-left: 1px solid #444;
	
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;

        }

        #container ul li:hover 
        {
	background: rgba(255,255,255,0.08);
        }

        #container ul li:active 
        {
	background: rgba(0,0,0,0.08);
        }

        #container ul li:first-child 
        {
	border-left: none;
	-webkit-border-radius: 100px 0 0 100px;
	-moz-border-radius: 100px 0 0 100px;
	border-radius: 100px 0 0 100px;
        }

        #container ul li:last-child 
        {
	border-right: none;
	-webkit-border-radius: 0 100px 100px 0;
	-moz-border-radius: 0 100px 100px 0;
	border-radius: 0 100px 100px 0;
        }

        #container ul li a
        {
	text-decoration: none;
	font: 11px/41px Arial, sans-serif;
	color: #ddd;
	text-transform: uppercase;
	text-shadow: 0px 1px rgba(0,0,0,0.5);
	padding: 30px;

        }
    </style>
</head>

<body>
<div data-role="page">
  <div id="container" data-position="fixed" >
         <table border="0" class="first_table">
            <tr>
                <td>
                    <a href="adminHome.jsp"><img src="images/XYZLOGO.png" width="300" height="300" alt="XYZ"/></a>
                </td>
            
                <td>
                    <ul>
                        <li><a href="adminHome.jsp">Home</a></li>
                        <li><a href="adminMembers.jsp">Members</a></li>
                        <li><a href="adminOutstanding.jsp">Outstanding Balances</a></li>
                        <li><a href="adminAnnual.jsp">Annual Turnover</a></li>
                    </ul>
                </td>
            </tr>
        </table>
   </div>
  
    
    <div align="left">
        <h1>Members</h1>                                     
    </div>

  <div data-role="footer" data-position="fixed">
     <h2 style="font-size: 12px">Copyright © 2016 by Tom and Jerry</h2>
  </div>
</div>
</body>
</html>

