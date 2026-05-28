<?php
    include('../function/connexion.php');
    include('../function/function.php');
    $bdd=connexion();
    $requete=$bdd->query("SELECT*FROM equipe group by poules");
    $requete->setFetchMode(PDO::FETCH_OBJ);
    while($st=$requete->fetch())
    {
        generate_score($st->poules);
    }
    header("location:../../pages/result.php");
?>