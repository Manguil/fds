var largeur;
var hauteur;
var pos = 0
var vue = false

function zoom(img){
    largeur=img.style.width;
    hauteur=img.style.height;
    img.style.width="auto";
    img.style.height="auto";
}

function dezoom(img){
    img.style.width=largeur;
    img.style.height=hauteur;
}

function carrousel(img){
    if (pos==5) {
        pos = 0;
    }
    else {
        pos++;
    }
    afficherCocktails()
    img.src="http://localhost:8888/img/"+pos;
}

/*
function afficherCocktails_v2(){
        $.getJSON("http://localhost:8888/cocktails", function(data) 
        {
            $("#listeCocktails").empty(); 
            let html = "";
            $.each(data, function(index, objet) 
                { 
                    for(let i of objet.amateurs)
                    {
                        if (i==photo)
                        {
                            
                            html += "<li>"+objet.nom+"</li>";
                        }
                
                    }
                });
        $("#listeCocktails").append(html);
        });
}
*/

function afficherCocktails() {
    if (!vue){
        vue = true
    $.getJSON("http://localhost:8888/cocktails/"+pos, function(data) {
        $("#listeCocktails").empty();
        let html = "";
        $.each(data, function(index,objet) { html += "<li>"+objet+"</li>"; });
    $("#listeCocktails").append(html);
    });
    }
    else{
        vue = false
        $("#listeCocktails").empty();
    }
}