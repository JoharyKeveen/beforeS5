<?php
    include("data.php");
    $num=$_GET['num'];

?>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
        <h1>05 - Exemple </h1>
        <h2><?php echo $pays[$num]; ?></h2>
        <p><a href="liste-tous-pays.php"><< Retour</a></p>
	</body>
</html>