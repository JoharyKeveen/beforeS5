<?php
include('fonctions.php');
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
        information
    </h1>
    <form action="annee.php" method="get">
        <p>
        <label for="mois">taper mois</label>
        <input type="number" placeholder="Mois" name="mois" required>
        <input type="color" name="color1">
        </p>
        <p>
        <label for="annee">taper année</label>
        <input type="number" placeholder="Année" name="annee" required>
        <input type="color" name="color2">
        </p>
        <input type="submit" valude="valider">
    </form>
    <?php
        if(isset($_GET['valiny'])==true)
        { ?>
        <h2>Vérifier votre saisie</h2>
        <?php }
        ?>
</body>
</html>
