<?php 
    try
    {
        $bdd=new PDO("pgsql:host=localhost;dbname=public", "postgres", "root");
    }
    catch(PDOException $e)
    {
        echo $e->getMessage();
    }
?>