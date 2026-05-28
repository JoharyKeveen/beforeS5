<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>MyDrugs.to</title>
	<link rel="stylesheet" type="text/css" href="css/nav.css">
</head>
<body>
			<div id="nav">
					<div class="letter"> <a href="index.php"> 
                        <span><i class="fas fa-2x fa-home"></i></span> 
                    </a> </div>
					<div>
						<form action="search.php" method="post"> 
							<input type="text" name="find" placeholder="rechercher votre bonheur"> </input>
							<select name="type">
								<option value="any"> Filtre </option>
								<option value="membres"> Membres </option>
								<option value="publications"> Publications </option>
								<option value="commentaires"> Commentaires </option>
							</select>
							<input type="submit" value="rechercher"> </input>
						</form>
					</div>
					<img src="picture/logo.JPG" width="10%"> </img>
					<div class="letter"> <a href="member.php"> 
                        <span><i class="fas fa-2x fa-user-friends"></i></span> 
                    </a> </div>
					<div class="letter"> <a href="profil.php">  
                        <span><i class="fas fa-2x fa-user-cog"></i></span> 
                    </a> </div>
					<div> <button> <a href="destroy.php"> LOG OUT </a> </button></div>
			</div>
</body>
</html>