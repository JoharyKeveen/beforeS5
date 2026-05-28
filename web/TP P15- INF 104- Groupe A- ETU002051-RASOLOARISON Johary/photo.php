<?php
$cat=$_GET['cat'];
?>
<!DOCTYPE html>
<html>
	<head>
		<title> Site </title>
		<link rel="stylesheet" type="text/css" href="02.css">
	</head>
	<body>
	<div id="page">
		<div id="header" >
		</div>
        <div id="ambony">
            <a href="accueil.php">Accueil</a>
            <a href="categorie.php">A propos</a>
        </div>
		
		</br>
		
		<div id="nav">
			<div id="nav0">
            <ul>
				<li><a href="categorie.php?cat=Animaux">Animaux</a></li>
				<li><a href="categorie.php?cat=People">People</a></li>
                <li><a href="categorie.php?cat=Paysage">Paysage</a></li>
                <li><a href="categorie.php?cat=Nature">Nature</a></li>
                <li><a href="categorie.php?cat=Batiments">Batiments</a></li>
                <li><a href="categorie.php?cat=Objets">Objets</a></li>
			</ul>
		</div>
		</div>
		
		<div id="content">
            <h1>
                Photos de la categorie: <?php echo $cat; ?>
            </h1>
			<p>
				<a href="categorie.php">Retour</a>
			</p>
            <table>
            <th >
                <img src="image/1.jpg" width="500px" height="500px" >
                <p >Photo1</p>
            </th>

		<div id="footer">
        <p>&copy; Copyright 2020</p>
		</div>
	</div>
	</body>
</html>