<?php
include('../function/function.php');
header("Content-Type: application/json");
$name=$_POST['email'];
$pwd=$_POST['pwd'];
$retour=check_login($name,$pwd);
echo json_encode($retour);
?>