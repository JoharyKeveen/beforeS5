<?php

function makapoule()
{
        include ('Connex.php');
        
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
        include ('Connex.php');
        
        $requete=$bdd->query("SELECT * FROM Equipe WHERE poules='$fonction' ORDER BY pt DESC ");
        $requete->setFetchMode(PDO::FETCH_OBJ);
        $result=array(); 
        
        while($st=$requete->fetch())  {
               $result[]=$st->nom; 
        }
        return $result;
}
?>

