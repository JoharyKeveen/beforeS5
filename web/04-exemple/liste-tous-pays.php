<?php
    include("data.php");
    $nbpays=count($pays);
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
        <h1>04 - Exemple : liste des pays</h1>
        <ul>
        <?php for($i=0;$i<$nbpays;$i++) { ?>
            <li><?php echo $pays[$i]; ?></li>
        <?php } ?>
        </ul>
        <p><a href="index.php"><< Retour</a></p>
	</body>
</html>