<?php
include('Header.php');
include('../inc/function/function.php');
$affichage = liste_trano();
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
    <table border="1" class="table">
        <tr>
            <td>
                Type
            </td>
            <td>
                Nombre de chambre
            </td>
            <td>
                Loyer
            </td>
            <td>
                Quartier
            </td>
            <td>
                Descriptions
            </td>
            <td>
                Modifier
            </td>
            <td>
                Effacer
            </td>
        </tr>
        <?php
        for ($i = 0; $i < count($affichage); $i += 7) { ?>
            <tr>
                <td>
                    <?php echo ($affichage[$i + 6]); ?>
                </td>
                <td>
                    <?php echo ($affichage[$i + 2]); ?>
                </td>
                <td>
                    <?php echo ($affichage[$i + 3]); ?>
                </td>
                <td>
                    <?php echo ($affichage[$i + 4]); ?>
                </td>
                <td>
                    <?php echo ($affichage[$i + 5]); ?>
                </td>
                <td>
                    <button><a href="edit.php?id=<?php echo ($affichage[$i]); ?>&&loyer=<?php echo ($affichage[$i + 3]); ?>&&desc=<?php echo ($affichage[$i + 5]); ?>" style="text-decoration: none;">edit</a></button>
                </td>
                <td>
                    <button><a href="../inc/traitement/delete.php?delete=<?php echo ($affichage[$i]); ?>" style="text-decoration: none;">delete</a></button>
                </td>
            </tr>
        <?php }
        ?>
    </table>
    <button id="button1"><a href="add.php">Add</a></button>
</body>
<footer style="margin-top: 130px;">
    <?php
    include('Footer.php');
    ?>
</footer>

</html>