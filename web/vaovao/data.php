<?php

function calculAge($date_de_naissance){
	date_default_timezone_set("Africa/Nairobi");
    $annee_naissance=date("Y",strtotime($date_de_naissance));
    $annee_encours = date('Y'); //fonction php
    $age = $annee_encours - $annee_naissance;
    return $age; 
}



$prom[]="S1";
$prom[]="S3";
$prom[]="S5";

$photo[]="za";
$photo[]="harena";
$photo[]="zoky";
$photo[]="nata";
$photo[]="boritra";
$photo[]="tsong";
$photo[]="biby";
$photo[]="foke";
$photo[]="nom";
$photo[]="jo";


$etudiant[0]['nom']="RASOLOARISON";
$etudiant[0]['prenom']="Tahiry Johary";
$etudiant[0]['date_de_naissance']="2004-02-01";
$etudiant[0]['ville']="Antananarivo";
$etudiant[0]['prom']=1;
$etudiant[0]['photo']=0;

$etudiant[2]['nom']="RASOLOARISON";
$etudiant[2]['prenom']="H.H. Lalaina";
$etudiant[2]['date_de_naissance']="1973-09-20";
$etudiant[2]['ville']="Antananarivo";
$etudiant[2]['prom']=2;
$etudiant[2]['photo']=2;

$etudiant[1]['nom']="ANDRIAVELONJANAHARY";
$etudiant[1]['prenom']="Tahiry Rojoniaina";
$etudiant[1]['date_de_naissance']="1970-04-17";
$etudiant[1]['ville']="Antananarivo";
$etudiant[1]['prom']=1;
$etudiant[1]['photo']=1;

$etudiant[3]['nom']="RAKOTONDRAIBE";
$etudiant[3]['prenom']="Itokiana";
$etudiant[3]['date_de_naissance']="2003-07-16";
$etudiant[3]['ville']="Antananarivo";
$etudiant[3]['prom']=0;
$etudiant[3]['photo']=3;

$etudiant[4]['nom']="RAZAFINAVALONA";
$etudiant[4]['prenom']="Nathanael";
$etudiant[4]['date_de_naissance']="2005-08-16";
$etudiant[4]['ville']="Antananarivo";
$etudiant[4]['prom']=0;
$etudiant[4]['photo']=4;

$etudiant[5]['nom']="RAVELOJAONA";
$etudiant[5]['prenom']="Toky Niaina Chen";
$etudiant[5]['date_de_naissance']="2003-06-29";
$etudiant[5]['ville']="Antananarivo";
$etudiant[5]['prom']=1;
$etudiant[5]['photo']=5;

$etudiant[6]['nom']="RAMBALA";
$etudiant[6]['prenom']="Narison Marc Michael";
$etudiant[6]['date_de_naissance']="2004-08-29";
$etudiant[6]['ville']="Antananarivo";
$etudiant[6]['prom']=2;
$etudiant[6]['photo']=6;

$etudiant[7]['nom']="RANDRIAMBELOSON";
$etudiant[7]['prenom']="Safidy";
$etudiant[7]['date_de_naissance']="2003-12-26";
$etudiant[7]['ville']="Antananarivo";
$etudiant[7]['prom']=2;
$etudiant[7]['photo']=7;

$etudiant[8]['nom']="RAZANATSONGA";
$etudiant[8]['prenom']="Charles";
$etudiant[8]['date_de_naissance']="2000-12-26";
$etudiant[8]['ville']="Antananarivo";
$etudiant[8]['prom']=1;
$etudiant[8]['photo']=8;

$etudiant[9]['nom']="ANDRIAMATOA";
$etudiant[9]['prenom']="Jean";
$etudiant[9]['date_de_naissance']="1978-09-17";
$etudiant[9]['ville']="Antananarivo";
$etudiant[9]['prom']=0;
$etudiant[9]['photo']=9;
?>