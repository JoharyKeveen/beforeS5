<?php
    include("data.php");
    include("fonction.php");
    session_start();
    random();
    $manisa=isa();
    if($manisa>=6)
    {
        header('Location:deconnexion.php');
    }
    elseif($manisa==5)
    {
        echo "Si vous vous trompez de lettre, le mot changera automatiquement";
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css" type="text/css">
    <title>Jeux du Pendu</title>
</head>
<body>
    <form action="index.php" method="post">
        <fieldset>
            <legend>
                Le Jeux Du Pendu
            </legend>
            <label for="teny">Entrer une lettre</label>
            <input type="text" name="teny" maxlength="1" required>
            <span>
                <img src="sary/<?php echo $manisa ?>.png" alt="Ajanony amin'izay ry zoky be fa efa hita fa resy a!!!!!!!!!!!!!!!!!!!!!!!!!" width='400px'>
            </span>
            <p>
                <?php
                    soratra();
                ?>
            </p>
            <p>
                <input type="submit" value="OK">
            </p>
            <p>
                <a href="deconnexion.php">Nouveau mot</a>
            </p>
        </fieldset>
    </form>
</body>
</html>