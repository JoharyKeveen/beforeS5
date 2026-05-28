<?php
    session_start();
    include('PDO.php');
    function get_produit()
    {
        $bdd=pdo_mysql();
        $requete=$bdd->query("SELECT*FROM produit where disponible='oui' order by id");
        $requete->setFetchMode(PDO::FETCH_OBJ);
        $produit=array();
        $i=0;
        while($st=$requete->fetch())
        {
            $produit[$i]['id']=$st->id;
            $produit[$i]['nom']=$st->nom;
            $produit[$i]['prix']=$st->prix;
            $i++;
        }      
        return $produit;
    }
    function get_one_produit($id)
    {
        $bdd=pdo_mysql();
        $requete=$bdd->query("SELECT*FROM produit where id=".$id." order by id");
        $requete->setFetchMode(PDO::FETCH_OBJ);
        $produit=array();
        $i=0;
        while($st=$requete->fetch())
        {
            $produit[$i]['id']=$st->id;
            $produit[$i]['nom']=$st->nom;
            $produit[$i]['marque']=$st->marque;
            $produit[$i]['disponible']=$st->disponible;
            $produit[$i]['prix']=$st->prix;
            $i++;
        }      
        return $produit;
    }
    function get_marque()
    {
        $bdd=pdo_mysql();
        $requete=$bdd->query("SELECT*FROM marque");
        $requete->setFetchMode(PDO::FETCH_OBJ);
        $marque=array();
        $i=0;
        while($st=$requete->fetch())
        {
            $marque[$i]=$st->nom;
            $i++;
        }      
        return $marque;
    }
    function est_vide($nom,$prix)
    {
        $result=false;
        if($nom==''||$nom==' '||$nom=='  ')
        {
            $result=true;
        }
        else if($prix==0||$prix==''||$prix==' ')
        {
            $result=true;
        }
        return $result;
    }
    function get_prod_panier($id_prod)
    {
        $bdd=pdo_mysql();
        $requete=$bdd->query("SELECT*FROM produit where id=".$id_prod."");
        $requete->setFetchMode(PDO::FETCH_OBJ);
        $produit=array();
        $i=0;
        while($st=$requete->fetch())
        {
            $produit[$i]['id']=$st->id;
            $produit[$i]['nom']=$st->nom;
            $produit[$i]['prix']=$st->prix;
            $i++;
        }      
        return $produit;
    }
    function total_montant()
    {
        $total=0;
        for($i=0;$i<count($_SESSION['panier']);$i++)
        {
            $prod=get_prod_panier($_SESSION['panier'][$i]);
            $total+=$prod[0]['prix'];
        }
        return $total;
    }
    function vider_panier()
    {
        $_SESSION['panier']=array();
    }
    function ajout_prod($nom,$marque,$dispo,$prix)
    {
        $bdd=pdo_mysql();
        $bdd->exec("insert into produit values(null,'".$nom."','".$marque."','".$dispo."',".$prix.")");
    }
    function modif_prod($id,$nom,$marque,$dispo,$prix)
    {
        $bdd=pdo_mysql();
        $bdd->exec("update produit set nom='".$nom."', marque='".$marque."',disponible='".$dispo."',prix=".$prix." where id=".$id."");
    }
?>