<?php
$nombre=$_POST['nombre'];
?>
<!DOCTYPE html>
<html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link rel="stylesheet" type="text/css" href="style.css">
            </head>

    <body>
        <h1>Table de multiplication:<?php echo $nombre;?></h1>
        <table border="1" id="table">
                <tr>
                    <th>calcul</th>
                    <th>reponse</th>
                </tr>              
                <?php for($i=1;$i*$nombre<=$nombre*10;$i++) { ?>
                    <td>
                        <?php echo "$nombre x $i";?>
                    </td> 
                    <td>
                        <?php echo $nombre*$i;?>
                    </td> </tr>
                <?php } ?>
        </table>
        <p><a href="index.php"><< Retour</a></p>
    </body>

</html>