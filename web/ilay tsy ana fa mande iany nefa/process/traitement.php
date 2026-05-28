<?php 
    session_start();

    //Include
    include("./data.php");
    include("./fonction.php");

    //Get category
    if (isset($_GET['category'])){
        $_SESSION['product_category'] = $_GET['category'];
    }

    if (isset($_GET['product'])){
        ajouter_panier($produit, $_GET['product']);
    }

    $_SESSION['product_size'] = get_product_number($produit, $_SESSION['product_category']);

    header("Location:../Grocery.php");
?>