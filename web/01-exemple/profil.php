<?php
    $nom =$_POST['anarana'];
    $annee_naissance=$_POST['annee_naissance'];
    $age = 2021 - $annee_naissance;
    $ville=$_POST['ville'];
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="TP1.css">
	</head>
	<body>
        <h1>Exemple PHP</h1>
        <p>Bonjour <span id="nom"><?php echo $nom; ?></span>
        , vous avez <span id="age"><?php echo $age; ?></span>
        ans.Vous habituez a <span id="ville"><?php echo $ville; ?></span>
        <p><a href="index.php"><< Retour</a></p>
	</body>
</html>