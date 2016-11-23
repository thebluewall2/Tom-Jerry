
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Success</title>
    </head>
    <body>
        <h1>Successfully signed up!</h1>

        Congratulations, you are now signed up!
        Your username is ${requestScope.username} <br>
        and your password is ${requestScope.password} 
        
        <br><br>
        
        You are now a provisional member while and admin reviews your membership and approves you.
        
        <br><br>
        
        You may now <a href="index.jsp">login here.</a>
        
    </body>
</html>
