//Les codes ci dessous sont executé lors que la page est chargée
window.addEventListener("load", function ()
{            
    function sendData()
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
        // Liez l'objet FormData et l'élément form
        var formData = new FormData(form);      
        // Configurez la requête
        xhr.open("POST", "inc/traitement/formulaire.php");       
        // Les données envoyées sont ce que l'utilisateur a mis dans le formulaire
        xhr.send(formData);
        xhr.onreadystatechange = function()
        {
            if(xhr.readyState ==4)
            {
                if(xhr.status== 200)
                {
                    try
                    {
                        var retour= JSON.parse(xhr.responseText);
                        localStorage.setItem('nom',retour['nom']);
                        var email=document.getElementById("email");
                        var pwd=document.getElementById("pwd");
                        if(email.value==retour["email"]&&pwd.value==retour["pwd"])
                        {
                            window.location.href="./pages/publication.html";
                        }
                    }
                    catch(e)
                    {
                        console.log(xhr.response);
                        var msg= document.getElementById("text");
                        msg.textContent="diso le mot de passe na le email";
                    }
                }
                else
                {
                    document.dyn="Error code" + xhr.status;
                }
            }
        }
    }
    // Accédez à l'élément form …
    var form = document.getElementById("formulaire");      
    // … et prenez en charge l'événement submit.
    form.addEventListener("submit", function (event) {
    event.preventDefault(); // évite de faire le submit par défaut
    sendData();
});
});