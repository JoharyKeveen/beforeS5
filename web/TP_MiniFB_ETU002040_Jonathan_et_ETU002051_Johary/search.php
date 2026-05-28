<?php
include('connexion.php');
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Search</title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <link href="css/fontawesome-5/css/all.css" rel="stylesheet">
</head>
<?php include('navigation.php');?>
<body>
<?php 
	$name=$_POST['find'];
	$filtre=$_POST['type'];
	$namex=strtolower($name);
		if ($filtre=="membres"||$filtre=="any") {
			$resultm=mysqli_query($bdd,"select*from membres");
		}
		if ($filtre=="publications"||$filtre=="any") {
			$resultp=mysqli_query($bdd,"select*from publications join membres on publications.idMembre=membres.idMembre");
		}
		if ($filtre=="commentaires"||$filtre=="any") {
			$resultc=mysqli_query($bdd,"select*from commentaires join membres on commentaires.idMembre=membres.idMembre");
		}
 if ($filtre=="membres"||$filtre=="any") { ?>
		<h1> Les membres dispo:</h1>
		<table border="1">
			<th> Name </th>
			<th> First Name </th>
<?php while($film=mysqli_fetch_assoc($resultm)) {
		if ($namex=="") {
			$position=true;
		}
		else{
			$np="'".$film['Nom']."''".$film['Prenom']."'";
			$position=strpos(strtolower($np),$namex);
		}
		if ($position !== false) {
			if ($filtre=="membres"||$filtre=="any") { ?>
			<tr>
				<td> <?php echo $film['Nom'] ?> </td>
				<td> <?php echo $film['Prenom'];?> </td>
			</tr>
			<?php }
		}
	}} ?>
		</table>
<?php if ($filtre=="publications"||$filtre=="any") { ?>
	<h1> Les pubs:</h1>
<?php while($filp=mysqli_fetch_assoc($resultp)) {
		if ($namex=="") {
			$position=true;
		}
		else{
			$position=strpos(strtolower($filp['TextePublication']),$namex);
		}
		if ($position !== false) { 
			if ($filtre=="publications"||$filtre=="any") { ?>
    <div id="publication">
    		<span class="name"> @<?php echo $filp['Prenom']; echo "_"; echo $filp['Nom'];?>
                        <span style="color:lightblue"><i class="fas fa-check-circle"></i></span>
                    </a></span></span>
    		<span class="ora"><?php echo $filp['DateHeurePublication'];?></span>
            <?php if ($filp['idMembre']==$_SESSION['id']) { ?>
            <span class="md"><a href="edit.php?modif=<?php echo $filp['idPublication'];?>">
                        <span><i class="fas fa-edit"></i></a>
            <a href="edit.php?del=<?php echo $filp['idPublication'];?>">
                        <span><i class="fas fa-trash-alt"></i></span>
                    </a></span></a></span>
                <?php } ?>
        	<p id="p"> <?php echo $filp['TextePublication'];?></p>
    </div>
</br>
		<?php }
	 	}
	}
}
 if ($filtre=="commentaires"||$filtre=="any") { ?>
	<h1> Les coms des pubs:</h1>
<?php while($filc=mysqli_fetch_assoc($resultc)) {
		if ($namex=="") {
			$position=true;
		}
		else{
			$position=strpos(strtolower($filc['TexteCommentaire']),$namex);
		}
		if ($position !== false) { 
			if ($filtre=="commentaires"||$filtre=="any") { ?>
			<div id="publication">
				<span style="font-size:15px"> <?php  echo $filc['Prenom'];echo" "; echo $filc['Nom']; ?> </span>
                <span class="ora">  <?php echo $filc['DateHeureCommentaires']?> </span>
                <p style="margin-left:5%"> <?php echo $filc['TexteCommentaire'];?> </p>
            </div>
			<?php }
		}
	} 
} ?>
<center><a style="text-decoration:none" href="index.php"> BACK TO MyHOME </a></center>
</body>
</html>