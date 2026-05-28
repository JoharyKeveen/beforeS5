<?php
    if($bdd=mysqli_connect('localhost','root','root','TP_Liaison_PHP'))
    {
        mysqli_set_charset($bdd,"utf8");
        //echo 'Connexion reussi <br/>';
        if(isset($_GET['ed'])==true)
        {
            mysqli_query($bdd,"DELETE FROM CLIENTS WHERE CODE_CLIENT='".$_GET['ed']."'");
            header('location:index.php');
        }
        
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
    <?php
        if(isset($_GET['modif'])==true)
        { 
            $modif=$_GET['modif'];
            $res=mysqli_query($bdd,"SELECT * FROM CLIENTS WHERE CODE_CLIENT='$modif'");
            ?>
            <h1>
                Vous allez modifier le contenue du client: <?php echo $_GET['modif']; ?>
            </h1>
        <?php
            while($modification=mysqli_fetch_assoc($res))
            { ?>
            <form action="index.php" method="get">
                <h2>
                    Code Client: <input type="text" name="CD" value="<?php echo $modification['CODE_CLIENT']; ?>">
                </h2>
                <h2>
                    Societe: <input type="text" name="S" value="<?php echo $modification['SOCIETE']; ?>">
                </h2>
                <h2>
                    Adresse: <input type="text" name="A" value="<?php echo $modification['ADRESSE']; ?>">
                </h2>
                <h2>
                    Ville: <input type="text" name="V" value="<?php echo $modification['VILLE']; ?>">
                </h2>
                <h2>
                    Code Postal: <input type="text" name="CP" value="<?php echo $modification['CODE_POSTAL']; ?>">
                </h2>
                <h2>
                    Pays: <input type="text" name="P" value="<?php echo $modification['PAYS']; ?>">
                </h2>
                <h2>
                    Telephone: <input type="text" name="T" value="<?php echo $modification['TELEPHONE']; ?>">
                </h2>
                <h2>
                    Fax: <input type="text" name="F" value="<?php echo $modification['FAX']; ?>">
                </h2>
                <input type="hidden" name="indice" value="<?php echo $modif ?>">
                <input type="submit" value="Modifier">
            </form>
            <?php }
        }
    ?>
</body>
</html>