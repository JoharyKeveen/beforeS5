
<?php
    $annee_naissance=$_GET['annee'];
     if($annee_naissance%12==4){
        $phrase = "votre signe est celui du Rat";
    }
    if($annee_naissance%12==5){
        $phrase = "votre signe est celui du Boeuf";
    }
    if($annee_naissance%12==6){
        $phrase = "votre signe est celui du Tigre";
    }
    if($annee_naissance%12==7){
        $phrase = "votre signe est celui du Lievre";
    }
    if($annee_naissance%12==8){
        $phrase = "votre signe est celui du Dragon";
    }
    if($annee_naissance%12==9){
        $phrase = "votre signe est celui du Serpent";
    }
    if($annee_naissance%12==10){
        $phrase = "votre signe est celui du Cheval";
    }
    if($annee_naissance%12==11){
        $phrase = "votre signe est celui du Chevre";
    }
    if($annee_naissance%12==0){
        $phrase = "votre signe est celui du  Singe";
    }
    if($annee_naissance%12==1){
        $phrase = "votre signe est celui du Coq";
    }
    if($annee_naissance%12==2){
        $phrase = "votre signe est celui du Chien";
    }
    if($annee_naissance%12==3){
        $phrase = "votre signe est celui du Cochon";
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <fieldset>
        <legend>
            <h1>
            Information Personnelle
            </h1>
        </legend>
    <h4>
        Votre année de naissance est le <?php echo $annee_naissance; ?> et <?php echo $phrase;?>.
    </h4>
    <p>
        <a href="index.php">Retour</a>
    </p>
    </fieldset>
</body>
</html>
