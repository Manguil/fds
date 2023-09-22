<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ticket commande</title>
</head>

<body>
    <form name='commande' method='get'>
        <h1>Commandes</h1> <br>
        <table>
            <tr>
                <th>Quantité</th>
                <th>Article</th>
                <th>Prix</th>
            </tr>
            <?php
            $total = 0;
            $prixArticle = array('marteau' => 10, 'tenaille' => 5, 'vis' => 5.2, 'clou' => 5.8, 'tournevis' => 7, 'ciseau' => 4, 'toile émeri' => 3);
            foreach (array_keys($prixArticle) as $value) {
                if (isset($_GET[$value])) {
                    if (isset($_GET["objet"]) && isset($_GET["n"])) {
                        if ($_GET["objet"] == $value) {
                            $n = $_GET["n"];
                            $article = $_GET["objet"];
                            $prix = $prixArticle[$article] * ($_GET[$value] + $n);
                            $total += $prix;
                            echo '<input type="hidden" name="' . $value . '" value="' . $_GET[$value] + $n . '">';
                            echo '<tr><td>' . $_GET[$value] + $n . '</td><td>' . $article . '</td><td>' . $prix . ' €</td></tr>';
                        } else {
                            $n = $_GET[$value];
                            if ($n > 0) {
                                $article = $value;
                                $prix = $prixArticle[$article] * $n;
                                $total += $prix;
                                echo '<tr><td>' . $n . '</td><td>' . $article . '</td><td>' . $prix . ' €</td></tr>';
                            };
                            echo '<input type="hidden" name="' . $value . '" value="' . $n . '">';
                        }
                    };
                } else {
                    echo '<input type="hidden" name="' . $value . '" value="0">';
                };
            }
            echo '<tr><td><th>TOTAL sans reduc</th></td><td>' . $total . ' €</td></tr>';
            if (isset($_GET["codeReduc"])) {
                $code = $_GET["codeReduc"];
                if ($code == "DIXPOURCENT") {
                    echo '<tr><td><th>TOTAL avec reduc</th></td><td>' . $total - ($total * (10 / 100)) . ' €</td></tr>';
                };
            };
            ?>
        </table>
        <label for="codeReduc">Rentrer un code promo : </label>
        <input type="text" name="codeReduc" value="<?php if (isset($_GET["codeReduc"])) {
                                                        echo $_GET["codeReduc"];
                                                    }; ?>">
        <hr>
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
        <input type="number" name="n" id="n">
        <button type="submit">Ajouter</button>

    </form>
</body>

</html>