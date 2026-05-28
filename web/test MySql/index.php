<?php
    if($bdd=mysqli_connect('localhost','root','root','TP_Liaison_PHP'))
    {
        mysqli_set_charset($bdd,"utf8");
        //echo 'Connexion reussi <br/>';
        $pays=mysqli_query($bdd,'SELECT DISTINCT pays from clients order by pays');
    }
    else
    {
        echo 'Erreur';
    }

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

<?php
    if(isset($_GET['get_mot'])==false&&isset($_GET['pays_send'])==false)
    { ?>
    <fieldset>
        <legend>
            <h1>
                recherche d'entreprise
            </h1>
        </legend>
        <form action="index.php">
            <input type="text" name="get_mot">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>
    <?php }
?>

<?php
    if(isset($_GET['get_mot'])==true)
    {
        $get_mot=$_GET['get_mot'];
        $res=mysqli_query($bdd,'SELECT * FROM clients order by societe'); ?>
        <table width="1600" border="1" style="border-collapse: collapse">
            <tr>
                <th width="200px">
                    <h1>
                        Code clients
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Societe
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Adresse
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Ville
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Pays
                    </h1>
                </th>
            </tr>
        <?php
            while($donnees=mysqli_fetch_assoc($res))
            {
                if(strpos(strtolower($donnees['SOCIETE']),strtolower($get_mot)))
                {?>
                    <tr>
                        <th width="200px">
                            <a href="fiche.php?code=<?php echo $donnees['CODE_CLIENT'];?>"><?php echo $donnees['CODE_CLIENT'];?></a>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['SOCIETE']; ?>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['ADRESSE']; ?>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['VILLE']; ?>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['PAYS']; ?>
                        </th>
                    </tr>
                <?php }
            }
    }
?>

<?php 
    if(isset($_GET['get_mot'])==false)
    { ?>
    <fieldset>
        <legend>
            <h1>
                Filtrement 
            </h1>
        </legend>
        <form action="index.php">
        <select name="pays_send" id="">
                <?php
                    while($donnees=mysqli_fetch_assoc($pays))
                    { ?>
                    <option value="<?php echo $donnees['pays']; ?>"><?php echo $donnees['pays']; ?></option>
                <?php } ?>
            </select>
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>
    <?php } ?>

<?php
    if(isset($_GET['pays_send'])==true)
    {
        $pourc=$_GET['pays_send'];
        $sentence="SELECT * FROM CLIENTS where pays='%s'";
        $sql=sprintf($sentence,$pourc);
        $pays_send=mysqli_query($bdd,$sql); ?>
        <table width="1600" border="1" style="border-collapse: collapse">
        <?php
        while($donnees=mysqli_fetch_assoc($pays_send))
        {
            ?>
                <tr>
                    <th width="200px">
                        <a href="fiche.php?code=<?php echo $donnees['CODE_CLIENT'];?>"><?php echo $donnees['CODE_CLIENT'];?></a>
                    </th>
                    <th width="200px">
                        <?php echo $donnees['SOCIETE']; ?>
                    </th>
                    <th width="200px">
                        <?php echo $donnees['ADRESSE']; ?>
                    </th>
                    <th width="200px">
                        <?php echo $donnees['VILLE']; ?>
                    </th>
                    <th width="200px">
                        <?php echo $donnees['PAYS']; ?>
                    </th>
                    <th width="200px">
                        <a href="edit.php?modif=<?php echo $donnees['CODE_CLIENT']; ?>">Modifier</a>
                        <a href="index.php?alefa=<?php echo $donnees['CODE_CLIENT']; ?>">Supprimer</a>
                    </th>
                </tr>
       <?php } ?>
       </table> 
        <?php mysqli_free_result($pays_send);?>
    <?php }
?>

<?php
if(isset($_GET['get_mot'])==false&&isset($_GET['pays_send'])==false)
    { ?>
    <fieldset>
        <legend>
            <h1>
                Ajoutement de client(s)
            </h1>
        </legend>
        <a href="ajoutement.php">ajouter un nouveau client</a>
    </fieldset>
    <?php }
?>

        <?php
        if(isset($_GET['indice'])==true)
        {
            echo "i'm here";
            mysqli_query($bdd,"UPDATE CLIENTS SET CODE_CLIENT='".$_GET['CD']."', SOCIETE='".$_GET['S']."', ADRESSE='".$_GET['A']."', VILLE='".$_GET['V']."', CODE_POSTAL='".$_GET['CP']."', PAYS='".$_GET['P']."', TELEPHONE='".$_GET['T']."', FAX='".$_GET['F']."' WHERE CODE_CLIENT='".$_GET['CD']."'");            
        }

        if(isset($_GET['alefa'])==true)
        { ?>
            <h1>Voulez-vous supprimer le client avec le code client: <?php echo $_GET['alefa']; ?> ?</h1>
            <h1>
                <a href="edit.php?ed=<?php echo $_GET['alefa']; ?>">OUI</a>
            </h1>
            <h1>
                <a href="index.php">NON</a>
            </h1>
        <?php } 

        if(isset($_GET['code_client'])==true)
        {
            mysqli_query($bdd,"INSERT INTO CLIENTS VALUES ('".$_GET['code_client']."','".$_GET['societe']."','".$_GET['adresse']."','".$_GET['ville']."','','".$_GET['pays']."','','')");
        }
        
        if(isset($_GET['get_mot'])==false&&isset($_GET['pays_send'])==false)
        {
            $res=mysqli_query($bdd,"SELECT * FROM CLIENTS order by societe"); ?>
            <table width="1600" border="1" style="border-collapse: collapse">
            <tr>
                <th width="200px">
                    <h1>
                        Code clients
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Societe
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Adresse
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Ville
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Pays
                    </h1>
                </th>
                <th width="200px">
                    <h1>
                        Modification
                    </h1>
                </th>
            </tr>
            <?php  while($donnees=mysqli_fetch_assoc($res))
            {
                ?>
                    <tr>
                        <th width="200px">
                            <a href="fiche.php?code=<?php echo $donnees['CODE_CLIENT'];?>"><?php echo $donnees['CODE_CLIENT'];?></a>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['SOCIETE']; ?>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['ADRESSE']; ?>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['VILLE']; ?>
                        </th>
                        <th width="200px">
                            <?php echo $donnees['PAYS']; ?>
                        </th>
                        <th width="200px">
                            <a href="edit.php?modif=<?php echo $donnees['CODE_CLIENT']; ?>">Modifier</a>
                            <a href="index.php?alefa=<?php echo $donnees['CODE_CLIENT']; ?>">Supprimer</a>
                        </th>
                    </tr>
                
           <?php } ?>
           </table> 
            <?php mysqli_free_result($res);?>
        <?php } ?>
</body>
</html>