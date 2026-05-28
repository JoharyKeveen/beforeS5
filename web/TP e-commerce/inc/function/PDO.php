<?php
    function pdo_mysql()
    {
        $bdd=new PDO("mysql:host=localhost;dbname=e_commerce", "root", "root");
        return $bdd;
    }
?>