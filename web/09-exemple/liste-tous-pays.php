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
        <h1>08 - Exemple : liste des pays</h1>
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <th>Pays</th>
                <th>Nombre de population</th>
                <th>Capitale</th>
                <th>Continent</th>
            </tr>
            <?php for($i=0;$i<$nbpays;$i++) { ?>
            <tr>
                <td><a href="pays.php?num=<?php echo $i; ?>"><?php echo $pays[$i]['nom']; ?></td>
                <td align="right"><?php echo $pays[$i]['population']; ?></td>
                <td align="right"><?php echo $pays[$i]['capitale']; ?></td>
                <td align="right"><?php echo $continent[$pays[$i]['continent']]; ?></td>
            </tr>  
            <?php } ?>  
        </table>
        <p><a href="index.php"><< Retour</a></p>
	</body>
</html>