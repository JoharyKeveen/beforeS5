<?php 	
	function connect_bdd()
    {
        $user='postgres';
        $pass='root';
        $dsn='pgsql:host=localhost;port=5432;dbname=immobilier';
        try 
        {
            $dbh = new PDO($dsn, $user, $pass);
            return $dbh;
        } catch (Exception $e) 
        {
            echo($e->getMessage());
        }
    }
?>