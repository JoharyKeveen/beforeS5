<?php
$continent[]="Asie"; //indice 0
$continent[]="Afrique"; //indice 1
$continent[]="Europe"; //indice 2


$pays[0]['nom']="Afghanistan";
$pays[0]['population']=155000;
$pays[0]['capitale']='Kaboul';
$pays[0]['continent']=0;



$pays[1]['nom']="Afrique du Sud";
$pays[1]['population']=120000;
$pays[1]['capitale']='Pretoria';
$pays[1]['continent']=1;

//équivalent à
$pays[2] = array(
    'nom'=>'Albanie', 
    'population'=>70000, 
    'capitale'=>'Tirana',
    'continent'=>2
);

$pays[] = array(
    'nom'=>'Autriche', 
    'population'=>85000, 
    'capitale'=>'Vienne',
    'continent'=>2
);

$pays[] = array(
    'nom'=>'Chine', 
    'population'=>800000, 
    'capitale'=>'Pekin',
    'continent'=>0
);





?>