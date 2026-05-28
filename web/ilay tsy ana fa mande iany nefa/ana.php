<?php 
    session_start();

    //Include
    include("./process/data.php");
    include("./process/fonction.php");
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./fontawesome-5/css/all.css">
    <title>Grocery</title>
</head>

<body>
    <header>
        <div class="logo">
            <h3>Grocery</h3>
        </div>

        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="./Panier.php">Panier</a></li>
                <li><a style="color: green;" href="#">Vegetables & Fruits</a></li>
                <li><a href="#">Upgrade to pro</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">izay plus de 20Ar</a></li>
            </ul>
        </nav>

        <div class="phone-number">
            <div>
                <i style="transform: rotate(90deg); margin-right: 3px;" class="fas fa-phone"></i>
            </div>

            <div>
                <p><b>Call To </b>+1800090098</p>
                <p>Email: Info@gmail.com</p>
            </div>
        </div>
    </header>


        <div class="content-in-content">

            <?php if ($_SESSION['taille_panier'] > 0){ ?>
            <p style="margin: 0; font-size: 80%;">Articles en panier: <?php echo $_SESSION['taille_panier']; ?></p>
            <?php } ?>

            <div class="produit-grid">
            <?php $i = 0; ?>
                <?php foreach ($produit as $produits) {
                        if($produits["Prix"]>20){    
                            ?>
                    <div class="product">
                        <div class="product-content">
                            <?php if ($produits["Etat"] == 0) echo "Rupture de stock" ?>
                            <img src="./sary/<?php echo $produits["Image"] ?>" width="243">
                        </div>
                            <a href="./process/traitement.php?product=<?php echo $i; ?>"><button class="ajouter-panier">Ajouter au panier</button></a>
                            <figcaption><?php echo $produits["Nom"]; ?><br><span class="prix"><?php echo $produits["Prix"] ?>Ar</span></figcaption>
                    </div>
                    <?php } 
                    $i++;
                    } ?>
            </div>
        </div>
    </div>
</body>
</html>
<link rel="stylesheet" href="./Style/style_index.css">