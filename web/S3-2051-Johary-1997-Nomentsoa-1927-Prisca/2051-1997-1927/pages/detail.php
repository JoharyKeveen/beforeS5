<?php
include('Header.php');
include('../inc/function/function.php');
$affichage = get_the_trano($_GET['id']);
$photo = get_photo($_GET['id']);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../assets/css/styleinfo.css" rel="stylesheet">
    <title>page info</title>
</head>

<body>
    <h3>
        <?php echo $affichage[6]; ?> a <?php echo $affichage[4]; ?>
    </h3>
    <p id="para"><?php echo $affichage[3]; ?> AR par nuit</p>
    <?php
    for ($i = 0; $i < count($photo); $i++) { ?>
        <img src="../assets/img/<?php echo $photo[$i]; ?>" id="image">
    <?php }
    ?>
    <div id="price">

        <form action="../inc/traitement/reservation.php?trano=<?php echo $affichage[0]; ?>" method="post">
            <div id="reserva">
                <h4 style="text-align:center">Ici pour reserver</h4>
                <p>
                    Arriver :
                    <input type="date" name="arriver">
                </p>
                <p>
                    Depart :
                    <input type="date" name="depart">
                </p>
                <p>
                    <input type="submit" value="reserver">
                </p>
            </div>

        </form>
    </div>
    <?php
    if (isset($_GET['error'])) { ?>
        <p style="color: red;">Cette habitation n'est pas disponnible ce jour</p>
    <?php }
    ?>
</body>
<footer>
    <?php
    include('Footer.php');
    ?>
</footer>

</html>