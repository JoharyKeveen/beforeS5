<?php
include("pays.php")
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Info perso</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <div id="entete">
        <h1>Achyl's hôtel</h1>
    </div>
    <div id="voalohany" border="1">
        <h1>Information personnelles</h1>
        <form action="2e page.php" method="get">
            <p>Nom👌 <input type="text" name="nom"></p>
            <p>
                Date de naissance📅
                <span>
                    <select name="jour" id="jour">
                        <option value="">Jour</option>
                        <?php for($a=1;$a<=31;$a++) {?>
                            <option value="<?php echo $a;?>"><?php echo $a;?></option>
                        <?php } ?>
                    </select>
                </span>
                <span>
                    <select name="mois" id="mois">
                    <option value="">Mois</option>
                        <?php for($d=0;$d<=11;$d++) { ?>
                            <option value="<?php echo $mois[$d]; ?>"><?php echo $mois[$d]; ?></option>
                        <?php } ?>
                    </select>
                </span>
                <span>
                    <select name="annees" id="annees">
                        <option value="">Annees</option>
                        <?php for($b=1900;$b<=2021;$b++) { ?>
                            <option value="<?php echo $b;?>"><?php echo $b;?></option>
                        <?php } ?>
                    </select>
                </span>
            </p>
            <p>Genre 🚻
                <span>
                    <select name="genre" id="genre">
                        <option value="">choisir le genre</option>
                        <option value="Homme">Homme</option>
                        <option value="Femme">Femme</option>
                        <option value="Autres">Autres</option>
                    </select>
                </span>
            </p>
            <p>
                Pays🗺
                <span>
                    <select name="pays" id="pays">
                        <option value="">Choisir un pays</option>
                        <?php for($c=0;$c<=248;$c++) { ?>
                            <option value="<?php echo $pays[$c]; ?>"><?php echo $pays[$c]; ?></option>
                        <?php } ?>
                    </select>
                </span>
            </p>
            <button input type="submit" value="Valider">Valider</button> 
    </form>
    </div>
</body>
</html>