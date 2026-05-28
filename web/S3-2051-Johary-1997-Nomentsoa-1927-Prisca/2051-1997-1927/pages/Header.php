<?php
    session_start();
    if(!isset($_SESSION['id']))
    {
        header('location:../index.php');
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../assets/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style2.css">
    <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Header</title>
</head>
<body>


<header class="p-3 text-bg-dark">
<div class="container">
    <div class="icon">
        <i class="bi bi-house">Find it</i>
    </div>
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                <use xlink:href="#bootstrap" />
            </svg>
        </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="acceuil.php" class="nav-link px-2 text-white">Accueil</a></li>
                <li><a href="superSearch.php" class="nav-link px-2 text-white">Search multi</a></li>
                <?php
                    if($_SESSION['etat']==1)
                    {?>
                        <li><a href="stat.php" class="nav-link px-2 text-white">Statistique</a></li>
                        <li><a href="admin.php" class="nav-link px-2 text-white">Admin</a></li>
                        <li><a href="tranoDispo.php" class="nav-link px-2 text-white">Trano dispo</a></li>
                    <?php }
                ?>
            </ul>
        

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" action="result.php" method="post">
            <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..."
                aria-label="Search" name="search">
        </form>

        <div class="text-end">
            <button type="button" class="btn btn-warning"><a href="../inc/traitement/deconnection.php" style="text-decoration: none;">Logout</a></button>
        </div>
    </div>
</div>
</header>
</body>
</html>