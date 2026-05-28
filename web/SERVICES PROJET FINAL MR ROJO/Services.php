<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Services </title>

        <link href="fontawesome-5/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="style.css">

        <?php 
            include('data/data.php');
            include('fonction/fonctions.php');
        ?>
    </head>


    <body>

         <!------------Debut Header------------>

        <header>

            <div id = "div_logo">
                <a href = "index.php">
                    <div id = "logo">
                        <div id ="visit">
                            VISIT
                        </div>
                        <div id = "menabe">
                            MENABE
                        </div>
                    </div>
                </a>
            </div>

            <div id = "menuH">
                <?php 
                    for( $i = 0 ; $i < count( $menuH ) ; $i++ )
                    { ?>
                        <div class="element_menuH">
                            <?php 
                                if($i == 0)
                                { ?>
                                    <a href = "index.php">
                                        <i class="<?php echo $menuH[$i]['icon']; ?>"></i>
                                        <?php echo $menuH[$i]['nom'] ; ?>
                                    </a>
                                <?php }else{ ?>
                                    <a href = "<?php echo $menuH[$i]['emplacement'] ; ?>">
                                        <i class="<?php echo $menuH[$i]['icon']; ?>"></i>    <?php echo $menuH[$i]['nom'] ; ?>
                                    </a>
                            <?php } ?>
                        </div>
                <?php } ?>
            </div>

            <div id = "bar_de_recherche-et-login">

                <div id = "bar_de_recherche">
                    <div>
                        <input type = "text" name = "recherche" placeholder = "recherhez ici...">
                    </div>
                    <div id = "loop">
                        <a href = "#">
                            <i class="fas fa-search"></i>
                        </a>
                    </div>
                </div>

                <div id = "login">
                    <a href="#">
                        <i class="fas fa-user" id="login-btn"></i>
                    </a>
                </div>

            </div>

        </header>

        <!------------Fin Header------------>
        <!------------Debut Section------------>
        <section id="services_container">
            <?php 

                if(isset($_GET['section']) == true)
                {
                    $section = $_GET['section'];
                    $serv = getAll($result , $section);
                    for( $i = 0 ; $i<count($serv) ; $i++ )
                    { ?>
                            <div class="services_box">
                                <div  class="name">  
                                    <?php echo $result[ $serv[$i] ]['nom'] ; ?>
                                    <a href="reservation.php?nom=<?php echo $serv[$i] ; ?> ">Reservé</a>
                                </div>
                            </div>
                    <?php }
                }else{
                    for($i = 0 ; $i < count($service) ;$i++)
                        { ?>
                            <a href="Services.php?section=<?php echo $i; ?>">
                                    <div class="default_services_box">
                                        <div class="default_icon">
                                            <i class="<?php echo $service[$i]['icon'] ; ?>">  </i>
                                        </div>
                                        <div class="default_name">
                                            
                                                <?php echo $service[$i]['nom'] ; ?>
                                            
                                        </div>
                                        <div class="default_info">
                                            <?php 
                                                echo $service[$i]['description'];
                                            ?>
                                        </div>
                                    </div>
                            </a>
                        <?php } 
                    } ?>
        </section>
        <!------------Fin Section------------>
        <!------------Debut Footer------------>
        <footer>
            <div id = "div_footer_pI">
                <p id = "footer_p1">
                    About Us
                </p>
                <p id = "footer_p2">
                    Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odio iusto laboriosam, officiis sint delectus optio at neque odit minus et! Id exercitationem, consequuntur illum soluta optio aut. Quod, deleniti enim.
                </p>
            </div>
            <div id = "div_footer_pII">
                <p id = "footer_p3">
                    Quick Links
                </p>
                <p id = "footer_p4">
                    <?php 
                        for( $i = 0 ; $i < count( $menuH ) ; $i++ )
                        { ?>
                            <div class="element_menuH">
                                <?php 
                                    if($i == 0)
                                    { ?>
                                        <a href = "index.php"> <?php echo $menuH[$i]['nom'] ; ?> </a>
                                    <?php }else{ ?>
                                        <a href = "<?php echo $menuH[$i]['emplacement'] ; ?>"> <?php echo $menuH[$i]['nom'] ; ?> </a>
                                <?php } ?>
                            </div>
                    <?php } ?>
                </p>
            </div>
            <div id = "div_footer_pIII">
                <p id = "footer_p5">
                    Follow Us
                </p>
                <p id = "footer_p6">

                </p>
            </div>
        </footer>
        <!------------Fin Footer------------>
    </body>
</html>