<?php
    include('connexion.php');
        $id=$_SESSION['id'];
    if($_SESSION['connexion']!="authorized")
    {
        header('location:login.php');
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/profil.css">
    <link href="css/fontawesome-5/css/all.css" rel="stylesheet">
    <title>Document</title>
</head>
    <?php include("navigation.php"); ?>
<body>
    <?php
        if(isset($_POST['N'])||isset($_POST['FN'])||isset($_POST['E'])||isset($_POST['P'])||isset($_POST['B']))
        {
            mysqli_query($bdd,"UPDATE membres SET Nom='".$_POST['N']."', Prenom='".$_POST['FN']."', Email='".$_POST['E']."', Motdepasse='".$_POST['P']."', DateNaissance='".$_POST['B']."' WHERE idMembre='".$id."'");
        }
            $id=$_SESSION['id'];
            $sentence="select * from membres where idMembre='%d'";
            $sql=sprintf($sentence,$_SESSION['id']);
            $res=mysqli_query($bdd,$sql);
    ?>
        <?php
            while($modification=mysqli_fetch_assoc($res))
            { ?>
            <div id="boite">
                    <?php if (isset($_POST['pdp'])) { ?>
                        <img src="picture/<?php echo $_POST['pdp']; ?>" width="150px">
                    <?php } ?>
                <form action="profil.php" method="post">
                    <input id="pdp" type='file' name='pdp'>
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
            </div>
            <?php }
    ?>
</body>
</html>