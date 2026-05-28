<?php
    $nombre=$_POST['nombre'];
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
        <h1>02 - Exemple PHP</h1>
        <ul>
        <?php for($i=0;$i<=$nombre;$i++) { ?>
            <li><?php echo $i; ?></li>
        <?php } ?>
        </ul>
        <p><a href="index.php"><< Retour</a></p>
	</body>
</html>