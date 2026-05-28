<?php
include('connexion.php');
	$test=mysqli_query($bdd,"select * from reactions where idPublication='".$_POST['idP']."' and idMembre='".$_SESSION['id']."'");
	$count=0;
	while ($react=mysqli_fetch_assoc($test)) {
		if($_POST['TypeReact']==0){
			break;
		}
		mysqli_query($bdd,"delete from reactions where idTypeReaction=0");
			if($react['idTypeReaction']==$_POST['TypeReact']&&$react['idMembre']==$_SESSION['id']) {
				mysqli_query($bdd,"delete from reactions where idTypeReaction='".$_POST['TypeReact']."' and idMembre='".$_SESSION['id']."' and idPublication='".$_POST['idP']."'");
				$count++;
			header('location:index.php');
			}
			if($react['idTypeReaction']!=$_POST['TypeReact']&&$react['idTypeReaction']!=0) {
				mysqli_query($bdd,"update reactions set idTypeReaction='".$_POST['TypeReact']."' where idMembre='".$_SESSION['id']."' and idPublication='".$_POST['idP']."'");
				$count++;
			header('location:index.php');
			}
	}
		if($count==0&&$_POST['TypeReact']!=0) {
			mysqli_query($bdd,"INSERT INTO reactions VALUES('".$_POST['idP']."','".$_SESSION['id']."','".$_POST['TypeReact']."')");
		}
		header('location:index.php');
?>