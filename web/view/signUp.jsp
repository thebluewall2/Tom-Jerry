
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/XYZDriverAssociation/view/pageDesign.css"/>
        <title>Sign Up</title>
    </head>
    <body>
        <div data-role="content" class="ui-content" class="table1" align="center">
        <h1>Sign Up</h1>

        <form action="/XYZDriverAssociation/signUpServlet.do" method="POST" style="width:400px;font-family: Helvetica-light"> 
            Name : <br>
            <input type="text" name="name" placeholder="eg: Eva Stone... (must be at least 2 words)">

            Address : <br>
            <textarea style="resize:none" name="address" rows="10" cols="70"></textarea>

            Date of birth : <br>
            <input type="text" name="dob" placeholder="dd/mm/yyyy">
            
            <br><br>
            <input type="SUBMIT" value="Submit">
        </form>
        
        <br><br>
        <center><a href="/XYZDriverAssociation/index.jsp">Cancel sign up</a></center>
        
        </div>
        
    </body>
</html>
