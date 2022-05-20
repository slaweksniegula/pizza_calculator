<%--
  Created by IntelliJ IDEA.
  User: slawek
  Date: 07.10.2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Wynik obliczeń</title>
</head>
<body>
<br/><br/>

<br/><br/>
Wnętrze ze składnikami stanowi:  ${calculatedPercentage} % całej Twojej pizzy.

<br/><br/>
<a href="/save">Zapisz swoją pizzę.</a>
<br/><br/>
<p class="text-center"><a href="savedPizzas" class="btn">Pokaż zapisane pizze.</a></p>

<p class="text-center"><a href="logout" class="btn">Wyloguj się.</a></p>
</body>
</html>
