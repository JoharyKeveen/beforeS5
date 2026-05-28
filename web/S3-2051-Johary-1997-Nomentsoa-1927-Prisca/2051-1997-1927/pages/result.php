<?php
    include('../inc/function/function.php');
    include('Header.php');
    $result=recherche($_POST['search']);
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
    <?php
        for($i=0;$i<count($result);$i++)
        {
            $affichage=get_the_trano($result[$i]); ?>
            <div style="border: solid 1px red;">
                <h3>Type : <?php echo $affichage[6];?></h3>
                <h3>Nombre de chambre : <?php echo $affichage[2];?></h3>
                <h3>Tarif : <?php echo $affichage[3];?></h3>
                <h3>Quartier : <?php echo $affichage[4];?></h3>
                <h3>Description : <?php echo $affichage[5];?></h3>
            </div>
        <?php }
    ?>
</body>
<footer>
    <?php
        include('Footer.php');
    ?>
</footer>
</html>