<?php
    $descri=get_descri();
?>
<form action="../inc/traitement/add_cv.php" method="post" enctype="multipart/form-data" style="margin-left: 2%;">
    <h1>Nom</h1> <input type="text" name="Nom" required>
    <h1>Prenom</h1> <input type="text" name="Prenom" required>
    <h1>Date de naissance</h1> <input type="date" name="Date_de_naissance" required>
    <input type="hidden" name="MAX_FILE_SIZE" value="2000000">
    <h1>Selection de photo</h1> <input type="file" name="avatar" required>
    <?php
        for($i=0;$i<count($descri);$i++)
        { 
            $choice=get_choice($descri[$i]);

            ?>
            <h1><?php echo $descri[$i];?></h1>
            <select name="P<?php echo $i+1;?>">
                <?php
                for($j=0;$j<count($choice);$j++)
                { ?>
                    <option value="<?php echo $choice[$j]?>"><?php echo $choice[$j]?></option>
                <?php }
                ?>
            </select>
        <?php }
    ?>
    <br>
    <p>
        <input type="submit" value="Envoyer le fichier">
    </p>
</form>