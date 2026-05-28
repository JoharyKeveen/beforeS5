<?php
    include ('data.php');
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href="fontawesome-5/css/all.css" rel="stylesheet">
    <title>Index</title>
</head>
<body>
    <?php
        include('header.php');
    ?>
    <div id="body">
        <div id=nav>
            <!--ty le boite misy le menu verticale-->
            <?php
                for($a=0; $a<count($menuV); $a++)
                { ?>
                    <div>
                        <a href="<?php echo $a; ?>"><?php echo $menuV[$a]; ?></a>
                    </div>
            <?php }
            ?>
        </div>
    </div>
</body>
</html>