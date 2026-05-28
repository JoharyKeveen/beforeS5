<?php
include("data.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Document</title>
</head>
<body>
    <form action="traitement.php">
        <fieldset>
            <legend><h1>Le Login</h1></legend>
        <p>
            <label for="ID">Votre identifiant</label>
            <input type="text" name="ID" required>
        </p>
        <p>
            <label for="password">Mot De Passe</label>
            <input type="password" name="password" required minlength="5">
        </p>

        <?php
        if(isset($_GET['ID'])==true)
        { ?>
        <h3 id="erreur">ERREUR BE TSY MIVAVAKA!!!!!!!!!!!!!!!</h3>
        <?php }
        ?>

        <p>
            <input type="submit" value="Login">
        </p>
        </fieldset>
    </form>
</body>
</html>