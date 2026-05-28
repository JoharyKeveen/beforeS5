<?php
    session_start();
    include('../inc/nav/header.php');
    $bdd=connex_bdd();
    $list_cv=get_cv();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/accueil.css">
    <link href="../assets/css/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet">
    <link href="../assets/css/boot.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <?php
        if(isset($_GET['add'])==true)
        {
            include('./add_cv.php');
        }
        else if(isset($_GET['view'])==true)
        {
            include('./edit_cv.php');
        }
        else if(isset($_GET['edit'])==true)
        {
            include('./edit_cv.php');
        }
        else
    { ?>
    <a href="./accueil.php?add">Add new Curruculum Vitae </a>
    <h1>
        Liste des Curruculum Vitae:
    </h1>
    <div class="row">
        <?php for($i=0;$i<count($list_cv);$i+=6){ ?>
            <div class='col-md-3'>
                <div class="row" style="margin:auto;">
                    <img src="../assets/img/<?php echo $list_cv[$i+5];?>" width="100%" alt="error">
                    <p> Nom: <?php echo $list_cv[$i+2]; ?> </p>
                    <p> Prénom: <?php echo $list_cv[$i+3]; ?> </p>
                    <p> Date de naissance: <?php echo $list_cv[$i+4]; ?> </p>
                </div>
                <div class="row">
                    <div class='col-md-8'>
                        <a href="./accueil.php?view=<?php echo $list_cv[$i];?>"> <span>View details</span> </a>
                        <?php if(is_mine($_SESSION['id'],$list_cv[$i+1])==true){ ?>
                            <a href="./accueil.php?edit=<?php echo $list_cv[$i];?>"> Edit<span class="glyphicon glyphicon-pencil"></span> </a>
                        <?php } ?>
                    </div> 
                </div>
            </div>
        <?php } ?>
    </div> 
    <?php } ?> 
</body>
<?php include('../inc/nav/footer.php'); ?>
</html>