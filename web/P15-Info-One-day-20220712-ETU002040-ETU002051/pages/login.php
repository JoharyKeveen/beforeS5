<?php 
	session_start();
?>
<!DOCTYPE html>
<html>
    <head>
        <title> Connect </title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
	<meta charset="UTF-8">
<div id="all">
	<?php if(isset($_GET['newaccount'])==false) { ?>
        <form action="../inc/traitement/connecting.php" method="post">
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
					<p> 
						<input type="checkbox" name="remember"/> Enregistrer le mot de passe 
						<span style="color:red"> <?php if (isset($_SESSION['error'])) {
						echo $_SESSION['error'];
						}?></span> 
						<a href="login.php?newaccount=1">Don't have account </a>
					</p>
				</span>
			</div>
		</form>
	<?php } else { ?>
		<div id="inscr"> 
			<form action="../inc/traitement/connecting.php" method="get">
				<p> Email: <input type="text" name="email" placeholder="Nom d'utilisateur"required> </p>
				<p> Password: <input type="password" name="password" placeholder="Mot de passe"required> </p>
				<button type="submit"> Create new account</button>
			</form>
			<a href="login.php">Connexion</a>
		</div>
	<?php } ?>
</div>
</body>
</html>