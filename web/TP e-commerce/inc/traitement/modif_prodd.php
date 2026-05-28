<?php
    include('../function/function.php');
    modif_prod($_GET['id'],$_GET['nom'],$_GET['marque'],$_GET['dispo'],$_GET['prix']);
    header('location:../../index.php');
?>