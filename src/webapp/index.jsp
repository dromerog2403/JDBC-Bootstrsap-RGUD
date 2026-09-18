<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Formularios</h1>
    <form action="MiServlet" method="post">
        <div class="mb-3">
            <label for="exampleInputName1" class="form-label">Ingresa tu nombre</label>
            <input type="name" class="form-control" id="exampleInputName1" name="exampleInputName1" aria-describedby="nameHelp">
            <div id="text" class="form-text">'Well never share your information with anyone else.'</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputAge1" class="form-label">Ingresa tu edad</label>
            <input type="number" class="form-control" id="exampleInputAge1" name="exampleInputAge1" aria-describedby="ageHelp">
        </div>
        <button type="submit" class="btn btn-primary">
            Enviar información
        </button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>