<?php
    function insertPointage($numEmp,$entrer,$sortie)
    {
        $bdd=connexion();
		$bdd->exec("INSERT into pointage values(null,".$numEmp.",'".$entrer."','".$sortie."')");
    }
?>