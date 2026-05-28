<body>
    <div class="row justify-content-center" style="background-color:whitesmoke;border-color:whitesmoke ">
        <div class="col-lg-8" style="margin-top: 100px;">
            <div class="card mb-3">
                <div class="card-body">
                    <table class="table">
                        <tr>
                            <th>Vendeur</th>
                            <th>Objet vendu</th>
                            <th>Acheteur</th>
                            <th>Objet acheter</th>
                            <th>Date</th>
                        </tr>
                    <?php for ($i=0; $i < count($list_demande); $i++) { ?>
                        <tr>
                            <td> <?php echo $list_demande[$i]['username']; ?> </td>
                            <td> <?php echo $list_demande[$i]['sonobjet']; ?> </td>
                            <td> <?php echo $list_demande[$i]['me']; ?> </td>
                            <td> <?php echo $list_demande[$i]['monobjet']; ?> </td>
                            <td> <?php echo $list_demande[$i]['daty']; ?> </td>
                        </tr>
                    <?php } ?>
                    </table>
            </div>
          </div> 
        </div>
    </div>
</body>