<?php
    if(isset($_GET['num'])==true)
    {
        $num=$_GET['num'];
    }
    else{
        $num=0;
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gallery</title>
</head>
<body>
    <?php
        include('header.php');
    ?>
    <div id="gallery_body2">
        <div id="gallery_menu2">
            <h3>Images de:</h3>
            <?php
                for($a=0; $a<count($menuV); $a++)
                { ?>
                <div>
                    <a href="gallery.php?num=<?php echo $a; ?>"><?php echo $menuV[$a]; ?></a>
                </div>
                <?php }
            ?>
        </div>
        <div id="gallery_content2">
            <?php
                for($b=0; $b<count($paysage); $b++)
                {
                    if($paysage[$b]['lieu']==$menuV[$num])
                    { ?>
                        <div class="IMG_gallery">
                            <a href="bigsize.php?i_picture=<?php echo $b; ?>"><img src="<?php echo $paysage[$b]['image']; ?>"></a>
                        </div>
                    <?php }
                }
            ?>
        </div>
    </div>
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
</body>
</html>