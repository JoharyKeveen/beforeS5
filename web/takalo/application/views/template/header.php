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
    <link href="../assets/css/4/w3.css" rel="stylesheet">
    <link href="../assets/css/gestion.css" rel="stylesheet">
    <title><?php echo $title;?></title>

    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="icon">
                <i class="bi bi-cart-check">Takalo</i>
            </div>
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                            <use xlink:href="#bootstrap" />
                        </svg>
                    </a>
                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="<?php echo base_url('Pages/acceuil'); ?>" class="nav-link px-2 text-white">Accueil</a></li>
                            <li><a href="<?php echo base_url('Traitement/getProfil'); ?>" class="nav-link px-2 text-white">Profil</a></li>
                            <li><a href="<?php echo base_url('Pages/demande'); ?>" class="nav-link px-2 text-white">Demande</a></li>
                            <li><a href="<?php echo base_url('Pages/history'); ?>" class="nav-link px-2 text-white">Historique</a></li>
                            <?php
                                if($this->session->userdata('etat')==1)
                                { ?>
                                    <li><a href="<?php echo base_url('Pages/admin'); ?>" class="nav-link px-2 text-white">Admin</a></li>
                                <?php }
                            ?>
                            <form action="recherche" method="post">
                                <li><input type="text" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search" name="search"></li>
                                <li><div>Categorie</div></li>
                                <li>
                                    <select name="select" style="background-color: rgb(29, 27, 27);color:white;">
                                        <option>Tous</option>
                                        <?php
                                            for($i=0;$i<count($option);$i++)
                                            {
                                                ?>
                                                <option value="<?php echo $option[$i]['id_categorie'];?>"><?php echo $option[$i]['nom'];?></option>
                                                <?php
                                            }
                                        ?>
                                    </select>
                                </li>
                                <li>
                                    <input class="btn btn-warning" type="submit" value="recherche">
                                </li>
                            </form>
                            <li>
                                <button class="btn btn-warning"><a href="../Login/logout" style="text-decoration: none;">Logout</a></button>
                            </li>
                        </ul>
                </div>
        </div>
    </header>
</head>