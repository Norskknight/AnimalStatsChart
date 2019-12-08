<%@include file="header.jsp" %>
<c:set value="Search" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>

<form method="post" action="SearchAnimals">
    <input name="name" type="name">
    <input type="submit" value="Search">
</form>

<table>

    <thead>
    <th class="th-sm">ID</th>
    <th class="th-sm">Name</th>
    <th class="th-sm">animalClass</th>
    <th class="th-sm">fiction</th>
    <th class="th-sm">health</th>
    <th class="th-sm">stamina</th>
    <th class="th-sm">strength</th>
    <th class="th-sm">agility</th>
    <th class="th-sm">dexterity</th>
    <th class="th-sm">intelligence</th>
    </thead>
    <c:forEach var="animal" items="${Animals}">
        <tr>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.animalClass}</td>
            <td>${animal.fiction}</td>
            <td>${animal.health}</td>
            <td>${animal.stamina}</td>
            <td>${animal.strength}</td>
            <td>${animal.agility}</td>
            <td>${animal.dexterity}</td>
            <td>${animal.intelligence}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
