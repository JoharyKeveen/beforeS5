<?php

function calculAge($annee_naissance){
	date_default_timezone_set("Africa/Nairobi");
    $annee_encours = date('Y'); //fonction php
    $age = $annee_encours - $annee_naissance;
    return $age; 
}

?>