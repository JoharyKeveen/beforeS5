<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/login.css">
    <title>Login</title>
</head>

<body>
        <?php
            if(!isset($_GET['create']))
            { ?>
                <div class="box">
                    <form action="Login/index" method="post">
                        <h2>Log In</h2>
                        <div class="inputBox">
                            <input type="text" required="" name="name">
                            <span>Username</span>
                            <i></i>
                        </div>
                        <div class="inputBox">
                            <input type="password" required="" name="mdp">
                            <span>Password</span>
                            <i></i>
                        </div>
                        <div class="links">
                            <p>Don't have an account?</p>
                            <a href="index.php?create">Sign In</a>
                        </div>
                        <input type="submit" value="Login">
                    </form>
                <div>
            <?php }
            else
            { ?>
                <div class="box" style="height: 500px;">
                    <form action="Login/insert" method="post">
                        <h2>Sign In</h2>
                        <div class="inputBox">
                            <input type="text" required="" name="name">
                            <span>Username</span>
                            <i></i>
                        </div>
                        <div class="inputBox">
                            <input type="text" required="" name="email">
                            <span>Email</span>
                            <i></i>
                        </div>
                        <div class="inputBox">
                            <input type="password" required="" name="mdp">
                            <span>Password</span>
                            <i></i>
                        </div>
                        <div class="links">
                            <p>Have an account?</p>
                            <a href="index.php?log">Log In</a>
                        </div>
                        <input type="submit" value="Signin">
                    </form>
                <div>
            <?php }
        ?>
</body>

</html>