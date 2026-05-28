<?php 
    session_start();

    //include
    include("./process/fonction.php");

    if (isset($_GET['element_suppr'])){
        enlever_element($_GET['element_suppr']);
    }else{
        $_SESSION['panier'] = (array) null;
        $_SESSION['taille_panier'] = 0;
    }
    
    header("Location: ./Panier.php");
?>