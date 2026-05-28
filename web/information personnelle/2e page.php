<?php
include("pays.php");
$nom=$_GET['nom'];
$jour=$_GET['jour'];
$mois=$_GET['mois'];
$annees=$_GET['annees'];
$genre=$_GET['genre'];
$pays=$_GET['pays'];
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Info perso</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div id="entete">
        <h1>Achyl's hôtel</h1>
    </div>
    <div id="faharoa">
        <h1>Informations personnelles</h1>
        <p>
            Nom👌: <span class="soratra"><?php echo $nom;?></span>
        </p>
        <p>
        Ne(e) le📅:  <span class="soratra"><?php echo $jour;?></span>
                      <span class="soratra"><?php echo $mois;?></span>
                      <span class="soratra"><?php echo $annees;?></span>
        </p>
        <p>
        Genre🚻: <span class="soratra"><?php echo $genre;?></span>
        </p>
        <p>
        Pays🗺: <span class="soratra"><?php echo $pays;?></span>
        </p>
        <a href="index.php" style="color: black;"><< Retour</a></p>
    </div>
</body>
</html>