<body>
    <div class="row justify-content-center" style="background-color:whitesmoke;border-color:whitesmoke ">
        <div class="col-lg-8" style="margin-top: 100px;">
            <div class="card mb-3">
                <div class="card-body">
                    <h1>Gestion Categorie: </h1>
                    <div id="affiche" >
    <?php foreach ($nom as $array) {?>
       <form method=get action="del">
       <div class="w3-panel w3-leftbar w3-border-orange w3-grey">
       <p> <?php echo $array['nom'];?><input type=submit value=delete class="button w3-btn w3-black w3-round-xlarge" ></p>
            <input type="hidden" name='id' value=<?php echo $array['id_categorie'];?>>
    </div>
        </form>
    <?php
}?>
</div>
<div >
       <form method=get action="inser">
            <p><input type="text" placeholder="New category" class="w3-input w3-animate-input ajout" name='categorie'><input type=submit class="w3-bar-item w3-button w3-orange" value=add></p>
</form>
</div>
<br>
                    <h1>Membre inscrit: <?php echo count($list_user); ?></h1>
                    <table class="table">
                        <tr>
                            <th>Id Utilisateur</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th> </th>
                            <th> </th>
                        </tr>
                    <?php for ($i=0; $i < count($list_user); $i++) { ?>
                        <tr>
                            <td> <?php echo $list_user[$i]['id_utilisateurs']; ?> </td>
                            <td> <?php echo $list_user[$i]['username']; ?> </td>
                            <td> <?php echo $list_user[$i]['email']; ?> </td>
                            <td> <?php echo $list_user[$i]['mdp']; ?> </td>
                        </tr>
                    <?php } ?>
                    </table>
                    <br>
                    <h1>Nombre d'echange effectuer: <?php echo $nb_histo;?></h1>
                    <br>
            </div>
          </div> 
        </div>
    </div>
</body>