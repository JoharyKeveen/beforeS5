<?php
    function connex_bdd()
    {
        $connect = mysqli_connect('localhost', 'root', 'root', 'Ajax9');
        mysqli_set_charset($connect,"uft8");
        return $connect;
    }
?>