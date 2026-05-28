<?php
session_start();
include("data.php");
for($i=0;$i<4;$i++)
{
    if($_SESSION['ID']==$login[$i]['login'])
    {
        $nom=$login[$i]['nom'];
    }
}
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
    Bonjour <?php echo $nom; ?>
</body>
</html>