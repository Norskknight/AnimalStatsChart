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

        <label for="name">AnimalName</label>
        <input required type="text" id="name" name="name">
        <br>

        <label for="class">AnimalClass</label>
        <input required type="text" id="class" name="class">
        <br>

        <label for="fiction">Fiction or nonFiction</label>
        <input required type="text" id="fiction" name="fiction">
        <br>

        <label for="health">Health</label>
        <input required type="text" id="health" name="health">
        <br>
        <label for="stamina">Stamina</label>
        <input required type="text" id="stamina" name="stamina">
        <br>
        <label for="strength">Strength</label>
        <input required type="text" id="strength" name="strength">
        <br>
        <label for="agility">Agility</label>
        <input required type="text" id="agility" name="agility">
        <br>
        <label for="dexterity">Dexterity</label>
        <input required type="text" id="dexterity" name="dexterity">
        <br>
        <label for="intelligence">Intelligence</label>
        <input required type="text" id="intelligence" name="intelligence">
        <br>


        <input type="submit">
    </form>
</div>
</body>
</html>
