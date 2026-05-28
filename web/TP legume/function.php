<?php 
    function manisa($tab,$iza)
    {
        $a=0;
        while(isset($tab[$iza][$a]['nom'])==true)
        {
            $a++;
        }
        return $a;
    }

    function anarana($num)
    {
        if($num==0)
        {
            $cat="Vegetables & Fruits";
        }
        elseif($num==1)
        {
            $cat="Beverages";
        }
        elseif($num==2)
        {
            $cat="Dairy Products";
        }
        elseif($num==3)
        {
            $cat="FoodGrains & Oil";
        }
        elseif($num==4)
        {
            $cat="Personal Care";
        }
        elseif($num==5)
        {
            $cat="Pet Care";
        }
        return $cat;
    }

?>