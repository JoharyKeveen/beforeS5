<?php
    include ('./inc/function/connexion.php');
    include ('./inc/function/function.php'); 
    $result=makapoule();

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

<?php for($i=0; $i<count($result); $i++) { ?>
        
    <div id="d">
        <h2>Groupe :<?php echo $result[$i]; ?> </h2>
        <?php $result2=affichage($result[$i]); ?>

            <?php for($e=0;$e< count(affichage('A')); $e++) {?>
                <p><?php echo $result2[$e]; ?> </p>
            <?php } ?>
    </div>
    <?php } ?>
        
    
<button><a href="./inc/traitement/traitement.php">GENERATE</a></button>
<button><a href="./inc/traitement/reset.php">RESET</a></button>
</body>
</html>
