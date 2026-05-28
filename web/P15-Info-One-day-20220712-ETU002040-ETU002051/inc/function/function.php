<?php
    require_once('connexion.php');

	// Verifie si la personne peut se connecter
	function check_login($name,$mdp)
	{
		$bdd=connex_bdd();
		$sentence="select * from Utilisateur where email='%s' and motDePasse='%s'";
		$sql=sprintf($sentence,$name,$mdp);
        $yop=mysqli_query($bdd,$sql);
        while($data=mysqli_fetch_assoc($yop)){
           	return $data['idUtilisateur'];
        }
        return 0;
    }

	    // Créer un nouveau compte
    function new_account($bdd,$name,$password){
        $result=mysqli_query($bdd,"insert into Utilisateur values(null,'".$name."','".$password."',0)");
        return true;
    }

    	// Afficher CV
    function get_cv()
    {
		$bdd=connex_bdd();
		$sql="select * from Cv join Utilisateur on Cv.idUtilisateur=Utilisateur.idUtilisateur order by nom asc";
		$request=mysqli_query($bdd,$sql);
		$result=array();
		while($data=mysqli_fetch_assoc($request)){
			$result[]=$data['idCV'];
			$result[]=$data['idUtilisateur'];
			$result[]=$data['nom'];
			$result[]=$data['prenom'];
			$result[]=$data['dateNaissance'];
			$result[]=$data['photo'];
		}
		return $result;
	}

		// Verifie si le cv est mienne ou admin
	function is_mine($me,$cv){
		if ($cv==$me) {
			return true;
		}
		return false;
	}

	function get_user($id){
		$bdd=connex_bdd();
		$sql="select * from Cv where idUtilisateur='".$id."'";
		$request=mysqli_query($bdd,$sql);
		while($data=mysqli_fetch_assoc($request)){
			echo $data['nom'],"_",$data['prenom'];
			break;
		}
	}

		// Prendre les descriptions
	function get_descri()
	{
		$bdd=connex_bdd();
		$sql="select * from Parametre";
		$request=mysqli_query($bdd,$sql);
		$result=array();
		while($data=mysqli_fetch_assoc($request))
		{
			$result[]=$data['descriptions'];
		}
		return $result;
	}
		// Prendre les choix
	function get_choice($descri)
	{
		$bdd=connex_bdd();
		$sql="select * from Parametre where descriptions='".$descri."'";
		$request=mysqli_query($bdd,$sql);
		$result=array();
		while($data=mysqli_fetch_assoc($request))
		{
			$result[]=explode(',',$data['choix']);
		}
		return $result[0];
	}
			// Prendre les valeurs
	function get_value($value)
	{
		$bdd=connex_bdd();
		$sql="select * from Parametre where valeur='".$value."'";
		$request=mysqli_query($bdd,$sql);
		$result=array();
		while($data=mysqli_fetch_assoc($request))
		{
			$result[]=explode(',',$data['valeur']);
		}
		return $result[0];
	}

	function get_cv_size(){
		$bdd=connex_bdd();
		$sql="select count(*) from Cv";
		$request=mysqli_query($bdd,$sql);
		while($data=mysqli_fetch_assoc($request)){
			echo $data['count(*)'];
		}
	}

	function get_size_type($type){
		$bdd=connex_bdd();
		$sql="select count(*) from Cv join detailCv on Cv.idCV=detailCv.idCV where codeParametre='P2' and unDesChoix='".$type."'";
		$request=mysqli_query($bdd,$sql);
		while($data=mysqli_fetch_assoc($request)){
			echo $data['count(*)'];
		}
	}

	function get_filter($ne,$fil,$sport){
		$bdd=connex_bdd();
		if ($ne!="any") {
			$sql="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where unDesChoix='".$ne."' and codeParametre='P1'";  
		}
		else $sql="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where codeParametre='P1'";  
		if ($fil!="any") {
			$sqll="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where unDesChoix='".$fil."' and codeParametre='P2'";
		}
		else $sqll="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where codeParametre='P2'";  
		if ($sport!="any") {
			$sqlll="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where unDesChoix='".$sport."' and codeParametre='P3'";
		}
		else $sqlll="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where codeParametre='P3'";  
		$request=mysqli_query($bdd,$sql);
		$requestt=mysqli_query($bdd,$sqll);
		$requesttt=mysqli_query($bdd,$sqlll);
		$result=array();
		while($data=mysqli_fetch_assoc($request)){
			while($dataa=mysqli_fetch_assoc($requestt)){
				while($dataaa=mysqli_fetch_assoc($requesttt)){
					if ($data['idCV']==$dataa['idCV']&&$data['idCV']==$dataaa['idCV']) {
						$result[]=$data['idCV'];
						$result[]=$data['idUtilisateur'];
						$result[]=$data['nom'];
						$result[]=$data['prenom'];
						$result[]=$data['dateNaissance'];
						$result[]=$data['photo'];
					}
				}
			}
		}
		return $result;
	}

	function size_sport($type,$how){
		$bdd=connex_bdd();
		$result=0;
		if ($how=="oui") {
			$sql="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where unDesChoix='Oui' and codeParametre='P3'";  
		}
		else{
			$sql="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where unDesChoix='Non' and codeParametre='P3'";  
		}
		$sqll="select * from Cv join detailCv on Cv.idCV=detailCv.idCV where unDesChoix='".$type."' and codeParametre='P2'";
		$request=mysqli_query($bdd,$sql);
		$requestt=mysqli_query($bdd,$sqll);
		while($data=mysqli_fetch_assoc($request)){
			while($dataa=mysqli_fetch_assoc($requestt)){
				if ($data['idCV']==$dataa['idCV']) {
					$result++;
				}
			}
		}
		return $result;
	}

	function is_admin($id){
		$bdd=connex_bdd();
		$sql="select * from Utilisateur where idUtilisateur='".$id."' and estAdmin=1";
		$request=mysqli_query($bdd,$sql);
		while($data=mysqli_fetch_assoc($request)){
			return true;
		}	
		return false;
	}		
	// Mettre les données du nouveau CV dans la base
	function new_cv($id,$nom,$prenom,$date,$photo,$choice)
	{
		$bdd=connex_bdd();
        mysqli_query($bdd,"insert into Cv values(null,'".$id."','".$nom."','".$prenom."','".$date."','".$photo."')");
		mysqli_query($bdd,"insert into DetailCv values(null,(select idCv from Cv where idUtilisateur='".$id."' and nom='".$nom."' and prenom='".$prenom."' and dateNaissance='".$date."'),'P1','".$choice[1]."')");
		mysqli_query($bdd,"insert into DetailCv values(null,(select idCv from Cv where idUtilisateur='".$id."' and nom='".$nom."' and prenom='".$prenom."' and dateNaissance='".$date."'),'P2','".$choice[2]."')");
		mysqli_query($bdd,"insert into DetailCv values(null,(select idCv from Cv where idUtilisateur='".$id."' and nom='".$nom."' and prenom='".$prenom."' and dateNaissance='".$date."'),'P3','".$choice[3]."')");
	}
		// Upload photos
    function upload()
    {
        if(isset($_FILES['avatar']))
        {
            $taille_maxi = 2000000;
            $taille = filesize($_FILES['avatar']['tmp_name']);
            $dossier = '../../assets/img/';
            $fichier = basename($_FILES['avatar']['name']);
            $extensions = array('.png', '.gif', '.jpg', '.jpeg','.PNG', '.GIF', '.JPG', '.JPEG');
            $extension = strrchr($_FILES['avatar']['name'], '.');
            if(!in_array($extension, $extensions))
            {
                $erreur = "Vous devez uploader un fichier de type png, gif, jpg, jpeg, txt ou doc";
            }
            if($taille>$taille_maxi)
            {
                $erreur = 'Le fichier est trop gros...';
            }
            if(!isset($erreur))
            {
                $fichier = strtr($fichier,'ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïðòóôõöùúûüýÿ','AAAAAACEEEEIIIIOOOOOUUUUYaaaaaaceeeeiiiioooooouuuuy');
                $fichier = preg_replace('/([^.a-z0-9]+)/i', '-', $fichier);
                move_uploaded_file($_FILES['avatar']['tmp_name'], $dossier . $fichier);
            }
            else
            {
                echo $erreur;
            }
        }
    }
		// Prendre le nom de l'image concerné
    function fichier()
    {
        if(isset($_FILES['avatar']))
        {
            $fichier = basename($_FILES['avatar']['name']);
            $fichier = strtr($fichier,'ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïðòóôõöùúûüýÿ','AAAAAACEEEEIIIIOOOOOUUUUYaaaaaaceeeeiiiioooooouuuuy');
            $fichier = preg_replace('/([^.a-z0-9]+)/i', '-', $fichier);
            return $fichier;
        }   
    }
		// Prendre les infos a visionné
	function view($id)
	{
		$bdd=connex_bdd();
		$result=array();
		$sentence="select*from Cv where idCv='".$id."'";
		$request=mysqli_query($bdd,$sentence);
		while($data=mysqli_fetch_assoc($request))
		{
			$result[]=$data['nom'];
			$result[]=$data['prenom'];
			$result[]=$data['dateNaissance'];
			$result[]=$data['photo'];
		}
		$sentencee="select*from DetailCv where idCv='".$id."'";
		$requestt=mysqli_query($bdd,$sentencee);
		while($dataq=mysqli_fetch_assoc($requestt))
		{
			$result[]=$dataq['unDesChoix'];
		}
		return $result;
	}
		// Modifier une photos
	function update_pic($nom,$prenom,$date,$file_name,$id,$choice)
	{
		$bdd=connex_bdd();
		$sentence="UPDATE Cv SET nom='$nom',prenom='$prenom',dateNaissance='$date',photo='$file_name' WHERE idCv=$id";
		$request=mysqli_query($bdd,$sentence);
		for($i=1;$i<4;$i++)
		{
			if($i==1)
			{
				$p='P1';
			}
			else if($i==2)
			{
				$p='P2';
			}
			else
			{
				$p='P3';
			}
			$sentence="UPDATE DetailCv SET unDesChoix='$choice[$i]' WHERE idCV=$id and codeParametre='$p'";
			$request=mysqli_query($bdd,$sentence);
		}
	}
		// Prendre les infos parametres
	function para()
	{
		$bdd=connex_bdd();
		$result=array();
		$sentence="select*from parametre";
		$request=mysqli_query($bdd,$sentence);
		while($data=mysqli_fetch_assoc($request))
		{
			$result[]=$data['descriptions'];
			$result[]=$data['valeur'];
			$result[]=$data['coefficient'];
		}
		return $result;
	}
		//Modifier
	function edit_para($v1,$c1,$v2,$c2,$v3,$c3)
	{
		$bdd=connex_bdd();
		$sentence="UPDATE Parametre SET valeur='$v1',coefficient='$c1' WHERE codeParametre='P1'";
		$request=mysqli_query($bdd,$sentence);
		$sentence="UPDATE Parametre SET valeur='$v2',coefficient='$c2' WHERE codeParametre='P2'";
		$request=mysqli_query($bdd,$sentence);
		$sentence="UPDATE Parametre SET valeur='$v3',coefficient='$c3' WHERE codeParametre='P3'";
		$request=mysqli_query($bdd,$sentence);
	}
?>