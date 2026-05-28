<?php
    require_once('connexion.php');
	// Verifie si la personne peut se connecter
	function check_login($name,$mdp)
	{
		$bdd=connex_bdd();
		$sentence="select * from Membre where email='%s' and pwd='%s'";
		$sql=sprintf($sentence,$name,$mdp);
        $yop=mysqli_query($bdd,$sql);
        while($data=mysqli_fetch_assoc($yop)){
			$retour=$data;
        }
		return $retour;
    }

	// insertion publication
	function insert_pub($publication,$nom)
	{
		$bdd=connex_bdd();
		mysqli_query($bdd,'INSERT INTO publications VALUES (null,now(),"'.$publication.'","'.$nom.'")');
	}
	// insertion publication
	function insert_coms($coms,$idpub,$nom)
	{
		$bdd=connex_bdd();
		mysqli_query($bdd,'INSERT INTO commentaires VALUES (null,now(),"'.$coms.'","'.$idpub.'","'.$nom.'")');
	}

	// show all publications
	function show_pub()
	{
		$bdd=connex_bdd();
		$dt=mysqli_query($bdd,'select * from publications');
		$i=0;
		$retour=array();
        while($data=mysqli_fetch_assoc($dt)){
			$retour[$i]=$data;
			$i++;
        }
		return $retour;
	}
?>