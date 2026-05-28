<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<script type="text/javascript">
    function sub() 
    {
        var xhr; 
        try {  xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
        catch (e) 
        {
            try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
            catch (e2) 
            {
            try {  xhr = new XMLHttpRequest();  }
            catch (e3) {  xhr = false;   }
            }
        }

        // Configurez la requête
        xhr.open("POST", "inc/traitement/formulaire.php");

        var Form= new formData(this);
        // Les données envoyées sont ce que l'utilisateur a mis dans le formulaire
        xhr.send(Form);


        xhr.onreadystatechange = function()
        {
            if(xhr.readyState ==4)
            {
                if(xhr.status== 200)
                {
                    try
                    {
                        var retour= JSON.parse(xhr.responseText);
                        var name=document.getElementById("name");
                        var pwd=document.getElementById("pwd");
                        if(name.value==retour["email"]&&pwd.value==retour["pwd"])
                        {
                            window.location.href="./pages/publication.php";
                        }
                    }
                    catch(e)
                    {
                        var msg= document.getElementById("text");
                        msg.textContent="diso le mot de passe na le email";
                    }

                }
                else{
                    document.dyn="Error code" + xhr.status;
                }
            }
        }
}

</script>

</head>
<body>
    <form name="Formulaire">
        <p>
            <h3>
                Nom d'utilisateur:
                <INPUT type="text" name="name" id="name" value="" placeholder="Nom utilisateur"/>
            </h3>
        </p>
        <p>
            <h3>
                Password:
                <INPUT type="text" name="pwd" id="pwd" value="" placeholder="Password"/>
            </h3>
        </p>
        <p>
            <input type="submit" value="go" onclick="sub()">
        </p>
    </form>
    <div id="text" style="color: red;"></div>
</body>
</html>