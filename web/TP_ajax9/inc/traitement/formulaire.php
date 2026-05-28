<?php
include('../function/function.php');
header("Content-Type: application/json");
session_start();
$name=$_POST['name'];
$pwd=$_POST['pwd'];
$retour=check_login($name,$pwd);
$_SESSION['nom']=$retour['nom'];
echo json_encode($retour);
?>