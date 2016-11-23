
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <body>
        <h1>Sign Up</h1>

        <form action="/XYZDriverAssociation/signUpServlet.do" method="POST" style="width:400px;font-family: Helvetica-light"> 
            Name : <br>
            <input type="text" name="name">

            Address : <br>
            <textarea name="address" rows="10" cols="70"></textarea>

            Date of birth : <br>
            <input type="text" name="dob">
            
            <br><br>
            <input type="SUBMIT" value="Submit">
        </form>
        
        
    </body>
</html>
