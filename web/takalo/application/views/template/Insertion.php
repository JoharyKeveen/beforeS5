<?php

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
    <form action="upload" method="get" enctype="multipart/form-data">
        <input type="hidden" name="MAX_FILE_SIZE" value="90000000">
        <p><input type=" text" name="titre">titre</p>
        Fichier : <input type="file" name="FILES">
        <select name="categorie">
            <option>Technologie</option>
            <option>vetement</option>
            <option>livre</option>
            <option>DVD</option>
        </select>categorie
        <p><input type=" text" name="description">Description</p>
        <p><input type="text" name="prix">prix</p>
        <p><input type="submit" value="Inserer"></p>
    </form>
</body>

</html>