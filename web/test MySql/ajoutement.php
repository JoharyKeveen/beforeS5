<?php
    if($bdd=mysqli_connect('localhost','root','root','TP_Liaison_PHP'))
    {
        mysqli_set_charset($bdd,"utf8");
        //echo 'Connexion reussi <br/>';
        $pays=mysqli_query($bdd,'SELECT DISTINCT pays from clients order by pays');
    }
    else
    {
        echo 'Erreur';
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
    <h1>
        Ajouter client
    </h1>
    <form action="index.php" method="get">
        <h2>
            Code client <input type="text" name="code_client">
        </h2>
        <h2>
            Société <input type="text" name="societe">
        </h2>
        <h2>
            Adresse <input type="text" name="adresse">
        </h2>
        <h2>
            Pays
            <select name="pays" id="">
                <?php
                    while($donnees=mysqli_fetch_assoc($pays))
                    { ?>
                    <option value="<?php echo $donnees['pays']; ?>"><?php echo $donnees['pays']; ?></option>
                <?php } ?>
            </select>
        </h2>
        <h2>
            Ville <input type="text" name="ville">
        </h2>
        <input type="submit" value="Valider">
    </form>
</body>
</html>