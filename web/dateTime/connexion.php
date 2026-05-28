<?php 
    function connexion()
    {
        $bdd=new PDO("mysql:host=localhost;dbname=datytime", "root", "root");
        return $bdd;
    }
?>