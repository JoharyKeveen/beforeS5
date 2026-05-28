<?php
    include('../inc/function/function.php');
    if(!isset($_SESSION['panier']))
    {
        $_SESSION['panier']=array();
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
    <h1>Panier</h1>
    <?php
        for($i=0;$i<count($_SESSION['panier']);$i++)
        {
            $prod=get_prod_panier($_SESSION['panier'][$i]);
            ?>
            <p>
                <?php echo $prod[0]['nom'];?> => <?php echo $prod[0]['prix'];?>
            </p>
            <?php
        }
    ?>
    <h1>Total=<?php echo total_montant();?> ar</h1>
    <h1><a href="../inc/traitement/vider.php">Vider panier</a></h1>
    <h1><a href="../index.php">acceuil</a></h1>
</body>
</html>