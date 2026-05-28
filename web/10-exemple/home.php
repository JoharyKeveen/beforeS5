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
        <h1>Home</h1>
        <p>Bonjour <?php echo $anarana; ?></p>
         <ul>
            <li><a href="test.php">Testconnexion</a></li>
            <li><a href="index.php">Index</a></li>
             <li><a href="deconnexion.php">Deconnexion</a></li>
        </ul>
	</body>
</html>