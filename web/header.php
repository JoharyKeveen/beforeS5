<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="<?php echo $description;?>">
    <meta name="keywords" content="<?php echo $keywords;?>">
    <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/fonts/fontawesome-5/css/all.css" rel="stylesheet">
    <link href="../assets/fonts/fontawesome-5/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/footer.css">
    <title><?php echo $title;?></title>

    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="icon">
                <i class="bi bi-cart-check">Takalo</i>
            </div>
            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" action="result.php" method="post">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                            <use xlink:href="#bootstrap" />
                        </svg>
                    </a>
                    
                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="<?php echo base_url('Pages/acceuil'); ?>" class="nav-link px-2 text-white">Accueil</a></li>
                            <li><a href="#" class="nav-link px-2 text-white">Profil</a></li>
                            <li><a href="<?php echo base_url('Pages/demande'); ?>" class="nav-link px-2 text-white">Demande</a></li>
                            <li><a href="#" class="nav-link px-2 text-white">Admin</a></li>
                            <li><input type="text" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search" name="search"></li>
                        </ul>
                </div>
                <div id="akisaka">
                    Categorie
                    <select name="select" >
                        <option>Tous</option>
                        <option>abc</option>
                    </select>
                    <input class="btn btn-warning" type="submit" value="recherche">
                </div>
            </form>
            <div class="text-end">
                <button class="btn btn-warning"><a href="../Login/logout" style="text-decoration: none;">Logout</a></button>
            </div>
        </div>
    </header>
</head>