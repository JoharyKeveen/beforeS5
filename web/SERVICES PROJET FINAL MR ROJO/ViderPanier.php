<?php 
    session_start();

    //include
    include("function.php");

    if (isset($_GET['num'])){
        enlever_element($_GET['num']);
    }else{
        $_SESSION['res'] = (array) null;
        $_SESSION['count'] = 0;
    }
    
    header("Location:nos_reservation.php");
?>