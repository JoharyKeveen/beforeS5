<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="traitement.php" method="get">
        <fieldset>
            <legend>
                Devinette
            </legend>
            <label for="id">Entrer un nombre entre 0 et 100</label>
            <input type="number" name="id"required min="0" max="100">
            <p>
                <input type="submit" name="submit" value="essayer">
            </p>
        <?php
        session_start();
        if(isset($_GET['petit'])==true||isset($_GET['grand'])==true)
        {
            $isa=$_SESSION['isa'];
        }
        if(isset($_GET['petit'])==true)
        {
            $isa++;
        ?>
        <h3>plus petit</h3>
        <?php }
        if(isset($_GET['grand'])==true)
        {
            $isa++; 
        ?>
        <h3>plus grand</h3>
        <?php }
        if(isset($_GET['egal'])==true)
        {
            $isa++; 
        ?>
        <h3>gagne en <?php echo $_SESSION['submit']; ?> essaies!!!!!!!!!!!</h3>
        <?php }
        ?>
        </fieldset>
    </form>
</body>
</html>