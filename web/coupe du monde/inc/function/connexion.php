<?php 
    function connexion()
    {
        $bdd=new PDO("mysql:host=localhost;dbname=foot", "root", "root");
        return $bdd;
    }
?>