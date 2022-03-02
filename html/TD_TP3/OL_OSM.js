$().ready(function () {
    $.getJSON("http://localhost:8888/types", function (listTypes) {
        nbBat = listTypes[1];
        listTypes = listTypes[0];
        console.log("liste de type de batiment : ",listTypes);
        console.log("nombre de batiment : ",nbBat);
        let html = "<div id=points_interet>";
        let numero = 1;
        for (let type of listTypes) {
            console.log("type : ", type);
            $.getJSON("http://localhost:8888/type/" + type, function (listBat) {
                console.log(type);
                html += "<h3>" + type + "</h3>" + "<div id=" + "'" + type + "'" + ">";

                for (elem of listBat) {
                    html += "<input type=checkbox name='" + numero + "'>" + elem["nom"] + "</input>";
                    numero++;
                }

                html += "</div>";
                if (numero == nbBat+1) {
                    html += "</div>";
                    console.log("le code html est ", html);
                    $("#points_interet").append(html);
                    $("#points_interet").accordion();
                }
            });
        }
    });
});