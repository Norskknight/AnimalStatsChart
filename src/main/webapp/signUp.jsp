<%@include file="header.jsp" %>
<c:set value="SiqnUp" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>

<div class="container d-flex justify-content-center align-items-center align-self-center">
    <form action="signUpUser" method="post">
        <label class="col-sm-2 col-form-label" for="userName">UserName:</label>
        <input required type="text" id="userName" name="userName">

        <label class="col-sm-2 col-form-label" for="userPass">Password:</label>
        <input required type="password" id="userPass" name="userPass">

        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>