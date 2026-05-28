<?php
    include('../function/function.php');
    include('../function/connection');
    delete_trano($_GET['delete']);
    header('location:../../pages/admin.php');
?>