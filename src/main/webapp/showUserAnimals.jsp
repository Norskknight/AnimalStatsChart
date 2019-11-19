<%@include file="header.jsp" %>
<c:set value="UserPage" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>



<div>
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

<div>

    <form action="addAnimal" method="post">

        <label for="userName">AnimalName</label>
        <input required type="text" id="name" name="userName">
        <br>

        <label for="userName">AnimalClass</label>
        <input required type="text" id="class" name="userName">
        <br>

        <label for="userName">Fiction or nonFiction</label>
        <input required type="text" id="fiction" name="userName">
        <br>

        <label for="userName">Health</label>
        <input required type="text" id="health" name="userName">
        <br>
        <label for="userName">Stamina</label>
        <input required type="text" id="stamina" name="userName">
        <br>
        <label for="userName">Strength</label>
        <input required type="text" id="strength" name="userName">
        <br>
        <label for="userName">Agility</label>
        <input required type="text" id="agility" name="userName">
        <br>
        <label for="userName">Dexterity</label>
        <input required type="text" id="dexterity" name="userName">
        <br>
        <label for="userName">Intelligence</label>
        <input required type="text" id="intelligence" name="userName">
        <br>


        <input type="submit">
    </form>
</div>
</body>
</html>
