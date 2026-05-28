<?php
    session_start();
    include('../inc/nav/header.php');
    $bdd=connex_bdd();
    if (is_admin($_SESSION['id'])!=true) {
        header('location:accueil.php');
        $_SESSION['adm']="Vous n'etes pas autorisé à acceder a cette page";
    }
   $descri=get_descri();
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
        if(isset($_GET['edit'])==false)
        { ?>
            <h2>
                Nombre total de Cv: <?php get_cv_size() ?>
            </h2>
        
            <h2>
                Nombre de Cv pour:
            </h2>
                <?php for($i=0;$i<count($descri);$i++)
                    { $choice=get_choice($descri[1]); ?>
                    <h4> <?php
                            echo $choice[$i]," = "; 
                            get_size_type($choice[$i]);
                            ?> 
                    </h4>
                <?php } ?>
            <h2>
                Tableau:
                <table border="1">
                        <th> /--/--/</th>
                    <?php for($i=0;$i<count($descri);$i++)
                    { $choice=get_choice($descri[1]); ?> 
                        <th><?php echo $choice[$i];?></th>
                    <?php } ?>
                    </tr>
                        <td> Sportif </td>
                        <?php for($i=0;$i<count($descri);$i++)
                        { $choice=get_choice($descri[1]); ?> 
                            <td><?php echo size_sport($choice[$i],"oui");?></td>
                        <?php } ?>
                    </tr>
                    </tr>
                        <td> Non sportif </td>
                        <?php for($i=0;$i<count($descri);$i++)
                        { $choice=get_choice($descri[1]); ?> 
                            <td><?php echo size_sport($choice[$i],"non");?></td>
                        <?php } ?>
                    </tr>
                </table>
            </h2> 
            <h1>
                <a href="./stat_cv.php?edit">Modifier les parametres</a>
            </h1> 
        <?php }
        else
        {
            include('./edit_para.php');
        }
    ?>
</body>
<?php include('../inc/nav/footer.php'); ?>
</html>