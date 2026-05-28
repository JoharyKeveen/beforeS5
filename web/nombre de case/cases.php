<?php
$vert=$_POST['vert'];
$bleu=$_POST['bleu'];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cases</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Olona tsy misy atao</h1>
        <div id="div1">
            <h2>Tableau vert</h2>
            <table border="1" width="400px" >
                <?php for ($a=1;$a<=$vert;$a++) { ?>
                    <tr  height="100px">
                        <td style="background-color:green"></td>
                    </tr>
                <?php } ?>
            </table>
        </div>
        <br>
        <div id="div2">
            <h2>Tableau bleu</h2>
            <table border="1" width="400px"  >
                <?php for ($b=1;$b<=$bleu;$b++) { ?>
                    <tr height="100px">
                        <td style="background-color:blue"></td>
                    </tr>
                <?php } ?>
            </table>
        </div>
        <div><p><a href="index.php"><< Retour</a></p></div>
</body>
</html>