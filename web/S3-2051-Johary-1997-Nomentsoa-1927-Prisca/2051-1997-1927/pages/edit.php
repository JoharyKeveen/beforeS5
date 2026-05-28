<?php
include('Header.php');
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
    <div id="di">
        <h2>Edit</h2>
        <form action="../inc/traitement/edit.php" method="post">
            <p>
                Loyer : <input id="put" type="text" value="<?php echo ($_GET['loyer']); ?>" name="loyer">
            </p>
            <p>
                Descriptions : <input type="text" value="<?php echo ($_GET['desc']); ?>" name="desc">
            </p>
            <p>
                <input type="hidden" value="<?php echo ($_GET['id']); ?>" name="id">
                <input type="submit" value="Edit" id="sub">
            </p>
        </form>
    </div>

</body>
<footer style="margin-top: 175px">
    <?php
    include('Footer.php');
    ?>
</footer>

</html>