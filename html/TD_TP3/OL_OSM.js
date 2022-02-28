$().ready(function () {
    $.getJSON("http://localhost:8888/types", function (listTypes) {
        let html = "";
        let numero = 0;
        for (type of listTypes) {
            $.getJSON("http://localhost:8888/type/" + type, function (listBat) {
                console.log(type);
                html += "<div id=points_interet> <h3>" + type + "</h3>" +
                    "<div id=" + type + ">";
                for (elem of listBat) {
                    html += "<input type=checkbox name='" + numero + "'>" + elem["nom"] + "</input>"
                    numero++;
                }
                console.log(html);
                $("#points_interet").append(html);
                //console.log(nbTypes);
                html+="</div>";
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