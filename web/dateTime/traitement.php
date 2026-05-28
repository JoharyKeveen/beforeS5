<?php
    include('connexion.php');
    include('function.php');
    $entrer=$_POST['dateE']." ".$_POST['heureE'].":".$_POST['minuteE'].":".$_POST['secondeE'];
    $sortie=$_POST['dateS']." ".$_POST['heureS'].":".$_POST['minuteS'].":".$_POST['secondeS'];
    insertPointage(1,$entrer,$sortie);
    echo($_POST['dateE']);
    // header("location:index.php");
?>