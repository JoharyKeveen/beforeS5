<?php
include("fonction premier.php"); 
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Nombre premier/Nombre compose:</h1>
    <form action="2p.php" method="get">
        <div class="div">
            <?php for($i=1;$i<=100;$i++) { ?>
                <table class="table" border="1" width="100px">
                    <tr>
                        <a href="2p.php?num=<?php echo $i; ?>"><?php echo $x = nbpremier($i); ?></a>
                    </tr>
                </table>
            <?php } ?>
        </div>
    </form>
</body>
</html>