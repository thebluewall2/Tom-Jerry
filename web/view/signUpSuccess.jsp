
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <title>Sign Up Success</title>
    </head>
    <body>
        <div align="center">
            <br><br>
        <h1>Successfully signed up!</h1>
        
        <br>    

        Congratulations, you are now signed up!
        Your username is ${requestScope.username} <br>
        and your password is ${requestScope.password} 
        
        <br><br>
        
        You are now a provisional member while and admin reviews your membership and approves you.
        
        <br><br>
        
        You may now <a href="index.jsp">login here.</a>
        </div>
    </body>
</html>
