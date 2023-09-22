var largeur;
var hauteur;
var liste_acteurs = ["Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig"];
var pos = 0
var cocktails = [{'nom':'VM','amateurs':['Connery', 'Lazenby', 'Moore', 'Dalton', 'Brosnan', 'Craig']},
 {'nom':'Vesper','amateurs':['Craig']},
 {'nom':'Collins','amateurs':['Connery']},   
 {'nom':'Mint J','amateurs':['Connery']},
 {'nom':'The Mac', 'amateurs':['Craig']}
];

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
    if (pos==liste_acteurs.length -1) {
        pos = 0;
    }
    else {
        pos++;
    }
    img.src=liste_acteurs[pos]+".jpg";
}

function afficherCocktails(){
    for (let i = 0; i < cocktails.length; i++) {
        $("#listeCocktails").append("<li>"+cocktails[i]['nom']+"</li>");
    }
}

function supprimerCocktails(){
    for (let i = 0; i < cocktails.length; i++) {
        $("#listeCocktails").remove("<li>"+cocktails[i]['nom']+"</li>");
    }
}