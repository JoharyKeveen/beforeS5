<!DOCTYPE html>
<html>
	<head>
		<title> Site </title>
		<link rel="stylesheet" type="text/css" href="02.css">
	</head>
	<body>
    <form action="categorie.php">
    <div id="page">
		<div id="header" >
		</div>
        <div id="ambony">
            <a href="#">Accueil</a>
            <a href="#">A propos</a>
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
            <table>
            <th >
                <a href="categorie.php?cat=Animaux">
                    <img src="image/foke.jpg" width="100px" height="100px" >
                </a>
                <p >Animaux</p>
            </th>
            <th>
                <a href="categorie.php?cat=People">
                    <img src="image/olona.jpg" width="100px" height="100px">
                </a>
                <p >People</p>
            </th>
            <th>
                <a href="categorie.php?cat=Paysage">
                    <img src="image/hazo.jpg" width="100px" height="100px">
                </a>
                <p >Paysage</p>
            </th>
            </table>

            <table>
            <th >
                <a href="categorie.php?cat=Nature">
                    <img src="image/nature.jpg" width="100px" height="100px" >
                </a>
                <p >Nature</p>
            </th>
            <th >
                <a href="categorie.php?cat=Batiments">
                    <img src="image/trano.jpg" width="100px" height="100px">
                </a>
                <p >Batiments</p>
            </th>
            <th>
                <a href="categorie.php?cat=Objets">
                    <img src="image/obj.jpg" width="100px" height="100px">
                </a>
                <p >Objets</p>
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