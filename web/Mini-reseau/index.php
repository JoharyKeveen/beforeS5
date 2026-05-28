<?php
session_start();
	if ($_SESSION['connexion']!="authorized") {
		header('location:login.php');
	}
	$bdd=mysqli_connect('localhost','root','root','mydrugs');
	mysqli_set_charset($bdd,"utf8");
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>
<?php include("navigation.php"); ?>
<body>
    <form action="index.php" method="post">
        <select name="audience" id="">
            <option value="0">public</option>
            <option value="1">amis</option>
        </select>
        <input type="text" name="publication">
        <input type="hidden" value="publier">
        <input type="submit" value="publier">
    </form>
	<?php
        if(isset($_POST['publication']))
        {
            mysqli_query($bdd,"INSERT INTO publications VALUES (null,now(),'".$_POST['publication']."','".$_POST['audience']."','".$_SESSION['id']."')");
        }
    ?>
    	<?php
    	$result=mysqli_query($bdd,"select * from publications");
    	 while($data=mysqli_fetch_assoc($result))
        { ?>
    <div style="border:solid">
    		<h1> By <?php echo $data['idMembre']['Nom'];?><?php echo $data['idMembre']['Prenom'];?></h1>
    		<p> <?php echo $data['DateHeurePublication'];?></p>
        	<p> <?php echo $data['TextePublication'];?></p>
	<span>
		<form action="index.php" method="post">
        <input type="hidden" name="idP" value=<?php echo $data['idPublication'];?>>
        <input type="text" name="commentaire">
        <input type="submit" value="commenter">
    </span>
    </div>
    </form>
	<?php
        if(isset($_POST['commentaire']))
        {
            mysqli_query($bdd,"INSERT INTO commentaires VALUES (null,now(),'".$_POST['commentaire']."','".$_POST['idP']."','".$_SESSION['id']."')");
        }
    ?>
        <?php } ?>
</body>
<?php include("footer.php"); ?>
</html>