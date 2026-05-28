<?php
    function mitady($mot_a_trouver,$tab,$date1,$date2)
    {
        $res=array();
        $ret=array();
        $v=0;
        $error="Error";
        $M=strtolower($mot_a_trouver);
        if(isset($mot_a_trouver)==false || $mot_a_trouver=="")
        {
            return $error;
        }
        for($a=0; $a<count($tab); $a++)
        {
            $res[$a]['nom']=strtolower($tab[$a]['nom']);
        }
        for($i=0; $i<count($res); $i++)
        {
            $position=strpos($res[$i]['nom'],$M);
            if($position=== false)
            {
                
            }
            else
            {
                if($tab[$i]['date']>=$date1&&$tab[$i]['date']<=$date2) 
                {
                    $ret[$v]=$i;
                    $v++;
                }
            }
        }
        return $ret;
    }
?>