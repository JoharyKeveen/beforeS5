<?php
$ligne=$_GET['ligne'];
$colone=$_GET['colone'];
$color=$_GET['color'];
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
        table number 1:
    </h1>
    <table border="1" width="150px" height="150px">
        <?php for($i=1;$i<=$ligne;$i++) { ?>
            <tr>
            <?php for($x=1;$x<=$colone;$x++) { 
                if($i==$x) { ?>
                <td style="background-color:<?php echo $color; ?>">
                <a href="detail.php?tab=1&ligne=<?php echo $i?>&colone=<?php echo $x;?>&color=<?php echo $color;?>">X</a>
                </td>
                <?php }
                else { ?>
                <td>
                <a href="detail.php?tab=1&ligne=<?php echo $i?>&colone=<?php echo $x;?>&color=<?php echo $color;?>">X</a>
                </td>

            <?php }
        }
     } ?>
     </tr>
    </table>

    <h1>
        table number 2:
    </h1>
    <table border="1" width="150px" height="150px">
        <?php for($i=1;$i<=$ligne;$i++) { ?>
            <tr>
            <?php for($x=1;$x<=$colone;$x++) { 
                if($i==1|$i==$ligne|$x==1|$x==$colone) { ?>
                <td style="background-color:<?php echo $color; ?>">
                <a href="detail.php?tab=2&ligne=<?php echo $i?>&colone=<?php echo $x;?>&color=<?php echo $color;?>">X</a>
                </td>
                <?php }
                else { ?>
                <td >
                <a href="detail.php?tab=2&ligne=<?php echo $i?>&colone=<?php echo $x;?>&color=<?php echo $color;?>">X</a>
                </td>

            <?php }
        }
     } ?>
     </tr>
    </table>
</body>
</html>