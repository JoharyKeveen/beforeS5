<body >
    <h1><a href=""></a></h1>
    <div id="fil_dacc">
        <?php
            for($i=0;$i<count($list_objet);$i++)
            {
                ?>
                <div class="col-lg-2" class="card">
                    <img src="../assets/img/<?php echo($list_objet[$i]['photo']); ?>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"> <?php echo($list_objet[$i]['titre']); ?> </h5>
                        <p class="card-text"> <?php echo($list_objet[$i]['descriptions']); ?> </p>
                        <h5> <?php echo "Prix: " . $list_objet[$i]['prix']; ?> Ariary</h5>
                        <p><a href="../GestionProposition/redirect?objet=<?php echo($list_objet[$i]['id_objet']) ?>" style="text-decoration: none;"><button class="form-control form-control-dark text-bg-dark">Echanger</button></a></p>
                    </div>
                </div>
                <br>
                <?php
            }
        ?>
    </div>
</body>