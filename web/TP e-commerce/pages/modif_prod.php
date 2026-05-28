<?php
    include('../inc/function/function.php');
    if(!isset($_SESSION['panier']))
    {
        $_SESSION['panier']=array();
    }
    $prod=array();
    if(isset($_GET['prix']))
    {
        $prod[0]['id']=$_GET['id'];
        $prod[0]['nom']=$_GET['nom'];
        $prod[0]['marque']=$_GET['marque'];
        $prod[0]['disponible']=$_GET['dispo'];
        $prod[0]['prix']=$_GET['prix'];
    }
    else
    {
        $prod=get_one_produit($_GET['id']);
    }
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
    <form action="../inc/traitement/testNomPrix.php" method="post">
        <p>
            Nom: <input type="text" name="nom" value="<?php echo $prod[0]['nom'];?>">
        </p>
        <p>
            Marque: 
            <select name="marque">
                <?php
                    for($i=0;$i<count($marque);$i++)
                    {
                        if($marque[$i]!=$prod[0]['marque'])
                        {
                            ?>
                                <option value="<?php echo $marque[$i];?>"><?php echo $marque[$i];?></option>
                            <?php
                        }
                        else
                        { 
                            ?>
                                <option value="<?php echo $marque[$i];?>" selected><?php echo $marque[$i];?></option>
                            <?php
                        }
                    }
                ?>
            </select>
        </p>
        <p>
            Disponible: 
                <?php
                    if($prod[0]['disponible']=='oui')
                    {
                        ?>
                            <input type="checkbox" name="dispo" checked>
                        <?php
                    }
                    else
                    {
                        ?>
                            <input type="checkbox" name="dispo">
                        <?php
                    }
                ?>
        </p>
        <p>
            Prix: <input type="text" name="prix" value="<?php echo $prod[0]['prix'];?>">
        </p>
        <p>
            <input type="hidden" name="id" value="<?php echo $prod[0]['id'];?>">
            <input type="submit" value="modifier">
        </p>
    </form>
    <h1 style="color: red;">
        <?php
            if(isset($_GET['prix']))
            {
                echo 'veuillez verifier le nom et/ou le prix';
            }
        ?>
    </h1>
</body>
</html>