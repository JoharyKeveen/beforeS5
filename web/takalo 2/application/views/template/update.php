<?php
$id = $var;
$titre = $var1;
$description = $var2;
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="update" method="get">
        <input type="hidden" name="id" value=<?php echo $id ?>>
        <p><input type="text" name="titre" value=<?php echo $titre ?>>titre</p>
        <p><input type="text" name="description" value=<?php echo $description ?>>description</p>
        <p><input type="text" name="prix">prix</p>
        <p><input type="submit" value="update"></p>
    </form>
</body>

</html>