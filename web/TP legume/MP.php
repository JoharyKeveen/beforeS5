<?php
    session_start();
    include('data.php');
    include('function.php');
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
    <div id="MPMP">
    <br>
        <?php
            if(!isset($_SESSION['count']))
            {?>
                Votre panier est vide
            <?php }
            else {?>
                <h1>
                    Votre panier est composé de:
                </h1>
                <div id="entanaLAFO">
                    <?php for($a=0; $a<$_SESSION['count']; $a++)
                    { ?>
                        <div class="saryMP">
                        <img src="<?php echo $_SESSION['prod'][$a]['sary']; ?>" alt="tsy mety eeeee" width="100%">
                        </div>
                        <div class="soratraMP">
                            <div>
                                <?php echo $_SESSION['prod'][$a]['nom']; ?>
                            </div>
                            <div>
                                £<?php echo $_SESSION['prod'][$a]['vola']; ?>
                            </div>
                        </div>
                    <?php } ?>
                </div>
            <?php }
        ?>
        <br>
    <div id="MG">
        <?php
            if(isset($_SESSION['count']))
            { ?>
                <strong>
                Prix total: 
            </strong>
            <div>
                £<?php
                    $a=0;
                    for($i=0; $i<$_SESSION['count']; $i++)
                    {
                        $a=$a+$_SESSION['prod'][$i]['vola'];
                    }
                    echo $a;
                ?>.00
            </div>
            <?php }
        ?>
    </div>
    <br>
    <div id="decon">
        <a href="deconnexion.php">vider mon panier</a>
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