<?php
session_start();
if(!isset($_SESSION['anarana'])){
    header('Location:index.php');
}
$anarana=$_SESSION['anarana'];
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
        <h1>Test</h1>
        <p>Bonjour <?php echo $anarana; ?></p>
        <form action="home.php" method="post">
            <p>Entrer votre <b>NOUVEAU</b> nom: <input type="text" name="nom" /></p>
            <input type="submit" value="Valider" />    
        </form>
        <ul>
        	<li><a href="index.php">Index</a></li>
        </ul>
	</body>
</html>