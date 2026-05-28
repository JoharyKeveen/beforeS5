<?php
    $p=para();
?>
<form action="../inc/traitement/para.php" method="post">
<h1><?php echo $p[0]?>:</h1>
    <h3>Valeur:</h3><input type="text" name="P1v" value="<?php echo $p[1];?>">
    <h3>Coefficient:</h3><input type="text" name="P1c" value="<?php echo $p[2];?>">

    <h1><?php echo $p[3]?>:</h1>
    <h3>Valeur:</h3><input type="text" name="P2v" value="<?php echo $p[4];?>">
    <h3>Coefficient:</h3><input type="text" name="P2c" value="<?php echo $p[5];?>">

    <h1><?php echo $p[6]?>:</h1>
    <h3>Valeur:</h3><input type="text" name="P3v" value="<?php echo $p[7];?>">
    <h3>Coefficient:</h3><input type="text" name="P3c" value="<?php echo $p[8];?>">

    <h1>
        <input type="submit" value="Modifier">
    </h1>
</form>