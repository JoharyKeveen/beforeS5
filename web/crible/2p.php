<?php
include ("fonction soratra.php");
$num=$_GET['num'];
$x=premier($num);
$y=diviseur($num);

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
        <?php echo "$num $x";?>
    </h1>  
    <?php echo $y;?>
</body>
</html>