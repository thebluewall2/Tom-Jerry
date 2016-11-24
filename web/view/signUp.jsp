
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <link type="text/css" rel="stylesheet" href="pageDesign.css"/>     
        <title>Sign Up</title>
    </head>
    <body>
        <div data-role="content" class="ui-content" class="table1" align="center">
        <h1>Sign Up</h1>

        <form action="/XYZDriverAssociation/signUpServlet.do" method="POST" style="width:400px;font-family: Helvetica-light"> 
            Name : <br>
            <input type="text" name="name">

            Address : <br>
            <textarea style="resize:none" name="address" rows="10" cols="70"></textarea>

            Date of birth : <br>
            <input type="text" name="dob">
            
            <br><br>
            <input type="SUBMIT" value="Submit">
        </form>
        
        </div>
        
    </body>
</html>
