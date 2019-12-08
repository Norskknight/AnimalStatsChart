<%@include file="header.jsp" %>
<c:set value="Home" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>


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
    <th class="th-sm">Delete</th>
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
            <td>
                <form method="post" action="deleteAnimal">
                    <input name="animalId" type="animalId" value="${animal.id}" hidden>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
