<!DOCTYPE>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div class="container">
        <%
            String usernameInvalid = (String)request.getAttribute( "usernameInvalid" );
            if ( usernameInvalid != null )
            {
        %>
                <div class='alert alert-danger'>
                    Username <%=usernameInvalid%> is invalid.
                </div>
        <%
            }
        %>

        <form action="/login" method="POST">
            <input type="username" name="username" class="form-control"/>
            <input type="password" name="password" class="form-control" />
            <button type="submit">Login</button>
        </form>
    </div>
    <jsp:include page="/pages/util/script-include.jsp" />
</body>
</html>