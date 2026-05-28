<?php
$ariary=$_POST['ariary'];
$euro=$ariary/4687;
$USD=$ariary/4101;
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Outil de conversion de devise</h1>
    <p>Votre montant:<?php echo $ariary; ?> ariary</p>
    <table border="2" width="300px">
        <tr>
            <th >Valeur</th>
            <th >devise</th>
        </tr>
        <tr>
            <td><?php echo $euro;?></td>
            <td>EUR</td>
        </tr>
        <tr>
            <td><?php echo $USD;?></td>
            <td>USD</td>
        </tr>
    </table>
    <p><a href="index.php"><< Retour</a></p>
</body>
</html>