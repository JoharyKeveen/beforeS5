<?php
    include('fonction.php');
    include('data.php');
    $nom=$_GET['anarana'];
    $date1=$_GET['date1'];
    $date2=$_GET['date2'];
    $result=mitady($nom, $tab,$date1,$date2);
    $manisa=count($result);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result</title>
</head>
<body>
    <?php
        if($result=="Error")
        {
            echo "Error";
        }
        else
        { ?>
    <p>
        <?php
            $i=0;
            while($i<count($result))
            {?>
               <p>
                   <?php
                        echo $tab[$result[$i]]['nom'];
                        ?>
                        <br>
                        <?php echo $tab[$result[$i]]['date'];
                   ?>
               </p> 
                <?php $i++;
            }
        ?>
    </p>
        <?php }
    ?>
</body>
</html>