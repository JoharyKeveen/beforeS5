<?php
include('data.php');

$i_picture=$_GET['i_picture'];

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./style/style_bigsize.css">
    <link rel="stylesheet" href="fontawesome-5/css/all.css">

    
</head>
<body>
    <?php
        include('header.php');
    ?>
    <div class="big">
          
        <div id="left">
            <?php 
                if(strcmp($paysage[$i_picture]['lieu'],$paysage[$i_picture-1]['lieu'])==0) { ?>
                <a class="previous" href="bigsize.php?i_picture=<?php echo $a=$i_picture-1 ;?>">  <i class="fas fa-angle-left "></i>  </a>
                <?php }
                else
                { ?>
                <i class="fas fa-angle-left "></i>
            <?php } ?>
        </div>

            <div class="image2">

                <img src="<?php echo $paysage[$i_picture]['image']; ?> " width="80%">

            </div>

        <div id="right">
            <?php if(strcmp($paysage[$i_picture]['lieu'],$paysage[$i_picture+1]['lieu'])==0) { ?>
            <a class="next" href="bigsize.php?i_picture=<?php echo $i_picture+1 ;?>"><i class="fas fa-angle-right"></i></a>
            <?php } 
            else
           { ?>
            <i class="fas fa-angle-right"></i>
            <?php }
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