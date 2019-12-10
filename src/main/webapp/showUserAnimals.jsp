<%@include file="header.jsp" %>
<c:set value="UserPage" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>




    <div class="container d-flex justify-content-center">

        <form action="addAnimal" method="post">

            <div class="form-group row">
                <label class="col-sm-4 col-form-label" for="name">AnimalName</label>
                <input required type="text" id="name" name="name">

                <label class="col-sm-4 col-form-label" for="class">AnimalClass</label>
                <select name="class" id="class">
                <option value="Mammal">Mammal</option>
                <option value="Bird">Bird</option>
                <option value="Reptile">Reptile</option>
                <option value="Fish">Fish</option>
                <option value="Amphibian">Amphibian</option>
                <option value="Arthropod">Arthropod</option>
                </select>
            </div>
            <div class="form-group row">

                <label class="col-sm-2 col-form-label"  for="fiction" >Fiction</label>
                <input required type="radio" id="fiction" name="fiction" value="fiction">

                <label class="col-sm-2 col-form-label" for="nonFiction">NonFiction</label>
                <input required type="radio" id="nonFiction" name="fiction" value="nonFiction" checked>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="health">Health</label>
                <input required type="text" id="health" name="health">
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="stamina">Stamina</label>
                <input required type="text" id="stamina" name="stamina">
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="strength">Strength</label>
                <input required type="text" id="strength" name="strength">
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="agility">Agility</label>
                <input required type="text" id="agility" name="agility">
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="dexterity">Dexterity</label>
                <input required type="text" id="dexterity" name="dexterity">
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="intelligence">Intelligence</label>
                <input required type="text" id="intelligence" name="intelligence">
            </div>
            <input type="submit">
        </form>
    </div>


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
            <c:forEach var="animal" items="${userAnimals}">
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
</div>

</body>
<script>
    $(document).ready(function () {
        var table = $('#datatable').DataTable();
    });
</script>
</html>
