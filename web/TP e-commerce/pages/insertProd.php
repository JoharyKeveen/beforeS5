<?php
    include('../inc/function/function.php');
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
    <form action="../inc/traitement/add_prod.php" method="post">
        <p>
            Nom: <input type="text" name="nom">
        </p>
        <p>
            Marque: 
            <select name="marque">
                <?php
                    for($i=0;$i<count($marque);$i++)
                    {
                        ?>
                            <option value="<?php echo $marque[$i];?>"><?php echo $marque[$i];?></option>
                        <?php
                    }
                ?>
            </select>
        </p>
        <p>
            Disponible: 
            <input type="checkbox" name="dispo">
        </p>
        <p>
            Prix: <input type="text" name="prix">
        </p>
        <p>
            <input type="submit" value="ajouter">
        </p>
    </form>
</body>
</html>