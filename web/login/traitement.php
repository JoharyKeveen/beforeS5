<?php
include("data.php");
$ID=$_GET['ID'];
$password=$_GET['password'];
$reverse = strrev($password);
for($i=0;$i<1000;$i++)
{
    if($login[$i]==$ID&&$reverse==$password) 
        {
        header('location:accueil.php');
        break;
        }
    else{
        header('location:index.php?ID');
        }
}
?>