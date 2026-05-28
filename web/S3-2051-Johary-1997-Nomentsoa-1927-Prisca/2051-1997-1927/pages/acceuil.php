<?php
include('Header.php');
include('../inc/function/function.php');
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="../assets/css/styleindex.css" rel="stylesheet">
    <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $affichage = liste_trano();
    for ($i = 0; $i < count($affichage); $i += 7) {
        $photo = get_photo($affichage[$i]);
    ?>
        <a href="detail.php?id=<?php echo $affichage[$i]; ?>" id="href">
            <div class="col-lg-3">
                <!-- Card with an image on top -->
                <div class="card">
                    <img src="../assets/img/<?php echo ($photo[2]); ?>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"> <?php echo  $affichage[$i + 6] ?></h5>
                        <p class="card-text"> <?php echo $affichage[$i + 5]; ?></p>
                        <p> <?php echo "Nombre de chambre: " . $affichage[$i + 2]; ?></p>
                        <h5> <?php echo "Tarif journalier: " . $affichage[$i + 3]; ?>MGA</h5>
                    </div>
                </div>
            </div>
        </a>
    <?php }
    ?>
</body>
<footer>
    <?php
include('../inc/nav/footer.php');

    ?>
</footer>

</html>