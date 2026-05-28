<?php
session_start();

include('data/data.php');

$_SESSION['name']=$_POST['name'];
$name=$_SESSION['name'];

$_SESSION['pass']=$_POST['pass'];
$pass=$_SESSION['pass'];




    if(empty($_SESSION['connected']))
    { 
        for($i=0;$i<count($user);$i++)
        {

            if($user[$i]['name']==$name && $user[$i]['pass']==$pass)
            {
                $is_connected=$user[$i]['name'];
                $_SESSION['connected']=$is_connected;

            

            }

            
        }

    }


    header('location:login.php');



?>