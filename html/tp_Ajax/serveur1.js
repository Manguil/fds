var express = require("express");
var fs = require('fs');
var app = express();
var liste_acteurs = ["Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig"];
let texte = fs.readFileSync('cocktails.json','utf8');
let data = JSON.parse(texte);

app.listen(8888);
app.get('/', function(request, response) {
    response.sendFile('CV_James_AJAX.html', {root: __dirname});
});



app.get('/cocktails/:pos_img', function(request, response) {
    cocktails = [];
    for (pos in data){
        for (am of data[pos].amateurs){
            if (am == liste_acteurs[request.params.pos_img]){
                cocktails.push(data[pos].nom);
            }
        }
    }
    console.log("envoi de "+cocktails);   
    response.end(JSON.stringify(cocktails));    
});


app.get('/fichier/:nomFichier', function(request, response) {
    console.log("envoi de "+request.params.nomFichier);
    response.sendFile(request.params.nomFichier, {root: __dirname});    
});

app.get('/img/:nb', function(request, response) {
    console.log("envoi de "+liste_acteurs[request.params.nb]+".jpg");
    response.sendFile(liste_acteurs[request.params.nb]+".jpg", {root: __dirname});    
});