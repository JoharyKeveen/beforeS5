<?php 
	include('connexion.php');
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title> Modif </title>
</head>
<body>
	<?php if (isset($_GET['del'])) { ?>
		<h1> Voulez-vous vraiment supprimer</h1>
		<p><a href="edit.php?del=<?php echo $_GET['del']?>&&confirmation=oui"> OUI, Je le veux </a></p>
		<p><a href="index.php"> NON, Ta gueule </a></p>
	<?php
		if(isset($_GET['confirmation'])){
			$result=mysqli_query($bdd,"delete from publications where idPublication='".$_GET['del']."'"); 
			header('location:index.php');
		}
	}
		if (isset($_GET['modif'])) { ?>
			<form method="get">
				<?php
					if (isset($_GET['modif'])) {
						$_SESSION['indic']=$_GET['modif'];
					}
					$publications=mysqli_query($bdd,"select * from publications where idPublication='".$_SESSION['indic']."'");
					while($pub=mysqli_fetch_assoc($publications)) {
				?>
				<h3> <input style="width: 1000px" type="text" name="pubs" value="<?php echo $pub['TextePublication']; ?>"> </input> </h3>
				<input type="submit" value="Change"> </input>
			</form>
		<?php } } 
			if(isset($_GET['pubs'])) {
				$result=mysqli_query($bdd,"update publications set TextePublication='".$_GET['pubs']."' where idPublication='".$_SESSION['indic']."'");
				mysqli_free_result($result);
				header('location:index.php'); 
			} ?> 


	<?php if (isset($_GET['delc'])) { ?>
		<h1> Voulez-vous vraiment supprimer</h1>
		<p><a href="edit.php?delc=<?php echo $_GET['delc']?>&&confirmation=oui"> OUI, Je le veux </a></p>
		<p><a href="index.php"> NON, Ta gueule </a></p>
	<?php
		if(isset($_GET['confirmation'])){
			$result=mysqli_query($bdd,"delete from commentaires where idCommentaires='".$_GET['delc']."'"); 
			header('location:index.php');
		}
	}
		if (isset($_GET['modifc'])) { ?>
			<form method="get">
				<?php
					if (isset($_GET['modifc'])) {
						$_SESSION['ind']=$_GET['modifc'];
					}
					$commentaires=mysqli_query($bdd,"select * from commentaires where idCommentaires='".$_SESSION['ind']."'");
					while($pub=mysqli_fetch_assoc($commentaires)) { 
				?>
				<h3> <input style="width:1000px" type="text" name="coms" value="<?php echo $pub['TexteCommentaire']; ?>"> </input> </h3>
				<input type="submit" value="Change"> </input>
			</form>
		<?php } } 
			if(isset($_GET['coms'])) {
				$result=mysqli_query($bdd,"update commentaires set TexteCommentaire='".$_GET['coms']."' where idCommentaires='".$_SESSION['ind']."'");
				mysqli_free_result($result);
				header('location:index.php'); 
			} ?> 
</body>
</html>