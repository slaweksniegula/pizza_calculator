<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Param input</title>
</head>
<body>
Podaj informacje o swojej pizzy:
<br/>
<br/>
<p class="text-center"><a href="savedPizzas" class="btn">Pokaż zapisane pizze</a></p>

<form action="/calculate" method="get ">
    Promień mojej pizzy to: <input type="number" name="pizzasR">
    <br/><br/>
    Szerokość brzegów mojej pizzy to: <input type="number" name="crustEdge">
    <input type="submit" name="Submit">
</form>
<br/><br/>
<p class="text-center"><a href="logout" class="btn">Wyloguj się.</a></p>
<br/>
</body>
</html>