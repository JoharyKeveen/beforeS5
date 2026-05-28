<?php
    include ('./inc/function/connexion.php');
    include ('./inc/function/function.php'); 
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #d{
            float:left;
            margin:25px;
        }
            
    </style>
</head>
<body>

    <?php for($i=0;$i<count(makapoule()); $i++) { ?>
        
    <div id="d">
        <h2>Groupe :<?php echo makapoule()[$i]?> </h2>

            <?php for($e=0;$e<count(affichage('A')); $e++) {?>
                <p><?php echo affichage(makapoule()[$i])[$e]; ?> </p>
            <?php } ?>
    </div>
    <?php } ?>

</body>
</html>
