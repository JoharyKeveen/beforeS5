<?php
    function connex_bdd()
    {
        $connect = mysqli_connect('localhost', 'root', 'root', 'OneDay');
        mysqli_set_charset($connect,"uft8");
        return $connect;
    }
?>