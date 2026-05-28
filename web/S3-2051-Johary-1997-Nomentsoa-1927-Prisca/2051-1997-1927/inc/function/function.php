<?php
        require_once('connection.php');
        function liste_trano()
        {
                $bdd=connect_bdd();
                $requete=$bdd->query("select*from trano inner join typ on typ.id_type=trano.id_type order by id_trano");
                $requete->setFetchMode(PDO::FETCH_OBJ);
                $result=array();

                while($st=$requete->fetch())
                {
                        $result[]= $st->id_trano;
                        $result[]= $st->id_type;
                        $result[]= $st->nb_chambre;
                        $result[]= $st->loyer;
                        $result[]= $st->quartier;
                        $result[]= $st->descriptions;
                        $result[]= $st->nom;
                }
                return $result;    
        }
        function rechercheVola($minimum,$maximum)
        {
                $bdd=connect_bdd();
                if($maximum>$minimum)
                {
                        $requete=$bdd->query("select*from trano inner join typ on typ.id_type=trano.id_type where loyer>=".$minimum." and loyer<=".$maximum." order by id_trano");
                }
                else
                {
                        $requete=$bdd->query("select*from trano inner join typ on typ.id_type=trano.id_type where loyer>=".$minimum." order by id_trano");
                }
                $requete->setFetchMode(PDO::FETCH_OBJ);
                $result=array();

                while($st=$requete->fetch())
                {
                        $result[]= $st->id_trano;
                        $result[]= $st->id_type;
                        $result[]= $st->nb_chambre;
                        $result[]= $st->loyer;
                        $result[]= $st->quartier;
                        $result[]= $st->descriptions;
                        $result[]= $st->nom;
                }
                return $result;  
        }
        function recherche($search)
        {
                $liste=liste_trano();
                $result=array();

                for($i=0;$i<count($liste);$i+=7)
                {
                        $descriptions=$liste[$i+5];
                        if(strpos(strtolower($descriptions),strtolower($search))!==false)
                        {
                                $result[]=$liste[$i];
                        }
                }
                return $result;
        }
        function get_photo($id)
        {
                $bdd=connect_bdd();
                $requete=$bdd->query("select sary from photo where id_trano='".$id."'");
                $requete->setFetchMode(PDO::FETCH_OBJ);
                $result=array();

                while($st=$requete->fetch())
                {
                        $result[]= $st->sary;
                }
                return $result;   
        }
        function get_the_trano($id)
        {
                $bdd=connect_bdd();
                $requete=$bdd->query("select*from trano inner join typ on typ.id_type=trano.id_type where id_trano='".$id."'");
                $requete->setFetchMode(PDO::FETCH_OBJ);
                $result=array();

                while($st=$requete->fetch())
                {
                        $result[]= $st->id_trano;
                        $result[]= $st->id_type;
                        $result[]= $st->nb_chambre;
                        $result[]= $st->loyer;
                        $result[]= $st->quartier;
                        $result[]= $st->descriptions;
                        $result[]= $st->nom;
                }
                return $result; 
        }
        function get_type()
        {
                $bdd=connect_bdd();
                $requete=$bdd->query("select*from typ");
                $requete->setFetchMode(PDO::FETCH_OBJ);
                $result=array();

                while($st=$requete->fetch())
                {
                        $result[]= $st->id_type;
                        $result[]= $st->nom;
                }
                return $result; 
        }
        function inscription($email,$nom,$mdp,$numero)
        {
                $bdd=connect_bdd();
                $bdd->exec("insert into membres(email,nom,mdp,numero,etat) VALUES ('".$email."','".$nom."','".$mdp."','".$numero."',0)");
            
        }
        function modifier_trano($id_trano,$loyer,$descriptions)
        {
                $bdd=connect_bdd();
                $bdd->exec("UPDATE trano set loyer=".$loyer.",descriptions='".$descriptions."' where id_trano='".$id_trano."'");
        }
        function delete_trano($id)
        {
                $bdd=connect_bdd();
                $bdd->exec("delete from photo where id_trano=".$id."");
                $bdd->exec("delete from trano where id_trano=".$id."");   
        }
        function add_trano($type,$chambre,$loyer,$quartier,$descri)
        {
                $bdd=connect_bdd();
                $requete="insert into trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (".$type.",".$chambre.",".$loyer.",'".$quartier."','".$descri."')";
                echo $requete;
                $bdd->exec($requete);
        }
        function check_login($email,$mdp)
        {
                $bdd=connect_bdd();
                $requete=$bdd->query("SELECT * FROM membres where email='".$email."' and mdp='".$mdp."'");
                $requete->setFetchMode(PDO::FETCH_OBJ);

                while($st=$requete->fetch())
                {
                        $_SESSION['id']=$st->idmembre;
                        $_SESSION['etat']=$st->etat;
                        return true;
                }
                return false;
        }
        function reserver($idMembre,$id_trano,$arriver,$depart)
        {
                $bdd=connect_bdd();
                $requete="insert into reservation(idmembre,id_trano,date_arrive,date_depart) VALUES (".$idMembre.",".$id_trano.",'".$arriver."','".$depart."')";
                echo $requete;
                $bdd->exec($requete);
        }
        function deconnection()
        {
                session_start();
                session_destroy();
                header('location:../../index.php');
        }
        function get_reservation($id_trano)
        {
                $bdd=connect_bdd();
                $requete=$bdd->query("select*from reservation where id_trano='".$id_trano."'");
                $requete->setFetchMode(PDO::FETCH_OBJ);
                $result=array();

                while($st=$requete->fetch())
                {
                        $result[]= $st->id_reserv;
                        $result[]= $st->idmembre;
                        $result[]= $st->id_trano;
                        $result[]= $st->date_arrive;
                        $result[]= $st->date_depart;
                }
                return $result; 
        }
        function get_between($arriver,$depart)
        {
                $result=array();
                $start=$arriver;
                $i=1;
                date_default_timezone_set('GMT');
                if(strtotime($arriver)<strtotime($depart))
                {
                        while(strtotime($start)<strtotime($depart))
                        {
                                $start=date('Y-m-d',strtotime($arriver."+".$i.' days '));
                                $result[]=$start;
                                $i++;
                        }
                }
                return $result;
        }
        function is_between($date1,$date2,$id_trano)
        {
                $all_reservation=get_reservation($id_trano);
                for($i=0;$i<count($all_reservation);$i+=5)
                {
                        $tomorrow=get_between($all_reservation[$i+3],$all_reservation[$i+4]);
                        for($j=0;$j<count($tomorrow);$j++)
                        {
                                $pretendre=get_between($date1,$date2);
                                for($k=0;$k<count($pretendre);$k++)
                                {
                                        if($tomorrow[$j]==$pretendre[$k])
                                        {
                                                return true;
                                        }
                                }
                        }
                }
                return false;
        }
function jourdansmois($mois, $an)
{
        date_default_timezone_set('UTC');
        $enmois = $an * 12 + $mois;
        if (($enmois > 2037 * 12 - 1) || ($enmois < 1970)) {
                return 0;
        }
        $an_suivant = floor(($enmois + 1) / 12);
        $mois_suivant = $enmois + 1 - 12 * $an_suivant;
        $duree = mktime(0, 0, 1, $mois_suivant, 1, $an_suivant) - mktime(
                0,
                0,
                1,
                $mois,
                1,
                $an
        );
        return ($duree / (3600 * 24));
}
function data($mois)
{

        $bdd = connect_bdd();
        $requete = $bdd->query("select to_char(date_arrive,'DD') as daty from reservation where to_char(date_arrive,'YYYY-MM')='" . $mois . "'");
        $requete->setFetchMode(PDO::FETCH_OBJ);
        $result = array();

        while ($st = $requete->fetch()) {
                $result[] = $st->daty;
                
        }
        return $result;
}
?>

