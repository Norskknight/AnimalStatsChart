<%@include file="header.jsp" %>
<c:set value="UserPage" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>



<div class="message">
    <form action="signUpUser" method="post">
        <label for="userName">UserName</label>
        <input required type="text" id="userName" name="userName">
        <br>
        <label for="userPass">Password</label>
        <input required type="password" id="userPass" name="userPass">
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
