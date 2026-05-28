<?php
include("data.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>
        Page d'accueil
    </h1>
<form action="tableau.php" method="get">
    <h2>
        nombre de ligne:<input type="text" name="ligne">
    </h2>
    <h2>
        nombre de colone:<input type="text"name="colone">
    </h2>
    <h2>
        choisir la couleur:<input type="color" name="color">
    </h2>
    <h2>
        <input type="submit" value="valider">
    </h2>
</form>
</body>
</html>