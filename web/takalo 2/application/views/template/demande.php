<body>
    <div class="row justify-content-center" style="background-color:whitesmoke;border-color:whitesmoke ">
        <div class="col-lg-8" style="margin-top: 100px;">
            <div class="card mb-3">
                <div class="card-body">
                    <table class="table">
                        <tr>
                            <th>Acheteur</th>
                            <th>Son objet</th>
                            <th>Mon objet</th>
                            <th> </th>
                            <th> </th>
                        </tr>
                    <?php for ($i=0; $i < count($list_demande); $i++) { ?>
                        <tr>
                            <td> <?php echo $list_demande[$i]['username']; ?> </td>
                            <td> <?php echo $list_demande[$i]['sonobjet']; ?> </td>
                            <td> <?php echo $list_demande[$i]['monobjet']; ?> </td>
                            <td>
                                <form action="acceptDemande" method="post">
                                    <input type="hidden" value="<?php echo $list_demande[$i]['id']; ?>" name="id">
                                    <button class="btn btn-primary" type="submit"  style="background-color:lightgreen">Accepter</button>
                                </form>
                            </td>
                            <td>
                                <form action="refusDemande" method="post">
                                    <input type="hidden" value="<?php echo $list_demande[$i]['id']; ?>" name="id">
                                    <button class="btn btn-primary" type="submit"  style="background-color:red">Refuser</button>
                                </form>
                            </td>
                        </tr>
                    <?php } ?>
                    </table>
            </div>
          </div> 
        </div>
    </div>
</body>