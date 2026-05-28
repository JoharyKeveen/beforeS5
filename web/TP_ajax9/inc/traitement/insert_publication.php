<?php
include('../function/function.php');
session_start();
echo insert_pub($_POST['publication'],$_SESSION['nom']);
?>