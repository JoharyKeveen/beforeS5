<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <?php
        if(isset($_GET['ligne'])==true)
        {
            $l=$_GET['ligne'];
        }
        else
        {
            $l=1;
        }
        if(isset($_GET['colonne'])==true)
        {
            $c=$_GET['colonne'];
        }
        else
        {
            $c=1;
        }
        for($init=0; $init<$l; $init++)
        { ?>
        <tr width="75px" height="75px">
            <?php
            for($end=0; $end<$c; $end++)
            { ?>
            <td width="75px" height="75px">BG IREO MPITSARA</td>
            <?php }
            ?>
        </tr>
        <?php }
        ?>
    </table>
    <a href="index.php?ligne=<?php echo $l+1; ?>&&colonne=<?php echo $c;?>">Ligne miampy</a>
    <a href="index.php?ligne=<?php echo $l; ?>&&colonne=<?php echo $c+1;?>">Colonne miampy</a>
</body>
</html>