<body >
    <div id="fil_dacc">
        <?php
            for($i=0;$i<count($list);$i++)
            {
                ?>
                <div class="col-lg-2" class="card">
                    <img src="../assets/img/<?php echo($list[$i]['photo']); ?>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"> <?php echo($list[$i]['titre']); ?> </h5>
                        <p class="card-text"> <?php echo($list[$i]['descriptions']); ?> </p>
                        <h5> <?php echo "Prix: " . $list[$i]['prix']; ?> Ariary</h5>
                    </div>
                </div>
                <br>
                <?php
            }
            if(count($list)==0)
            {
                ?>
                <h1>
                    Aucun resultat T.T
                </h1>
                <?php
            }
        ?>
    </div>
</body>