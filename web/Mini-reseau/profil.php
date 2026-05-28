<?php
session_start();
    if($_SESSION['connexion']!="authorized")
    {
        header('location:login.php');
    }
    if($bdd=mysqli_connect('localhost','root','root','mydrugs'))
    {
        mysqli_set_charset($bdd,"utf8");
        $id=$_SESSION['id'];
    }
    else
    {
        echo "Error";
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
    <?php include("navigation.php"); ?>
<body>
    <?php
        if(isset($_GET['N'])||isset($_GET['FN'])||isset($_GET['E'])||isset($_GET['P'])||isset($_GET['B']))
        {
            mysqli_query($bdd,"UPDATE membres SET Nom='".$_GET['N']."', Prenom='".$_GET['FN']."', Email='".$_GET['E']."', Motdepasse='".$_GET['P']."', DateNaissance='".$_GET['B']."' WHERE idMembre='".$id."'");
        }
            $id=$_SESSION['id'];
            $sentence="select * from membres where idMembre='%d'";
            $sql=sprintf($sentence,$_SESSION['id']);
            $res=mysqli_query($bdd,$sql);
    ?>
            <h1>
                Vos données sont:
            </h1>
        <?php
            while($modification=mysqli_fetch_assoc($res))
            { ?>
            <form action="profil.php" method="get">
                <h2>
                    Name: <input type="text" name="N" value="<?php echo $modification['Nom']; ?>">
                </h2>
                <h2>
                    First name: <input type="text" name="FN" value="<?php echo $modification['Prenom']; ?>">
                </h2>
                <h2>
                    Email: <input type="text" name="E" value="<?php echo $modification['Email']; ?>">
                </h2>
                <h2>
                    Password: <input type="text" name="P" value="<?php echo $modification['Motdepasse']; ?>">
                </h2>
                <h2>
                    Date of birth: <input type="text" name="B" value="<?php echo $modification['DateNaissance']; ?>">
                </h2>
                <input type="submit" value="Change">
            </form>
            <?php }
    ?>
</body>
    <?php include("footer.php"); ?>
</html>