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
        session_start();
        include('function.php');
    ?>
    <h2>
        Vos réservations:
    </h2>
    <?php
        for($i=0; $i<$_SESSION['count']; $i++)
        { ?>
            <div id="reservé">
                <p>
                    <?php echo $_SESSION['res'][$i]['nom']; ?>
                </p>
                Pour <?php echo $_SESSION['res'][$i]['nombre_personne']; ?> <br>
                Du <?php echo $_SESSION['res'][$i]['date_A']; ?> au <?php echo $_SESSION['res'][$i]['date_D']; ?>
                <a href="ViderPanier.php?num=<?php echo $i; ?>"><button>annuler</button></a>
            </div>
        <?php }
    ?>
</body>
</html>