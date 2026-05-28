<?php 
	session_start();
	include('../function/connexion.php');
	require_once('../function/function.php');
	$bdd=connex_bdd();

	if (check_login($_POST['id'],$_POST['pass'])!=0) {
		$_SESSION['id']=check_login($_POST['id'],$_POST['pass']);
		$_SESSION['connexion']="authorized";
		header('location:../../pages/accueil.php');
	}
	else{
		$_SESSION['error']="Nom d'utilisateur ou mot de passe incorrecte";
		header('location:../../pages/login.php');
	}

	if(isset($_GET['email'])&&isset($_GET['password'])){
		if(new_account($bdd,$_GET['email'],$_GET['password'])==true){
			$_SESSION['add_account']="Compte créer avec succes,connectez-vous pour confirmer votre nouveau compte";
			header('location:../../pages/login.php');
		}
	}
?>