<?php
function checkMoisAnnee($mois , $annee)
{
    if($mois<13 && $mois>=1 && $annee>0 && $annee<=2999)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

?>