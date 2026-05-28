<!DOCTYPE html>
<html>
    <head>
        <title>Exemple PHP</title>
        <meta charset="UTF-8"> 
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
        <h1>04 - Exemple PHP</h1>
        <p><a href="liste-tous-pays.php">Liste de tous les pays</a></p>
        <form action="liste-pays.php" method="get">
            <p>Afficher  
            <select name="nombre">
                <option value="">Choisir Nombre</option>
                <option value="10">10 mipoitra</option>
                <option value="20">20</option>
                <option value="30">30</option>
                <option value="40">40</option>
            </select>
                pays
            </p>
            <input type="submit" value="Valider" />    
        </form>
	</body>
</html>