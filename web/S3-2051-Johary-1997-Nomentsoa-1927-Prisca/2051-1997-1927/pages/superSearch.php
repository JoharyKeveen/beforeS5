<?php
    include('../inc/function/function.php');
    include('Header.php');
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
    <form action="superSearch.php" method="post">
        <center style="margin-top: 1%;">
            <h4>
                montant minimum <input type="number" name="minim"> - <input type="number" name="maxim"> motant maximum <input type="submit" value="go">
            </h4>
        </center>
    </form>
    <form action="superSearch.php" method="post">
        <center>
            <h4>
                arriver <input type="date" name="arriver"> - <input type="date" name="depart"> depart <input type="submit" value="go">
            </h4>
        </center>
    </form>
    <?php
        if(isset($_POST['minim'])&&isset($_POST['maxim']))
        {
            $result=rechercheVola($_POST['minim'],$_POST['maxim']);
            for($i=0;$i<count($result);$i+=7)
            {
                $affichage=get_the_trano($result[$i]); ?>
                <div style="border: solid 1px red;">
                    <h3>Type : <?php echo $affichage[6];?></h3>
                    <h3>Nombre de chambre : <?php echo $affichage[2];?></h3>
                    <h3>Tarif : <?php echo $affichage[3];?></h3>
                    <h3>Quartier : <?php echo $affichage[4];?></h3>
                    <h3>Description : <?php echo $affichage[5];?></h3>
                </div>
            <?php }
        }
        else if(isset($_POST['arriver'])&&isset($_POST['depart']))
        {
            $id_trano=liste_trano();
            for($i=0;$i<count($id_trano);$i+=7)
            {
                if(is_between($_POST['arriver'],$_POST['depart'],$id_trano[$i])==false)
                {
                    $affichage=get_the_trano($id_trano[$i]); ?>
                    <div style="border: solid 1px red;">
                        <h3>Type : <?php echo $affichage[6];?></h3>
                        <h3>Nombre de chambre : <?php echo $affichage[2];?></h3>
                        <h3>Tarif : <?php echo $affichage[3];?></h3>
                        <h3>Quartier : <?php echo $affichage[4];?></h3>
                        <h3>Description : <?php echo $affichage[5];?></h3>
                    </div>
                <?php }
            }
        }
    ?>
</body>
<footer>
    <?php
        include('Footer.php');
    ?>
</footer>
</html>