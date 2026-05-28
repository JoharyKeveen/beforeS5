<?php
include('../function/function.php');
session_start();
echo insert_coms($_POST['data'],$_POST['num'],$_SESSION['nom']);
?>