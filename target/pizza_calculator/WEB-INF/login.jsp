<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background: #f5f5f5
        }
        ​
        .blue {
            background-color: #00b5ec !important;
        }
    </style>
</head>
<body>
<main role="main" class="container">
    <div class="my-3 p-3 bg-white rounded box-shadow">
        <h4 class="text-center mb-4 mt-1">Sign in</h4>
        <hr>
        <c:if test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <div class="alert alert-warning">
                    <strong>${error.header}</strong> <br>
                    <p>${error.message}<p>
                </div>
            </c:forEach>
        </c:if>
        <form action="login" method="POST">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="email" class="form-control" placeholder="Email" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="password" class="form-control" placeholder="Password" type="password" required>
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input id="remember" name="remember" class="form-check-input" type="checkbox">
                    <label for="remember" class="form-check-label">Remember?</label>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block blue"> Sign in</button>
            </div>
            <p class="text-center"><a href="register" class="btn">Sign up</a></p>
        </form>
    </div>
</main>
</body>
</html>



