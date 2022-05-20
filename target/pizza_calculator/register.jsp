<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>

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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&display=swap" rel="stylesheet">
</head>

<body class="body">
    <main class="main">
        <form action="register" method="POST" onsubmit="return checkPasswordIdentity(this)" >
            <header class="form__header">Sign up</header>
            <div>
                <c:if test="${errors != null}">
                    <c:forEach items="${errors}" var="error">
                        <div class="alert alert-warning">
                            <strong>${error.header}</strong> <br>
                            <p>${error.message}<p>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            <p><input class="form__field" name="name" placeholder="Name" autofocus required></p>
            <p><input class="form__field" name="email" type="email" placeholder="email" autofocus required></p>
            <p><input class="form__field" name="password" type="password" placeholder="*****" required></p>
            <p><input class="form__field" name="repeatedPassword" type="password" placeholder="*****" required></p>
            <button class="form__button" type="submit">Sign up</button>
            <p><a href="login" class="form__login">Back to login page</a></p>
        </form>
    </main>
    <script>
        function checkPasswordIdentity(form) {
            if (form.password.value != form.repeatedPassword.value) {
                alert("Password are not equal");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>