<?php
$ligne=$_GET['ligne'];
$colone=$_GET['colone'];
$color=$_GET['color'];
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
        vous avez cliquer sur:
    </h1>
    <ul>
        <li>
            la ligne numero:<?php echo $ligne;?>
        </li>
        <li>
            la colone numero:<?php echo $colone;?>
        </li>
        <li>
            la couleur:<?php echo $color;?>
        </li>
    </ul>
</body>
</html>