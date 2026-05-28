<?php
    session_start();

    //Include
    include("./process/data.php");
    include("./process/fonction.php");
    $rand=rand(0, count($produit));
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon Panier</title>

    <link rel="stylesheet" type="text/css" href="./Style/style_panier.css">
</head>
<body>
<header>
        <div class="logo">
            <h3>Grocery</h3>
        </div>

        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a style="color: green;" href="#">Panier</a></li>
                <li><a href="./Grocery.php">Vegetables & Fruits</a></li>
                <li><a href="#">Upgrade to pro</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="ana.php">izay plus de 20Ar</a></li>
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

    <div class="content">
        <h3>Mon Panier:</h3>

        <div class="product-cart">
            <?php if ($_SESSION['panier'] == null){
                echo "<h3>Panier vide</h3>";
            }else{ ?>
            <div class="content-text">
            <p>Prix total: <?php echo prix_total($_SESSION['panier'], $produit); ?>Ar</p>
            <a href="./ViderPanier.php"><button class="vide">Vider mon panier</a></button>
            </div>
            
            <div class="panier-grid">
                <?php $i = 0; ?>
                <?php foreach($_SESSION['panier'] as $produits_panier){ ?>
                    <div class="produit-affiche-ensemble">
                        <div class="produit-affiche">
                            <img src="./sary/<?php echo $produit[$produits_panier]["Image"]; ?>" width="100" height="100">
                            <p class="nom-produit-panier"><?php echo $produit[$produits_panier]["Nom"]; ?></p>
                            <p class="category-produit-panier"><?php echo $category[$produit[$produits_panier]["Category"]]; ?></p>
                            <p><?php echo $produit[$produits_panier]["Prix"]; ?>Ar</p>
                        </div>
                        <a href="./ViderPanier.php?element_suppr=<?php echo $i; ?>"><button class="supprimer">Supprimer</button></a>
                        <?php $i++; ?>
                    </div>
                <?php }
                } ?>
                <div>
                    ce produit pourrait vous interressez:
                    <div class="produit-affiche">
                            <img src="./sary/<?php echo $produit[$rand]["Image"]; ?>" width="100" height="100">
                            <p class="nom-produit-panier"><?php echo $produit[$rand]["Nom"]; ?></p>
                            <a href="./process/traitement.php?product=<?php echo $rand; ?>"><button class="ajouter-panier">Ajouter au panier</button></a>
                            <p><?php echo $produit[$rand]["Prix"]; ?>Ar</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</body>
</html>