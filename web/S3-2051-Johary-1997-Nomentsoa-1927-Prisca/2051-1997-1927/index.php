<?php
include('inc/function/connection.php');
$bdd = connect_bdd();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="assets/css/styleindex.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    if (!isset($_GET['create'])) { ?>
        <div class="content">
            <h1>Login</h1>

            <form action="inc/traitement/login.php" method="post">
                <h3>email : <input type="text" name="email" id="i1"></h3>
                <h3>password : <input type="password" name="password"></h3>
                <p>
                    <input type="submit" value="GO" class="but">
                </p>
            </form>

            <h4>
                <a href="index.php?create=1">
                    click here if you don't have an account
                </a>
            </h4>
        </div>
        <?php
        if (isset($_GET['error'])) { ?>
            <h3 style="color: red;">
                Please check your email and/or your password
            </h3>
        <?php }
        ?>
    <?php } else { ?>
        <div class="content">
            <h1>
                Create account
            </h1>

            <form action="inc/traitement/create.php" method="post">
                <h3>email : <input type="text" name="email" class="inp"></h3>
                <h3>nom : <input type="text" name="nom" class="inp"></h3>
                <h3>mdp : <input type="text" name="mdp" class="inp"></h3>
                <h3>numero : <input type="text" name="numero" class="inp"></h3>
                <p><input type="submit" value="GO" class="but"></p>
            </form>
        </div>

    <?php }
    ?>
</body>

</html>