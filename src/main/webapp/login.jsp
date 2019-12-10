<%@include file="header.jsp" %>
<c:set value="Login" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>
    <div class="container d-flex justify-content-center align-items-center align-self-center loginForm">
        <FORM ACTION="j_security_check" METHOD="POST">


            <label class="col-sm-2 col-form-label">UserName:</label> <INPUT TYPE="TEXT" NAME="j_username">

            <label class="col-sm-2 col-form-label">Password:</label> <INPUT TYPE="PASSWORD" NAME="j_password">

            <INPUT TYPE="SUBMIT" VALUE="Log In">

        </FORM>
    </div>
</body>
</html>