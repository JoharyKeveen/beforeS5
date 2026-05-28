<?php
	function generate_score($poule)
	{
		$bdd=connexion();
		$requete=$bdd->query("SELECT*FROM equipe where poules='".$poule."'");
		$requete->setFetchMode(PDO::FETCH_OBJ);
		$equipe=array();
		$i=0;
		while($st=$requete->fetch())
		{
			$equipe[$i]['nom']=$st->nom;
			$equipe[$i]['pt']=$st->pt;
			$equipe[$i]['poules']=$st->poules;
			$i++;
		}
		$count=3;
		$manomboka=0;
		while($count>0)
		{
			for($index=$manomboka+1;$index<count($equipe);$index++)
			{
				$pt_manomboka=$bdd->query("SELECT pt FROM equipe where nom='".$equipe[$manomboka]['nom']."'");
				$pt_manomboka->setFetchMode(PDO::FETCH_OBJ);
				$st_manomboka=$pt_manomboka->fetch();

				$pt_index=$bdd->query("SELECT pt FROM equipe where nom='".$equipe[$index]['nom']."'");
				$pt_index->setFetchMode(PDO::FETCH_OBJ);
				$st_index=$pt_index->fetch();
				$score=rand(0,2);

				if($score==0)
				{
					$score1=$st_manomboka->pt;
					$score2=$st_index->pt+3;
					$rand1=rand(1,7);
					$rand2=rand(0,$rand1);
					$requete=$bdd->exec("UPDATE equipe set pt='".$score1."' where nom='".$equipe[$manomboka]['nom']."'");
					$requete=$bdd->exec("UPDATE equipe set pt='".$score2."' where nom='".$equipe[$index]['nom']."'");
					$requete=$bdd->exec("INSERT into matches values('".$equipe[$manomboka]['nom']."','".$equipe[$index]['nom']."',".$rand2.",".$rand1.")");
					echo "'".$equipe[$manomboka]['nom']."' : '".$score1."' : resy ////////////";
					echo "'".$equipe[$index]['nom']."' : '".$score2."' : nandresy";
					echo "</br>";
				}
				else if($score==1)
				{
					$rand=rand(0,7);
					$score1=$st_manomboka->pt+1;
					$score2=$st_index->pt+1;
					$requete=$bdd->exec("UPDATE equipe set pt='".$score1."' where nom='".$equipe[$manomboka]['nom']."'");
					$requete=$bdd->exec("UPDATE equipe set pt='".$score2."' where nom='".$equipe[$index]['nom']."'");
					$requete=$bdd->exec("INSERT into matches values('".$equipe[$manomboka]['nom']."','".$equipe[$index]['nom']."',".$rand.",".$rand.")");
					echo "'".$equipe[$manomboka]['nom']."' : '".$score1."' : execo ////////////";
					echo "'".$equipe[$index]['nom']."' : '".$score2."' : execo";
					echo "</br>";
				}
				else if($score==2)
				{
					$rand1=rand(1,7);
					$rand2=rand(0,$rand1);
					$score1=$st_manomboka->pt+3;
					$score2=$st_index->pt;
					$requete=$bdd->exec("UPDATE equipe set pt='".$score1."' where nom='".$equipe[$manomboka]['nom']."'");
					$requete=$bdd->exec("UPDATE equipe set pt='".$score2."' where nom='".$equipe[$index]['nom']."'");
					$requete=$bdd->exec("INSERT into matches values('".$equipe[$manomboka]['nom']."','".$equipe[$index]['nom']."',".$rand1.",".$rand2.")");
					echo "'".$equipe[$manomboka]['nom']."' : '".$score1."' : nandresy ///////////";
					echo "'".$equipe[$index]['nom']."' : '".$score2."' : resy";
					echo "</br>";
				}
			}
			$manomboka++;
			$count--;
		}
	}

	function makapoule()
	{
		$bdd=connexion();
			$requete=$bdd->query("SELECT poules FROM Equipe Group by poules");
			$requete->setFetchMode(PDO::FETCH_OBJ);
			$result=array();
	
			while($st=$requete->fetch()) {
					$result[]= $st->poules;
			}
			return $result;    
	}
	
	function affichage($fonction)
	{
		$bdd=connexion();
			$requete=$bdd->query("SELECT * FROM Equipe WHERE poules='$fonction' ORDER BY pt DESC ");
			$requete->setFetchMode(PDO::FETCH_OBJ);
			$result=array(); 
			
			while($st=$requete->fetch())  {
				   $result[]=$st->nom; 
			}
			return $result;
	}

	function resetAll()
	{
		$bdd=connexion();
		$requete=$bdd->exec("delete from matches");
		$requete=$bdd->exec("update equipe set pt=0");
	}
?>