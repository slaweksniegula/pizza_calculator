
<%--
  Created by IntelliJ IDEA.
  User: slawek
  Date: 08.10.2021
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Saved pizzas list</title>
</head>
<body>
<br/><br/>
<p class="text-center"><a href="param_input" class="btn">Oblicz powierzchnię w kolejnej pizzy.</a></p>
<br/><br/>
<table border="1">
    <tr>
        <th>Promień pizzy</th>
        <th>Szerokość brzegu</th>
        <th>% pizzy ze składnikami</th>
    </tr>
    <c:forEach  var="pizza" items="${pizzas_list}">
        <tr>
            <td>${pizza.r}</td>
            <td>${pizza.crustEdge}</td>
            <td>${pizza.ingredientsPercentage}</td>
        </tr>
    </c:forEach>
</table>
<br/><br/>
<p class="text-center"><a href="logout" class="btn">Wyloguj się.</a></p>

</body>
</html>
