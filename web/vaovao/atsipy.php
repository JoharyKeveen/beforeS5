<?php
    include("data.php");
    $nbetudiant=count($etudiant);
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
        <h1>TAFIDITRA IANAO MARINA MAFY</h1>
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Age</th>
                <th>Ville</th>
                <th>Classe</th>
                <th>Photo</th>
            </tr>
            <?php for($i=0;$i<$nbetudiant;$i++) { ?>
            <tr>
                <td align="center"><?php echo $etudiant[$i]['nom']; ?></td>
                <td align="center"><?php echo $etudiant[$i]['prenom']; ?></td>
                <td align="center"><?php echo calculAge($etudiant[$i]['date_de_naissance']); ?> ans</td>
                <td align="center"><?php echo $etudiant[$i]['ville']; ?></td>
                <td align="center"><a href="classe.php?num<?php echo $prom[$etudiant[$i]['prom']]; ?>"><?php echo $prom[$etudiant[$i]['prom']]; ?></a></td>
                <td align="center"><img src="<?php echo $photo[$etudiant[$i]['photo']]; ?>.jpg" width="50px" height="40px"></td>
            </tr>  
            <?php } ?>  
        </table>
        <p><a href="index.php"><< Retour</a></p>
	</body>
</html>