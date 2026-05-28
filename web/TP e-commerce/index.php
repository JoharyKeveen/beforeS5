<?php
    include('inc/function/function.php');
    if(!isset($_SESSION['panier']))
    {
        $_SESSION['panier']=array();
    }
    $produit=get_produit();
    $marque=get_marque();
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
    <h1>
        List produit:
    </h1>
    <?php
        for($i=0;$i<count($produit);$i++)
        {
            ?>
            <p>
                <?php echo $produit[$i]['nom'];?> => <?php echo $produit[$i]['prix'];?> <a href="inc/traitement/add_panier.php?id=<?php echo $produit[$i]['id'];?>">ajouter panier</a> <a href="pages/modif_prod.php?id=<?php echo $produit[$i]['id'];?>">Modifier</a>
            </p>
            <?php
        }
    ?>
    <h1>
        <a href="pages/panier.php">Voir panier</a>
    </h1>
    <h1>
        <a href="pages/insertProd.php">Ajouter panier</a>
    </h1>
</body>
</html>