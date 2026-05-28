<?php
    session_start();
    include('../inc/nav/header.php');
    $bdd=connex_bdd();
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Search</title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <link href="css/fontawesome-5/css/all.css" rel="stylesheet">
    <link href="../assets/css/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet">
    <link href="../assets/css/boot.css" rel="stylesheet">
</head>
<body>
<?php 
	$name=$_POST['find'];
	$filtre0=$_POST['P0'];
	$filtre1=$_POST['P1'];
	$filtre2=$_POST['P2'];
	$list_cv=get_filter($filtre0,$filtre1,$filtre2);
	$namex=strtolower($name);
?>
    <h1>
        Liste des Curruculum Vitae:
    </h1>
    <div class="row">
        <?php for($i=0;$i<count($list_cv);$i+=6){ ?>
            <div class='col-md-3'>
                <div class="row" style="margin:auto;">
                    <img src="../assets/img/<?php echo $list_cv[$i+5];?>" width="100%" alt="error">
                    <p> Nom: <?php echo $list_cv[$i+2]; ?> </p>
                    <p> Prénom: <?php echo $list_cv[$i+3]; ?> </p>
                    <p> Date de naissance: <?php echo $list_cv[$i+4]; ?> </p>
                </div>
                <div class="row">
                    <div class='col-md-8'>
                        <a href="#"> <span>View details</span> </a>
                        <?php if(is_mine($_SESSION['id'],$list_cv[$i+1])==true){ ?>
                            <a href="#"> Edit<span class="glyphicon glyphicon-pencil"></span> </a>
                        <?php } ?>
                    </div> 
                </div>
            </div>
        <?php } ?>
    </div>
		</table>
</body>
<?php include('../inc/nav/footer.php'); ?>
</html>