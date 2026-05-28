<?php
    include('../function/function.php');
    include('../function/connection');
    modifier_trano($_POST['id'],$_POST['loyer'],$_POST['desc']);
    header('location:../../pages/admin.php');
?>