<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <body style="background-color: white;">

    <?php foreach ($var as $tab) { ?>
        <div class="col-lg-3">
            <div class="card-body">
                <img src="../assets/img/<?php echo ($tab['photo']); ?>" class="card-img-top" alt="...">
                <p class="card-text"><?php echo $tab['titre']; ?> </p>
                <p class="card-text"><?php echo $tab['descriptions']; ?> </p>
                <p class="card-text"><?php echo $tab['prix']; ?> MGA</p>
                <form action="<?php echo base_url("GestionProposition/setprop")?>" method='get'>

                    <input type="hidden" name="anah" value=<?php echo $tab['id_objet']; ?>>
                    <input type="hidden" name="objet" value=<?php echo $this->input->get('objet') ?>>
                    <input class="card-text" type="submit" value="echanger">
                </form>
            </div>
        </div>

    <?php } ?>

</body>
</html>