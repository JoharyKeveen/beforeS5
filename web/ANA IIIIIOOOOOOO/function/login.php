<?php session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--<link rel="stylesheet" type="text/css" href="./style/style_login.css">-->
    <title>Document</title>
</head>
<body>

    

    <div class="container">
        

        <div class="login-container">

        <?php  if(isset($_SESSION['connected'])==false)
{ ?>

            <form action="traitement.php" method="post">
                <div class="image">
                        <img src="">
                </div>
                
                <h2>Login Account</h2>

                <div class="input-div">
                    <div class="i">
                        <i class="fas fa user"></i>
                    </div>

                    <div>
                        <h5>Username</h5>
                        <input class="input" type="text" name="name">
                    </div>
                </div>
                <div class="input-div">
                    <div class="i">
                        <i class="fas fa-lock"></i>
                    </div>

                    <div>
                        <h5>Password</h5>
                        <input class="input" type="password" name="pass">
                    </div>
                </div>

                
                <input type="submit" value="se connecter" name="connect">

            </form>

            <?php } ?>

<?php  if(!empty($_SESSION['connected']))
{ ?>

<h2>Bienvenue <?php echo $_SESSION['connected']; ?></h2>
<h4>Vous pouvez profiter pleinement de tous les options de MENABE</h4>

<form  method="post">
<input type="submit" value="deconnexion" name="disconnect">
</form>

<?php } ?>
        </div>
    </div>
    <script type="text/javascript" src="js/main."></script>
</body>
</html>

<?php
if(isset($_POST['connect']))
{
    header('location:traitement.php');
}

if(isset($_POST['disconnect']))
{
    
    session_destroy();
    

}
