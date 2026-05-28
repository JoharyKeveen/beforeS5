<?php
    include('../function/function.php');
    $id_prod=$_GET['id'];
    $_SESSION['panier'][]=$id_prod;
    header('location:../../index.php');
?>