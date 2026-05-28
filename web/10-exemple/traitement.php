<?php
session_start();
$_SESSION['anarana']=$_POST['nom'];
header('Location:home.php');
?>