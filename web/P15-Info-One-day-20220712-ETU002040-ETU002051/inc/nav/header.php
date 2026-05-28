<?php
   include('../inc/function/function.php');
   $descri=get_descri();
   $_SESSION['adm']="";
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/nav.css">
    <link href="../../assets/css/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet">
    <link href="../../assets/css/boot.css" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class='col-md-2'>
			<a href="../pages/accueil.php"> @<?php echo get_user($_SESSION['id']); ?> </a>
		</div>
		<div class='col-md-1'>
			<a href="../pages/stat_cv.php"> Statistique </a> 
	    	<?php echo $_SESSION['adm']; ?>
		</div>
		<div class='col-md-6'>
			<form action="search_cv.php" method="post"> 
				<input type="text" name="find" placeholder="rechercher votre bonheur"> </input>
			    <?php
			        for($i=0;$i<count($descri);$i++)
			        { $choice=get_choice($descri[$i]); ?>
			            <select name="P<?php echo $i; ?>">
			                	<option value="any"><?php echo $descri[$i];?>	</option>
			                <?php for($j=0;$j<count($choice);$j++) { ?>
			                    <option value="<?php echo $choice[$j]?>"><?php echo $choice[$j]?></option>
			                <?php } ?>
			            </select>
			        <?php } ?>
				<input type="submit" value="rechercher"> </input>
			</form>
		</div>
		<div class='col-md-1'>
			<button> <a href="../inc/traitement/destroy.php"> LOG OUT </a> </button>
		</div>
	</div>
</body>
</html>