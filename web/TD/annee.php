<?php
include('fonctions.php');
$mois=$_GET['mois'];
$annee=$_GET['annee'];
$color1=$_GET['color1'];
$color2=$_GET['color2'];
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
<?php if(checkMoisAnnee($mois, $annee)==1)
{ ?>
    <h1>résumé</h1>
    <p>
        On est au mois n° <span style="background-color:<?php echo $color1; ?>">  <?php echo $mois; ?> </span> de l'annee <span style="color:<?php echo $color2;?>"> <?php echo $annee; ?></span>.
    </p>
    <p>
    <a href="index.php">Retour</a>
    </p>
<?php } 
else
{ ?>
    <h1>
        Vérifier votre saisie
    </h1>
    <p>
        <a href="index.php">Retour</a>
    </p>
<?php }
?>
</body>
</html>