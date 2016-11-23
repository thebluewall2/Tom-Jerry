# Tom-Jerry

I've set the user's member-id into a session attribute that you can all access in your jsps and servlets.
To access it in your jsp : 
${sessionScope.memberID}

To access it in your servlets :
        HttpSession session = request.getSession();
        session.getAttribute("memberID");
        
I think.
