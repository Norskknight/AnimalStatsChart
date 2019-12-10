<%@include file="header.jsp" %>
<c:set value="Home" var="title"/>
<html>
    <%@include file="head.jsp" %>
    <body>
        <%@include file="nav.jsp" %>

        <div class="container table-responsive w-75">
    <table id="datatable" class="table table-striped table-bordered table-sm" cellspacing="0">
            <thead>
            <th class="th-sm">Name</th>
            <th class="th-sm">Class</th>
            <th class="th-sm">Fiction</th>
            <th class="th-sm">Health</th>
            <th class="th-sm">Stamina</th>
            <th class="th-sm">Strength</th>
            <th class="th-sm">Agility</th>
            <th class="th-sm">Dexterity</th>
            <th class="th-sm">Intelligence</th>
            </thead>
        <c:forEach var="animal" items="${averageAnimals}">
        <tr>
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
        <tfoot>
        <th class="th-sm">Name</th>
        <th class="th-sm">Class</th>
        <th class="th-sm">Fiction</th>
        <th class="th-sm">Health</th>
        <th class="th-sm">Stamina</th>
        <th class="th-sm">Strength</th>
        <th class="th-sm">Agility</th>
        <th class="th-sm">Dexterity</th>
        <th class="th-sm">Intelligence</th>
        </tfoot>
    </table>
        </div>
    </body>

    <script>
        $(document).ready(function () {
            var table = $('#datatable').DataTable();
        });
    </script>

</html>
