<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Réservation</title>
</head>
<body>
    <?php
        include('header.php');
    ?>
    <div id="reservation_content">
        <form action="nos_reservation.php" method="get">
            Réservation pour: <?php echo $_GET['nom']; ?>
            <p>
                Veuillez entrer
            </p>
            <p>
                le nombre de personne: <input type="number" name="nb_pers">
            </p>
            <p>
                la date d'arrivée: <input type="date" name="date_A">
            </p>
            <p>
                la date de départ: <input type="date" name="date_D">
            </p>
            <p>
                <input type="submit" value="réserver">
            </p>
        </form>
    </div>
</body>
</html>