<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rechercher</title>
</head>
<body>
    <form action="result.php">
        <p>
            Mot à chercher:<input type="text" name="anarana">
        </p>

        <p>
            Année minimale:
            <select name="date1" id="date1">
                <?php
                    for($i=2022; $i>1950; $i--)
                    { ?>
                        <option value="<?php echo $i; ?>"><?php echo $i; ?></option>
                    <?php }
                ?>
            </select>
        </p>

        <p>
            Année maximale:
            <select name="date2" id="date2">
                <?php
                    for($i=2022; $i>1950; $i--)
                    { ?>
                        <option value="<?php echo $i; ?>"><?php echo $i; ?></option>
                    <?php }
                ?>
            </select>
        </p>

        <p>
            <input type="submit" value="Rechercher">
        </p>
    </form>
</body>
</html>