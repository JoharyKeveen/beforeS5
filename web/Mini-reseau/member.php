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
        $membres=mysqli_query($bdd,"SELECT * from membres;");
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
    <fieldset>
        <legend>
            Tous les membres du réseaux
        </legend>
    <?php
            while($affiche=mysqli_fetch_assoc($membres))
            { ?>
            <p>
                <?php
                    echo $affiche['Nom']; 
                    echo " ";
                    echo $affiche['Prenom'];
                ?>
            </p>
            <?php }
    ?>
    </fieldset>
    <fieldset>
        <legend>
            Tes amis
        </legend>
    <?php
        $amis=mysqli_query($bdd,"select * from amis join membres on amis.idMembre1=membres.idMembre where idMembre2='".$id."'");
            while($affichage=mysqli_fetch_assoc($amis))
            { ?>
            <p>
                <?php
                    echo $affichage['Nom']; 
                    echo " ";
                    echo $affichage['Prenom'];
                ?>
            </p>
            <?php }
    ?>
    </fieldset>
    <fieldset>
        <legend>
            connaissez-vous?
        </legend>
    <?php
        $amis1=mysqli_query($bdd,"select * from amis join membres on amis.idMembre1=membres.idMembre where idMembre2='".$id."'");
        $amis2=mysqli_query($bdd,"select * from amis join membres on amis.idMembre2=membres.idMembre where idMembre1='".$id."'");
        $amis=mysqli_query($bdd,"select * from membres");
        $this_person=mysqli_query($bdd,"select * from membres where idMembre='".$id."'");
        $aff=mysqli_fetch_assoc($this_person);
        while($affichagement1=mysqli_fetch_assoc($amis1))
        {
            while($affichagement2=mysqli_fetch_assoc($amis2))
            { 
                while($affichagement=mysqli_fetch_assoc($amis))
                {
                if($affichagement['Nom']=$affichagement2['Nom']&&$affichagement['Nom']=$affichagement1['Nom']&&$affichagement['Nom']!=$aff['Nom'])
                {
                    if($affichagement['Prenom']!=$affichagement1['Prenom']&&$affichagement['Prenom']!=$affichagement2['Prenom']&&$affichagement['Prenom']!=$aff['Prenom'])
                    {
                ?>
            <p>
                <?php
                    echo $affichagement['Nom']; 
                    echo " ";
                    echo $affichagement['Prenom'];
                ?>
            </p>
            <?php } } } } }
    ?>
    </fieldset>
</body>
<?php include("footer.php"); ?>
</html>