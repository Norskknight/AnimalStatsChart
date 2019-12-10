<%@include file="header.jsp" %>
<c:set value="Download" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>

<form action="updateAnimal" method="post">
    <input id="id" name="id" type="text" value="${animal.id}" hidden>


    <label for="name">AnimalName</label>
    <input required type="text" id="name" name="name" value="${animal.name}">
    <br>
    <label for="class">AnimalClass</label>
    <input required type="text" id="class" name="class" value="${animal.animalClass}">
    <br>
    <label for="fiction">Fiction or nonFiction</label>
    <input required type="text" id="fiction" name="fiction" value="${animal.fiction}">
    <br>
    <label for="health">Health</label>
    <input required type="text" id="health" name="health" value="${animal.health}">
    <br>
    <label for="stamina">Stamina</label>
    <input required type="text" id="stamina" name="stamina" value="${animal.stamina}">
    <br>
    <label for="strength">Strength</label>
    <input required type="text" id="strength" name="strength" value="${animal.strength}">
    <br>
    <label for="agility">Agility</label>
    <input required type="text" id="agility" name="agility" value="${animal.agility}">
    <br>
    <label for="dexterity">Dexterity</label>
    <input required type="text" id="dexterity" name="dexterity" value="${animal.dexterity}">
    <br>
    <label for="intelligence">Intelligence</label>
    <input required type="text" id="intelligence" name="intelligence" value="${animal.intelligence}">
    <br>
    <input type="submit" name="job" value="Update">
    <br>
    <input type="submit" name="job" value="Delete">

</form>

</body>
</html>


