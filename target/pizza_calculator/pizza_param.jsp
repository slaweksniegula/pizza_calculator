<!DOCTYPE html>
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
        <form class="form" action="/calculate" method="GET">
            <header class="form__header">Provide your pizza parameters</header>
            <p><input class="form__field" name="pizzasR" type="number" placeholder="Pizza radius:" autofocus required></p>
            <p><input class="form__field" name="crustEdge" type="number" placeholder="Crust edge of pizza:" required></p>
            <!-- step any? -->
            <button input class="form__button" type="submit" name="Submit"> Send</button>
            <p><a href="savedPizzas" class="form__register">Show saved pizzas</a></p>
            <!-- brakuje id! -->
            <p><a href="logout" class="form__login">Log out</a></p>
            <!-- brakuje id! -->
        </form>
    </main>
</body>
</html>