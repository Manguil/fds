<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ticket commande</title>
</head>
<body>
    <h1>Commande</h1> <br>
    <table>
        <tr>
            <th>Quantité</th>
            <th>Article</th>
            <th>Prix</th>
        </tr>
        <?php
            $prixArticle=array('marteau'=>10, 'tenaille'=>5, 'vis'=>5.2, 'clou'=>5.8,'tournevis'=>7, 'ciseau'=>4, 'toile émeri'=>3);
            if (!empty($_GET["objet"]) && !empty($_GET["n"])){
                var_dump($_GET["article"]);
                if (!empty($_GET["article"])){
                    $article = $_GET["article"][0];
                    $n = $_GET["article"][1];
                    $prix = $prixArticle[$article]*$n;
                    echo "<tr><td>$n</td><td>$article</td><td>$prix €</td></tr>";
                }
                else echo "non";
                $n = $_GET["n"];
                $article = $_GET["objet"];
                $prix = $prixArticle[$article]*$n;   
                echo "<tr><td>$n</td><td>$article</td><td>$prix €</td></tr>";
                echo "<input type=text name=article value=array($article,$n)";
            };
        ?>
    </table>
    <hr>
    <form name='commande' method='get'>
        <p>Nouvel article :</p>
        <select name="objet" id="objet">
            <option value="marteau">marteau</option>
            <option value="tenaille">tenaille</option>
            <option value="vis">vis</option>
            <option value="clou">clou</option>
            <option value="tournevis">tournevis</option>
            <option value="ciseau">ciseau</option>
            <option value="toile émeri">toile émeri</option>
        </select>
        <input type="number" name="n" id="n" >
        <button type="submit">Ajouter</button>
        
    </form>
</body>
</html>