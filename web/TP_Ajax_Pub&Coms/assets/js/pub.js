window.addEventListener("load", function() {
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
function load_pub()
{
    xhr.open("POST", "../inc/traitement/show_pub.php");
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send(`getAllPub=${localStorage.getItem('nom')}`);
    xhr.onreadystatechange  = function() 
    { 
        if(xhr.readyState  == 4)
        {
            if(xhr.status  == 200)
            {
                var pub=document.getElementById('pub');
                var retour = JSON.parse(xhr.responseText);
                var i=0;
                while(retour[i])
                {
                    var listItem = document.createElement('div');
                    listItem.class="dicom";
                    var input=document.createElement('input');
                    input.class="coms";
                    var sub=document.createElement('button');
                    sub.id="comsButt";
                    sub.innerHTML = 'commenter';
                    var p=document.createElement('p');
                    var c = document.createElement('div');
                    c.class="c";
                    var hr= document.createElement('hr');
                    listItem.textContent=retour[i]['TextePublication'];
                    p.appendChild(c);
                    p.appendChild(input);
                    p.appendChild(sub);
                    p.appendChild(hr);
                    listItem.appendChild(p);
                    pub.appendChild(listItem);
                    i++;
                }
            }
        }
    }; 
}
function insert()
{ 
    var pub=document.getElementById('publication');
    var textPub=pub.value;
    var nom = localStorage.getItem('nom');

    // Configurez la requête
    xhr.open("POST", "../inc/traitement/insert_publication.php");
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    // Les données envoyées sont ce que l'utilisateur a mis dans le formulaire
    xhr.send(`pub=${textPub}&&nom=${nom}`);
}

function insertComs()
{
    // var myInput= document.getElementByClass('coms');
    // var c= document.getElementByClass('c');
    // var comsDiv=document.createElement('div');
    // comsDiv.textContent=myInput.value;
    // c.appendChild(comsDiv);
    var Comments = document.querySelectorAll('.dicom');
    console.log(Comments.length);
    Comments.forEach(Comment => {
    {
        console.log("0");
        // var theComment = Comment.querySelector(".coms");
        // var goComment = Comment.querySelector(".comsButt");

        // goComment.addEventListener('click', () => {
        //     let num = i;
        //     console.log(num);
            // xhr.open("POST", "../../inc/traitement/insert_commentaire.php", true);
            // xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            // var nom=localStorage.getItem('nom');
            // if (theComment.value != "") {
            //     let data = theComment.value;
            //     xhr.send(`comment=${data}&&idPub=${num}&&nom=${nom}`);
            // }
            // return false;
        }});
    // });
}
function publier()
{
    var listItem = document.createElement('div');
    listItem.class="dicom";
    var res= document.getElementById('pub');
    var myInput= document.getElementById('publication');
    var input=document.createElement('input');
    input.class="coms";
    var sub=document.createElement('button');
    sub.id="comsButt";
    sub.innerHTML = 'commenter';
    var p=document.createElement('p');
    var c = document.createElement('div');
    c.class="c";
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
load_pub();
document.getElementById("publ").addEventListener("click",publier);
// document.getElementById("comsButt").addEventListener("click",insertComs);
insertComs();
});