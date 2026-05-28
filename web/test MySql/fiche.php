<?php
    if($bdd=mysqli_connect('localhost','root','root','TP_Liaison_PHP'))
    {
        mysqli_set_charset($bdd,"utf8");
        //echo 'Connexion reussi <br/>';
    }
    else
    {
        echo 'Erreur';
    }
?>

<?php
        $code=$_GET['code'];
        $sql="SELECT * FROM clients WHERE CODE_CLIENT='".$code."'";
        $res=mysqli_query($bdd,$sql);
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
    <?php while($donnees=mysqli_fetch_assoc($res))
    { ?>
    <table width="500" border="1" style="border-collapse: collapse">
        <tr>
            <th>
                Code client
            </th>
            <td>
                <?php echo $donnees['CODE_CLIENT'];?>
            </td>
        </tr>
        <tr>
            <th>
                Societe
            </th>
            <td>
                <?php echo $donnees['SOCIETE']; ?>
            </td>
        </tr>
        <tr>
            <th>
                Adresse
            </th>
            <td>
                <?php echo $donnees['ADRESSE']; ?>
            </td>
        </tr>
        <tr>
            <th>
                Ville
            </th>
            <td>
                <?php echo $donnees['VILLE']; ?>
            </td>
        </tr>
        <tr>
            <th>
                Pays
            </th>
            <td>
                <?php echo $donnees['PAYS'];?>
            </td>
        </tr>
    </table>
    <?php } ?>
</body>
</html>

<?php mysqli_free_result($res);?>