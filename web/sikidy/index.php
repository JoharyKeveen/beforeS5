<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sikidy</title>
</head>
<body>
    <form action="accueil.php" method="get">
        <fieldset>
            <legend>Sikidy</legend>
            <input type="number" name="nb">
            <select name="loko">
                <option value="">misafidy loko</option>
                <option value="maintso">maintso</option>
                <option value="manga">manga</option>
                <option value="mena">mena</option>
            </select>
            <select name="sikidy">
                <option value="">misafidy sikidy</option>
                <option value="1">efamira</option>
                <option value="2">telozoro</option>
                <option value="3">bory</option>
            </select>
            <p>
            <input type="submit" value="choisir">
            </p>
        </fieldset>
    </form>
</body>
</html>