<?php
    //Enlever un elemet
    function enlever_element($element_id){
        $_SESSION['count']--;
        
        if ($element_id == count($_SESSION['res'])){
            array_pop($_SESSION['res']);
        }else{
            $temp = $_SESSION['res'][$element_id];

            for ($i = $element_id + 1; $i < count($_SESSION['res']); $i++){
                $_SESSION['res'][$i - 1] = $_SESSION['res'][$i];
            }

            $_SESSION['res'][count($_SESSION['res']) - 1] = $temp;

            array_pop($_SESSION['res']);
        }
    }
?>