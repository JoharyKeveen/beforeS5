<?php
include("data.php");
?>
<!DOCTYPE html>
<html>
    <head>
        <title>profil</title>
        <meta charset="UTF-8">
	</head>
	<body>
    <form action="2p.php" method="get">
        <h1>Liste des pays</h1>
        <?php
        $string="ABCDEFGHIJKLMNOPQRSTUVWXYZ" ?>
        <ul>
        <?php for($i=0;$i<26;$i++) { ?>
            <li><a href="2p.php?num=<?php echo $string[$i]; ?>"> <?php echo $string[$i]; ?></a> </li>
        <?php } ?>
        </ul>
        </form>
        
	</body>
</html>