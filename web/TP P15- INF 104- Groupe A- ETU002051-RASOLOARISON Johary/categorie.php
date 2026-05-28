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
    <form action="photo.php">
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
            <table>
            <th >
                <a href="photo.php?cat=Animaux">
                    <img src="image/1.jpg" width="100px" height="100px" >
                </a>
                <p >Photo1</p>
            </th>
            <th>
                <a href="photo.php?cat=People">
                    <img src="image/2.jpg" width="100px" height="100px">
                </a>
                <p >Photo2</p>
            </th>

            </table>

            <table>
            <th >
                <a href="photo.php?cat=Nature">
                    <img src="image/3.jpg" width="100px" height="100px" >
                </a>
                <p >Photo3</p>
            </th>
            <th >
                <a href="photo.php?cat=Batiments">
                    <img src="image/4.jpg" width="100px" height="100px">
                </a>
                <p >Photo4</p>
            </th>
            </table>
		</div>
		
		<div id="footer">
        <p>&copy; Copyright 2020</p>
		</div>
	</div>
    </form>
	</body>
</html>