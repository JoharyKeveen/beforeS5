<?php
    include("data.php");
	include("fonction.php");
	$string='ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	$num=$_GET['num'];
	
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Dir</title>
        <meta charset="UTF-8">
	</head>
	<body>
        <h1>Les pays commencant par <?php echo $num; ?>:</h1>
			<?php $valiny=affiche($num,$pays); ?>
		<p><a href="index.php"> Retour </a></p>
	</body>
</html>