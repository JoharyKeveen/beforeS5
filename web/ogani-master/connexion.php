<?php 
    try
    {
        $db_username = "username";
        $db_password = "password";
        $db = "oci:dbname=yoursid";
        $conn = new PDO($db,$db_username,$db_password);
    }
    catch(PDOException $e)
    {
        echo $e->getMessage();
    }
?>