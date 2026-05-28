<?php
    session_start();
    include('data.php');
    include('function.php');
    if(isset($_GET['num'])==true)
    {
        $num=$_GET['num'];
    }
    else{
        $num=0;
    }
    $cat=anarana($num);
    $o=manisa($tab,$num);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href="fontawesome-5/css/all.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <div id="entete">
        <div>
            <span class="g">G</span><span class="roc">roc</span><span class="ery">ery</span>
        </div>
        <div id="es">
            <div>
                <a href="index.php">Home</a>
            </div>
            <div>
                <a href="MP.php">Mon panier</a>
            </div>
            <div>
                Vegetables & Fruits
            </div>
            <div>
                Upgrade to pro
            </div>
            <div>
                Contact Us
            </div>
        </div>
        <div id="call">
            <div>
                <i class="fas fa-phone" id="phone"></i>
            </div>
            <div>
                <strong>Call to</strong> +1800090098 <br> Email: info@gmail.com
            </div>
        </div>
    </div>
    <br>
    <div id="choice">
        <div id="menu">
            <div class="greenf">
                <i class="fas fa-bars"></i>
                Category
                <i class="fas fa-chevron-up" id="chevron"></i>
            </div>
            <div id="mm">
                <div>
                    <a href="index.php?num=0">Vegetables & Fruits</a>
                </div>
                <div>
                    <a href="index.php?num=1">Beverages</a>
                </div>
                <div>
                    <a href="index.php?num=2">Dairy Products</a>
                </div>
                <div>
                    <a href="index.php?num=3">FoodGrains & Oil</a>
                </div>
                <div>
                    <a href="index.php?num=4">Personal Care</a>
                </div>
                <div>
                    <a href="index.php?num=5">Pet Care</a>
                </div>
            </div>
        </div>
        <div id="gauche">
            <div id="skk">
                <strong>Category: <?php echo $cat; ?></strong> <br>
                <span>
                    Showing all <?php echo $o; ?> results
                </span>
            </div>
            <br>
            <div id="produit">
                <?php
                    $a = 0;
                ?>
                    <div class="s1">
                        <?php
                        for($j=0; $j<$o ; $j++)
                        { ?>
                            <div class="kely">
                                <div class="images">
                                <?php
                                        if($tab[$num][$a]['etat']=='sale')
                                        { ?>
                                            <div id="sale">
                                                <?php
                                                    echo $tab[$num][$a]['etat']; 
                                                ?>
                                            </div>
                                        <?php } 
                                        ?>
                                    <img src="<?php echo $tab[$num][$a]['image'] ?>" width="100%">
                                </div>
                                <div class="price">
                                    <p>
                                        <?php echo $tab[$num][$a]['nom'] ;?>
                                        <br>
                                        <span id="price">
                                        £<?php echo $tab[$num][$a]['prix']; ?>
                                            <br>
                                            <a href="traitement.php?nom=<?php echo $tab[$num][$a]['nom']?>&&vola=<?php echo $tab[$num][$a]['prix']?>&&sary=<?php echo $tab[$num][$a]['image']?>"><span id="ATC">Add Chart</span></a>
                                            <?php $a++;  ?>
                                        </span>
                                    </p>
                                </div>
                            </div>
                        <?php } ?>
                    </div>            
            </div>
        </div>
    </div>
    <div id="pied">
        <div id="ray">
            <p>
                <span class="g">G</span><span class="roc">roc</span><span class="ery">ery</span>
            </p>
            <p>
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Sint ea aliquam voluptas expedita tempora blanditiis ipsa illum, placeat aut perferendis autem modi
            </p>
            <div id="but1">
                <div class="tele">
                    <div class="fotsy"><i class="fab fa-google-play"></i></div>
                    <div>
                        <span class="soratrakely">GET IT ON</span> <br>
                        <span class="leobe">Google Play</span>
                    </div>
                </div>
                <div class="tele">
                    <div class="fotsy"><i class="fab fa-apple"></i></div>
                    <div>
                        <span class="soratrakely">Download on the</span> <br>
                        <span class="leobe">App Store</span>
                    </div>
                </div>
            </div>
        </div>
        <div id="roa">
            <div id="but2">
                <div id="paypal">
                    Paypal
                </div>
                <div>
                    master card
                </div>
                <div>
                    cirrus
                </div>
                <div>
                    maestro
                </div>
            </div>
            <div><strong>Contact Details</strong></div>
            <div>
                <p>
                Adresse: 3548 Columbia Mine Road, <br>
                Wheeling, West Virginia, <br>
                26003 <br>
                Contact : 304-559-3023 <br>
                304-650-2694 <br>
                E-mail : shopnow@open2.com <br>
                contact@open.com
                </p>
            </div>
        </div>
    </div>
</body>
</html>