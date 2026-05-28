<?php 
    function counting( $produit , $category )
    {
        $i = count($produit);
        $a = 0;
        for($j = 0 ; $j<$i ; $j++)
        {
            if($produit[$j]['category'] == $category )
            {
                $a++ ;
            }
        }
        return $a;
    }
    function getAll ( $produit , $category )
    {
        $result = array();
        $i = count($produit);
        for($j = 0 ; $j<$i ; $j++)
        {
            if($produit[$j]['service'] == $category )
            {
               $result[]=$j;
            }
        }
        return $result;
    }
?>