<?php
    include('data/data.php');
    $i=$_GET['nom'];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Réservation</title>
</head>
<body>
    <div id="reservation_content">
        <form action="traitement.php">
            Réservation: <?php echo $result[$i]['nom']; ?>
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
                <input type="hidden" name="indice" value="<?php echo $i ?>">
                <input type="submit" value="gooo">
            </p>
        </form>
    </div>
</body>
</html>