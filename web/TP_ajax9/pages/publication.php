<?php
    include('../inc/function/function.php');
    session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<script>
    window.addEventListener("load", function() {
    function insert()
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
        // Liez l'objet FormData et l'élément formle
        let form = document.querySelector("#form");

        var formData = new FormData(form);

        // Configurez la requête
        xhr.open("POST", "../inc/traitement/insert_publication.php");

        // Les données envoyées sont ce que l'utilisateur a mis dans le formulaire
        xhr.send(formData);
    }
    // function coms()
    // {
    //     var myInput= document.getElementById('coms');
    //     var c= document.getElementById('c');
    //     var comsDiv=document.createElement('div');
    //     comsDiv.textContent=myInput.value;
    //     c.appendChild(comsDiv);
    // }
    function publier()
    {
        var listItem = document.createElement('div');
        var res= document.getElementById('pub');
        var myInput= document.getElementById('publication');
        var input=document.createElement('input');
        input.id="coms";
        var sub=document.createElement('button');
        sub.id="comsButt";
        sub.innerHTML = 'commenter';
        var p=document.createElement('p');
        var c = document.createElement('div');
        c.id="c";
        var hr= document.createElement('hr');
        listItem.textContent=myInput.value;
        p.appendChild(c);
        p.appendChild(input);
        p.appendChild(sub);
        p.appendChild(hr);
        listItem.appendChild(p);

        res.appendChild(listItem);
    }
document.getElementById("publ").addEventListener("click",insert);
document.getElementById("publ").addEventListener("click",publier);
// document.getElementById("comsButt").addEventListener("click",coms);
    });
</script>

<body>
    <h1>Salama Tompoko,eto izahay dia manasa anao hanoratra izay ao am-ponao</h1>
    <form id="form">
        <input type="text" name="publication" id="publication" style="width:30%;height:100px;">
        <p>
            <input type="button" id="publ" value="publier">
        </p>
    </form>
    <?php
        $tab=show_pub();
        for($i=0;$i<count($tab);$i++)
        {
            ?>
                <div>
                    <p>
                        <?php echo $tab[$i]['TextePublication'];?>
                    </p>
                    <p id="c"></p>
                    <input type="text" id="coms"> <button id="comsButt">commenter</button>
                </div>
                <hr>
            <?php
        }
    ?>
    <div id="pub"></div>
</body>
</html>