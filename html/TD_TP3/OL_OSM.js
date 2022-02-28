$().ready(function () {
    $.getJSON("http://localhost:8888/types", function (listTypes) {
        nbBat = listTypes[1];
        listTypes = listTypes[0];
        console.log("liste de type de batiment : ",listTypes);
        console.log("nombre de batiment : ",nbBat);
        let html = "<div id=points_interet>";
        let numero = 0;
        for (let type of listTypes) {
            console.log("type : ", type);
            $.getJSON("http://localhost:8888/type/" + type, function (listBat) {
                console.log(type);
                html += "<h3>" + type + "</h3>" + "<div id=" + type + ">";

                for (elem of listBat) {
                    html += "<input type=checkbox name='" + numero + "'>" + elem["nom"] + "</input>";
                    numero++;
                }
                console.log(numero);

                html += "</div>";
                if (numero == nbBat) {
                    html += "</div>";
                    console.log("le code html est ", html);
                    $("#points_interet").append(html);
                }
            });
        }
    });
});

/**$().ready(function () {
    $.getJSON("http://localhost:8888/types", function (listTypes) {
        let nbTypes = 0;
        $.getJSON("http://localhost:8888/type/" + listTypes[nbTypes], function (listBat) {
            for (type of listTypes) {
                let html = "";
                let numero = 0;
                console.log(type);
                html += "<div id=points_interet> <h3>" + type + "</h3>" +
                    "<div id=" + type + ">";
                for (elem of listBat) {
                    html += "<input type=checkbox name='" + numero + "'>" + elem["nom"] + "</input>"
                    numero++;
                }
                console.log(html);
                $("#points_interet").append(html);
                nbTypes++;
                html += "</div>";
            }
        });
    });
}); */