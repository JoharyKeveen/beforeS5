<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="fontawesome-5/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>
<header>
<?php
    include('data.php');
?>
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
</body>
</html>