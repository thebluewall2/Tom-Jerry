<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>

</head>


<body>    

    <jsp:include page="headerUser.jsp" />
    <br>
    <br>
    <br>   
        
            <h1><center>Welcome to XYZ Driver Association</center></h1>  
            
         
  <c:if test="${requestScope.popupbox1 eq true}">
          <jsp:include page="PopUpBox.jsp" />
   </c:if>
    
    
    
    <jsp:include page="footer.jsp" />

</body>


</html>

