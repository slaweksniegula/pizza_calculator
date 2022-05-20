<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>pizza_calculator</title>
    <link rel="icon" href="../images/pizza.png">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/body.css" rel="stylesheet">
    <link href="../css/form.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&display=swap" rel="stylesheet">
</head>

<body class="body">
    <main class="main">
        <header class="form__header">Saved pizzas list</header>
        <div class="container">
            <table class="table">
                <caption class="tableTitle">My saved pizzas</caption>
                <tr>
                    <th class="tableCell tableHeader" scope="col">Pizza radius</th>
                    <th class="tableCell tableHeader" scope="col">Edge width</th>
                    <th class="tableCell tableHeader" scope="col">Pizza toppings %</th>
                </tr>
                <c:forEach var="pizza" items="${pizzas_list}">
                    <tr>
                        <td class="tableCell">${pizza.r}</td>
                        <td class="tableCell">${pizza.crustEdge}</td>
                        <td class="tableCell">${pizza.ingredientsPercentage}</td>
                        <!-- zmiana nazwy! -->
                    </tr>
                </c:forEach>
            </table>
        </div>
        <p><a href="param_input" class="form__register">Calculate next pizza</a></p>
        <p><a href="logout" class="form__login">Log out</a></p>
        <!-- brakuje id! -->
    </main>
</body>

</html>