<?php
    if(isset($_GET['view'])==true)
    { 
        $tab=view($_GET['view']);
        ?>
        <img src="../assets/img/<?php echo $tab[3];?>" width="250px" alt="">
        <h1>Nom: <?php echo $tab[0];?></h1>
        <h1>Prenom: <?php echo $tab[1];?></h1>
        <h1>Date de naissance: <?php echo $tab[2];?></h1>
        <h1>Niveau d'étude: <?php echo $tab[4];?></h1>
        <h1>Filière: <?php echo $tab[5];?></h1>
        <h1>Est-il sportif?   --> <?php echo $tab[6];?></h1>
    <?php }
    else if(isset($_GET['edit'])==true)
    { 
        $tab=view($_GET['edit']);
        ?>
        <form action="../inc/traitement/edit_cv.php" method="post" enctype="multipart/form-data" style="margin-left: 2%;">
            <h1>Nom: <input type="text" name="Nom" required value="<?php echo $tab[0];?>"></h1>
            <h1>Prenom: <input type="text" name="Prenom" required value="<?php echo $tab[1];?>"></h1>
            <h1>Date de naissance: <input type="date" name="Date_de_naissance" required value="<?php echo $tab[2];?>"></h1>
            <input type="hidden" name="MAX_FILE_SIZE" value="2000000">
            <h1>Selection de photo:</h1>
            <input type="file" name="avatar" required>
            <?php
                $descri=get_descri();
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
            <?php } ?>
            <br>
            <br>
            <p>
                <input type="hidden" name="id_num" value="<?php echo $_GET['edit'];?>">
                <input type="submit" value="Envoyer le fichier">
            </p>
        </form>
    <?php }
?>