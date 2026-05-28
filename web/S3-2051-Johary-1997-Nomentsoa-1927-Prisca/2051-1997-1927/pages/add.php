<?php
include('Header.php');
include('../inc/function/function.php');
$affichage = get_type();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="../assets/css/styleinfo.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <div id="ins">
        <h3>Insertion</h3>
            <form action="../inc/traitement/add.php" method="post">

                <p>
                    Type :
                    <select name="type" style="margin-left: 115px;">
                        <?php
                        for ($i = 0; $i < count($affichage); $i += 2) { ?>
                            <option value="<?php echo ($affichage[$i]); ?>"><?php echo ($affichage[$i + 1]); ?></option>
                        <?php }
                        ?>
                    </select>
                </p>
                <p>
                    Nombre de chambre : <input type="number" name="nb_chambre" min='1'>
                </p>
                <p>
                    Loyer : <input type="text" name="loyer" style="margin-left: 110px;">
                </p>
                <p>
                    Quartier : <input type="text" name="quartier" style="margin-left: 90px;">
                </p>
                <p>
                    Descriptions : <input type=" text" name="desc" style="margin-left:60px;">
                </p>
                <p>
                    <input type="submit" id="in1" value="ADD" style="margin-left:170px;">
                </p>

            </form>
    </div>
</body>
<footer style="margin-top: 165px;">
    <?php
    include('Footer.php');
    ?>
</footer>

</html>