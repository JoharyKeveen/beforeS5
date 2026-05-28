<?php
include('connexion.php');
    if($_SESSION['connexion']!="authorized")
    {
        header('location:login.php');
    }
   $id=$_SESSION['id'];
    $membres=mysqli_query($bdd,"SELECT * from membres;");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/member.css">
    <link href="css/fontawesome-5/css/all.css" rel="stylesheet">
    <title>Document</title>
</head>
<?php include("navigation.php"); ?>
<body>
    <div id="all">
    <?php
    if(isset($_GET['remove'])==true)
    {
        mysqli_query($bdd,"delete from amis where idMembre1='".$_GET['remove']."' and idMembre2='".$id."'");
        mysqli_query($bdd,"delete from amis where idMembre2='".$_GET['remove']."' and idMembre1='".$id."'");
    }
    if(isset($_GET['suppress'])==true)
    {
        mysqli_query($bdd,"delete from amis where idMembre1='".$_GET['suppress']."' and idMembre2='".$id."'");
    }
    if(isset($_GET['add'])==true)
    {
        $validation=0;
        if($ver_validation=mysqli_query($bdd,"select * from amis where idMembre1='".$id."' and idMembre2='".$_GET['add']."'"))
        {
            while($ver_validation_final=mysqli_fetch_assoc($ver_validation))
            {
                $validation=$validation+1;
            }
        }
        if($verification=mysqli_query($bdd,"select * from amis where idMembre1='".$_GET['add']."' and idMembre2='".$id."'"))
        {
            while($ver=mysqli_fetch_assoc($verification))
            {
                if($ver['DateHeureConfirmation']==null)
                mysqli_query($bdd,"update amis set DateHeureConfirmation='now()' where idMembre1='".$_GET['add']."' and idMembre2='".$id."'");
                $validation=1;
            }
        }
        if($validation==0)
        mysqli_query($bdd,"insert into amis values('".$id."','".$_GET['add']."',now(),null)");
    }
    if(isset($_GET['confirm'])==true)
    {
        mysqli_query($bdd,"update amis set DateHeureConfirmation=now() where idMembre1='".$_GET['confirm']."' and idMembre2='".$id."'");
    }
    ?>
    <fieldset>

<?php
    function friend_test($id,$id_2)
    {
        $bdd=mysqli_connect('localhost','root','root','mydrugs');
        $friend1=mysqli_query($bdd,"select * from amis where idMembre2='".$id."' and idMembre1='".$id_2."' and DateHeureconfirmation is not null");
        $friend2=mysqli_query($bdd,"select * from amis where idMembre1='".$id."' and idMembre2='".$id_2."' and DateHeureconfirmation is not null");
        while($friend_1=mysqli_fetch_assoc($friend1))
        {
            return 1;
        }
        while($friend_2=mysqli_fetch_assoc($friend2))
        {
            return 1;
        }
        return 0;
    } 
?>
        <legend>
            Connaissez-vous pttr?
        </legend>
    <?php
        $result=mysqli_query($bdd,"select * from membres");
        ?>
        <div id="suggest_box">
            <?php
                    while($d=mysqli_fetch_assoc($result)){
                        $a=$d['idMembre'];
                        $myfriend=friend_test($id,$d['idMembre']);
                        if($myfriend==0&&$d['idMembre']!=$id){ ?>
                            <div id="suggest">
                                <p> 
                                    <?php echo $d['Nom']," ",$d['Prenom']," "," " ?>
                                </p>  
                                <p> <a href="member.php?add=<?php echo $d['idMembre']?>"><button id="bleu">add friend</button></a> </p>  
                            </div>
                        <?php }
                        } ?>
        </div>
    </fieldset>
    <fieldset>
        <legend>
            Demande d'amis
        </legend>
    <?php
        $demade_amis=mysqli_query($bdd,"select * from amis where idMembre2='".$id."' and DateHeureConfirmation is null");
        while($demande=mysqli_fetch_assoc($demade_amis))
        {
                $id_demamde=$demande['idMembre1'];
                $res=mysqli_query($bdd,"select * from membres where idMembre='".$id_demamde."'");
                $resulte=mysqli_fetch_assoc($res); ?>
                <div id="suggest">
                    <p> <?php echo $resulte['Nom']," ",$resulte['Prenom']," "," " ?></p>
                    <p> <a href="member.php?confirm=<?php echo $id_demamde?>"><button id="vert">confirm</button></a> <a href="member.php?suppress=<?php echo $id_demamde?>"><button id="rouge">suppress</button></a> </p>
                </div>
            <?php 
        }
    ?>
    </fieldset>
    <fieldset>
        <legend>
            Tes amis
        </legend>
    <?php
        $amis=mysqli_query($bdd,"select * from membres"); ?>
        <div id="suggest_box">
            <?php
                    while($d=mysqli_fetch_assoc($amis)){
                        $a=$d['idMembre'];
                        $myfriend=friend_test($id,$d['idMembre']);
                        if($myfriend==1&&$d['idMembre']!=$id){ ?>
                            <div id="suggest">
                                <p> 
                                    <?php echo $d['Nom']," ",$d['Prenom']," "," " ?>  
                                </p>  
                                <p> <a href="member.php?remove=<?php echo $d['idMembre']?>"><button>remove friend</button></a> </p>
                            </div>
                        <?php }
                        } ?>
        </div>
    </fieldset>
    <fieldset>
        <legend>
            Tous les membres du réseaux
        </legend>
        <div id="member">
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
    </div>
    </fieldset>
    </div>
</body>
</html>