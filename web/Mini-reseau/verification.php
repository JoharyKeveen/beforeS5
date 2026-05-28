<?php 
session_start();
	$bdd=mysqli_connect('localhost','root','root','mydrugs');
	mysqli_set_charset($bdd,"utf8");

	$sentence="select * from membres where Email='%s'";
	$sql=sprintf($sentence,$_POST['id']);
	$id=mysqli_query($bdd,$sql);
	$sentencee="select * from membres where Motdepasse='%s'";
	$sqll=sprintf($sentencee,$_POST['pass']);
	$pass=mysqli_query($bdd,$sqll);
	while($data=mysqli_fetch_assoc($id)){
		while($dataa=mysqli_fetch_assoc($pass)) {	
			echo $data['idMembre'];
			echo "Gal 2:20";
			echo $dataa['idMembre'];
			if($data['idMembre']==$dataa['idMembre']){
				$_SESSION['connexion']="authorized";
				$_SESSION['id']=$data['idMembre'];
				header('location:index.php');
			}
		}
	}
				header('location:login.php');

		
	if(isset($_GET['name'])&&isset($_GET['prenom'])&&isset($_GET['email'])&&$_GET['pass']&&$_GET['repass']&&$_GET['day']&&$_GET['month']&&$_GET['year']){
		if ($_GET['email']!="") {
			if ($_GET['month']<10) {
				$phrase="%d-0%d-%d";
			}
			else{
				$phrase="%d-%d-%d";
			}
		$date=sprintf($phrase,$_GET['year'],$_GET['month'],$_GET['day']);
		$result=mysqli_query($bdd,"insert into membres value(null,'".$_GET['name']."','".$_GET['prenom']."','".$_GET['email']."','".$_GET['pass']."','".$date."')");
		mysqli_free_result($result);
		$_SESSION['connexion']="authorized";
		header('location:index.php');
		}
	}
?>
