<?php
include('connexion.php');
if (isset($_SESSION['connexion'])) {
	if ($_SESSION['connexion']=="authorized") {
 		header('location:index.php');
 	} 
}
?>
<!DOCTYPE html>
<html>
    <head>
        <title> MyDrugs.to </title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body style="background-color:rgb(9,9,9);background-size:cover;">
	<meta charset="UTF-8">
<div id="all_">
<div id="head"> 
     	<img src="picture/logo.JPG" width=90% style="margin-top:6%;"> </img>
     </div>
<div id="all">
        <form action="verification.php" method="post">
			<div id="login">
				<span> 
					<?php
					 if (isset($_SESSION['add_account'])){
					 	echo $_SESSION['add_account'];
					 }
					 ?> 
				</span>
					<span> ID <input type="email" name="id" placeholder="Nom d'utilisateur"required> </span>
				<span> Password <input type="password" name="pass" placeholder="Mot de passe"required> </span>
					<span> <button type="submit"> Login </button> </span>
				<span id="cm"> 
					<p> <input type="checkbox" name="remember"/> Enregistrer le mot de passe </p>
					<span style="color:red"> <?php if (isset($_SESSION['error'])) {
						echo $_SESSION['error'];
					}?></span> 
				</span>
			</div>
		</form>
		<div id="inscr" style="background-color:rgb(9,9,9);"> 
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
				<button type="submit"> Create new account</button>
			</form>
		</div>
</div>
</body>
</html>