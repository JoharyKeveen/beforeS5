<?php 
    session_start();

    include("./process/data.php");
    include("./process/fonction.php");

    //Initializing
    $_SESSION['product_category'] = 0;
    $_SESSION['product_size'] = 5;

    //Panier Init
    $_SESSION['panier'] = (array) null;
    $_SESSION['produit_ajouter'] = null;
    $_SESSION['taille_panier'] = 0;
    
    header("Location: ./Grocery.php");
?>