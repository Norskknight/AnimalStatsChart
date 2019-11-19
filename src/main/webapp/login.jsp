
<%@include file="header.jsp" %>
<c:set value="Login" var="title"/>

<html>
<%@include file="head.jsp" %>
<body>
<div class="container">
    <%@include file="titleBar.jsp" %>
    <div class="loginForm">
        <FORM ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <TR>
                    <TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
                <TR>
                    <TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                <TR>
                    <TH><INPUT TYPE="SUBMIT" VALUE="Log In">
            </TABLE>
        </FORM>
    </div>
</div>
</body>
</html>