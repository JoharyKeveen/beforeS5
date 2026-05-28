<?php 
	session_start();
	include('../function/connexion.php');
	require_once('../function/function.php');
	$bdd=connex_bdd();
    edit_para($_POST['P1v'],$_POST['P1c'],$_POST['P2v'],$_POST['P2c'],$_POST['P3v'],$_POST['P3c']);
    header('location:../../pages/accueil.php');
?>