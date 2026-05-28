<?php
    include("data.php"); 
?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>

<body>
	<?php
	if(isset($_GET['numS1'])) 
	{ ?> 
	<h1>Liste des eleves de S1:</h1>
	<?php

		for($h=0;$h<10;$h++) {
			if($etudiant[$h]['prom']==0) {?>
		
			<p><?php echo $etudiant[$h]['nom']; ?> <?php echo $etudiant[$h]['prenom'];?></p>

				<?php  }
	}	
	}
	?>		
	<?php
	if(isset($_GET['numS3']))
	{ ?>
	<h1>Liste des eleves de S3:</h1> 
	<?php
		for($h=0;$h<10;$h++) {
			if($etudiant[$h]['prom']==1) {?>
		
			<p><?php echo $etudiant[$h]['nom']; ?> <?php echo $etudiant[$h]['prenom'];?></p>

				<?php  }
	}	
	}
	?>
	<?php
	if(isset($_GET['numS5']))
	{ ?>
	<h1>Liste des eleves de S5:</h1>
	<?php

		for($h=0;$h<10;$h++) {
			if($etudiant[$h]['prom']==2) {?>
		
			<p><?php echo $etudiant[$h]['nom']; ?> <?php echo $etudiant[$h]['prenom'];?></p>

				<?php  }
	}	
	}
	?>

</body>
</html>