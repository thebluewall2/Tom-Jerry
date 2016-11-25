# Tom-Jerry

I've set the user's member-id into a session attribute that you can all access in your jsps and servlets.
To access it in your jsp : 
${sessionScope.memberID}

To access it in your servlets :
        HttpSession session = request.getSession();
        session.getAttribute("memberID");
        
OpenConnectionSQL.java is now fully functional! Wherever your code is accessing MySQL database, just use functions from this file! There's 2 methods for accessing database. 1 is to add stuff to database, 2nd is to get stuff from it.
Step 1. Write down your string commands into a string.
String sql_query = "Select * from members";

Step 2. If you are adding/modifying database stuff, 
OpenConnectionSQL.executeQuery(sql_query);

If you are getting some stuff : 
ResultSet rs = OpenConnectionSQL.getData(sql_query);

then do your stuff with the rs variable.

once you finish getting your stuff or modifying your stuff, please remember to close the connection!
OpenConnectionSQL.closeConn();

or if you used the resultset, 
OpenConnectionSQL.closeResultSet(rs);
