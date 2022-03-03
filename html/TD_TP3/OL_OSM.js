$().ready(function () {
    $.getJSON("http://localhost:8888/types", function (listTypes) {
        nbBat = listTypes[1];
        listTypes = listTypes[0];
        console.log("liste de type de batiment : ", listTypes);
        console.log("nombre de batiment : ", nbBat);
        let html = "";
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
                if (numero == nbBat + 1) {
                    console.log(html);
                    $("#points_interet").append(html);
                    $("#points_interet").accordion({ collapsible: true, heightStyle: 'content' });
                    var map = new ol.Map({
                        target: 'map',
                        layers: [new ol.layer.Tile({ source: new ol.source.OSM() })],
                        view: new ol.View({
                            center: ol.proj.fromLonLat([3.876716, 43.61]),
                            zoom: 14
                        })
                    });
                    for (let i = 0 ; i < nbBat; i++) {
                        console.log(i);
                        console.log("ok");
                        let image = $("#markerProto").clone();
                        let marker = new ol.Overlay({
                            position: ol.proj.fromLonLat([pi.long, pi.lat]),
                            positioning: 'center-center',
                            element: document.getElementById(image)
                        }); // element fait r´ef´erence `a l’image
                        map.addOverlay(marker);
                    }
                }
            });
        }
    });
});