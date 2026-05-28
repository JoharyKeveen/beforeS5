<?php
$sikidy=$_GET['sikidy'];
$nb=$_GET['nb'];
$loko=$_GET['loko'];
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sikidy</title>
</head>
<body>
    <?php
    for($i=0; $i<$nb; $i++)
    { ?>
    <img src="sary/<?php echo $sikidy; ?><?php echo $loko; ?>.png" alt="tsy misy sary oooooooo">
    <?php }
    ?>
</body>
</html>