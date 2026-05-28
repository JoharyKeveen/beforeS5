<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Home </title>

        <link href="fontawesome-5/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="style.css">

        <?php 
            include('data.php');
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
                                    <a href = "index.php"> <?php echo $menuH[$i] ; ?> </a>
                                <?php }else{ ?>
                                    <a href = "<?php echo $menuH[$i] ; ?>.php"> <?php echo $menuH[$i] ; ?> </a>
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
        <section id = "home_content">

            <nav id = "nav_content">

                <div id = "sites">
                    Lieux
                </div>

                <div id = "aside_sites" >
                    <?php 
                            for( $i = 0 ; $i < count( $menuV ) ; $i++ )
                            { ?>
                                <div class = "element_menuV">
                                    <?php ?>
                                        <a href="#"> <?php echo $menuV[$i] ; ?> </a>
                                </div>
                        <?php } ?>
                </div>

            </nav>

            <article id = "article_home">
                <?php
                    for( $j = 0 ; $j < count($site)  ; $j++ )
                    { ?>
                        <div class = "content_home">
                            <div class = "image">
                                1
                            </div>
                        </div>
                    <?php }
                ?>
            </article>

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
                            <div class="element_menuv">
                                <?php 
                                    if($i == 0)
                                    { ?>
                                        <a href = "index.php"> <?php echo $menuH[$i] ; ?> </a>
                                    <?php }else{ ?>
                                        <a href = "<?php echo $menuH[$i] ; ?>.php"> <?php echo $menuH[$i] ; ?> </a>
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