<?php
session_start();
if (isset($_SESSION['connexion'])) {
	if ($_SESSION['connexion']=="authorized") {
 		header('location:index.php');
 	} 
}
	$bdd=mysqli_connect('localhost','root','root','mydrugs');
	mysqli_set_charset($bdd,"utf8");
?>
<!DOCTYPE html>
<html>
    <head>
        <title> MyDrugs.to </title>
		<link rel="stylesheet" type="text/css" href="#.css">
	</head>
	<body>
	<meta charset="UTF-8">
     <div id="head"> 
     	<img src="picture/logo.JPG" width=10%> </img>
     </div>
        <form action="verification.php" method="post">
			<div id="login">
					<span> ID <input type="email" name="id" placeholder="Nom d'utilisateur"required> </span>
				<span> Password <input type="password" name="pass" placeholder="Mot de passe"required> </span>
					<span> <input type="submit" name="connexion" value="Login" /> </span>
				<span id="cm"> 
					<p> <input type="checkbox" name="remember"/> Enregistrer le mot de passe </p> 
				</span>
			</div>
		</form>

		<div> 
			<form action="verification.php" method="get">
				<p> Name: <input type="text" name="name" placeholder="Nom"required> </p>
				<p> Prenom: <input type="text" name="prenom" placeholder="Prenom"required> </p>
				<p> Email: <input type="text" name="email" placeholder="Nom d'utilisateur"required> </p>
				<p> Password: <input type="password" name="pass" placeholder="Mot de passe"required> </p>
				<p> Confirmation: <input type="password" name="repass" placeholder="Confirmer votre mot de passe"required> </p>
					<?php 
						if(isset($_GET['pass'])&&isset($_GET['repass'])){
							if($_GET['pass']!=$_GET['repass']){
								echo "Mot de passe incohérent";
							}
						}
					?>
				<span>
					<p> Date de naissance:
					<select name="day"> 
						<option> Jour </option>
						<?php
						 for ($i=1;$i<=31;$i++) { ?> 
							<option value="<?php echo $i; ?>"><?php echo $i; ?></option>
						<?php } ?>
					</select>
					<select name="month"> 
						<option> Mois </option>
						<?php for ($j=1;$j<=12;$j++) { ?> 
							<option value="<?php echo $j; ?>"><?php echo $j; ?></option>
						<?php } ?>
					</select>
					<select name="year"> 
						<option> Année </option> 
						<?php for ($k=2022;$k>1970;$k--) { ?> 
							<option value="<?php echo $k; ?>"><?php echo $k; ?></option>
						<?php } ?>
					</select>
					</p>
				</span>
				<span> <input type="submit" name="connexion" value="Create new account" /> </span>
			</form>
		</div>
	</body>
</html>