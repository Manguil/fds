var express = require("express");
var fs = require('fs');
const { features } = require("process");
var app = express();
var nbBat = 0;


let pis = {};
let PI = JSON.parse(fs.readFileSync('OSM_Metropole_restauration_bar.json','utf8'));
for (elem of PI["features"]){
    pis[elem["properties"]["amenity"]] = []
}


for (elem of PI["features"]){
    let amenity = elem["properties"]["amenity"];
    nbBat ++;
    pis[amenity].push({nom:elem["properties"]["name"],long:elem["geometry"]["coordinates"][0],lat:elem["geometry"]["coordinates"][1]});
}
console.log("pis : ",pis);

app.listen(8888);

// Renvoi de la page HTML
app.get('/', function(request, response) {
    console.log('/');
    response.sendFile('OL_OSM.html', {root: __dirname});
});

// Renvoi des différents types d'établissements
app.get('/types', function(request, response) {
    console.log('/types');
    let types = [];
    for (let type in pis) types.push(type);
    response.setHeader("Content-type", "application/json");    
    response.end(JSON.stringify([types,nbBat]));
});

// Renvoi des établissements d'un type donné
app.get('/type/:type', function(request, response) {
    console.log("/type/"+request.params.type);
    response.setHeader("Content-type", "application/json");    
    response.end(JSON.stringify(pis[request.params.type]));
});

// Renvoi des autres ressources
app.get('/fichier/:fichier', function(request, response) {
    console.log('/fichier/'+request.params.fichier);
    response.sendFile(request.params.fichier, {root: __dirname});
});

