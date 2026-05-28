<?php 
    //Count fonction
    function get_product_number($array_data, $product_id){
        $count = 0;
        
        for ($i = 0; $i < count($array_data); $i++){
            if ($array_data[$i]["Category"] == $product_id) $count++;
        }

        return $count;
    }

    function countPP($produit)
    {
        foreach($produit as $ty)
        {
            if($ty['Prix']>20)
            {
                
            }
        }
    }

    //Ajouter au panier
    function ajouter_panier($produits, $produit_id){
        $_SESSION['taille_panier']++;

        array_push($_SESSION['panier'], $produit_id);
    }

    //Prix total
    function prix_total($produits_en_panier, $produits){
        $prix = 0;
        foreach ($produits_en_panier as $product){
            $prix += $produits[$product]["Prix"];
        }

        return $prix;
    }

    //Enlever un elemet
    function enlever_element($element_id){
        $_SESSION['taille_panier']--;
        
        if ($element_id == count($_SESSION['panier'])){
            array_pop($_SESSION['panier']);
        }else{
            $temp = $_SESSION['panier'][$element_id];

            for ($i = $element_id + 1; $i < count($_SESSION['panier']); $i++){
                $_SESSION['panier'][$i - 1] = $_SESSION['panier'][$i];
            }

            $_SESSION['panier'][count($_SESSION['panier']) - 1] = $temp;

            array_pop($_SESSION['panier']);
        }
    }
?>