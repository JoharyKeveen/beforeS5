<?php
    include('Header.php');
    include('../inc/function/function.php');
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
    <form action="tranoDispo.php" method="get">
        <h3>
            <center>
                Choisir mois et années: <input type="date" name="daty"> <input type="submit" value="search">
            </center> 
        </h3>
    </form>
    <?php
        if(isset($_GET['daty']))
        {
            date_default_timezone_set('GMT');
            $y=date('Y',strtotime($_GET['daty']));
            $m=date('m',strtotime($_GET['daty']));
            $dat1=$y."-".$m."-00";
            if($m==1||$m==3||$m==5||$m==7||$m==8||$m==10||$m==12)
            {
                $dat2=$y."-".$m."-31";
            }
            else if($m==2)
            {
                $dat2=$y."-".$m."-28";
            }
            else
            {
                $dat2=$y."-".$m."-30";
            }
            $gb=get_between($dat1,$dat2);
            $trano=liste_trano();
            ?>
            <table class="table">
                <th>Date</th>
                <th>Nombre d'habitation disponible</th>
            <?php for($i=0;$i<count($gb)-1;$i++)
            {
                $size=0;
                $str="";
                for($j=0;$j<count($trano);$j+=7)
                {
                    if(is_between($gb[$i],$gb[$i+1],$trano[$j])==false)
                    {
                        $size++;
                        $str=$str."_".$trano[$j];
                    }
                }
                ?>
                <tr>
                    <td>
                        <?php echo $gb[$i];?>
                    </td>
                    <td>
                        <a href="tranoDispo.php?id=<?php echo $str;?>" style="text-decoration: none;"><?php echo $size;?></a>
                    </td>
                </tr>
            <?php } ?>
            </table>
        <?php }
        else if(isset($_GET['id']))
        {
            $id=explode("_",$_GET['id']);
            for($i=1;$i<count($id);$i++)
            {
                $liste=get_the_trano($id[$i]);
                for($j=0;$j<count($liste);$j+=7)
                { ?>
                    <div style="border: solid 1px red;">
                        <h3>Type : <?php echo $liste[6];?></h3>
                        <h3>Nombre de chambre : <?php echo $liste[2];?></h3>
                        <h3>Tarif : <?php echo $liste[3];?></h3>
                        <h3>Quartier : <?php echo $liste[4];?></h3>
                        <h3>Description : <?php echo $liste[5];?></h3>
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