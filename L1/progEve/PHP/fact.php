<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>puissance</title>
</head>
<body>
    <form name='puissance   ' method='get'>
        <input type="number" name="n" id="n" >
        <button type="submit">Calculer</button>
        <br>
        <?php 
            function fact(int $nb)
            {
                if ($nb == 0) return 1;
                return ($nb*fact($nb-1));
            };
            if (!empty($_GET["n"])){
                $nb = $_GET["n"];
                $res = fact($nb);
                echo "$nb! est égale à $res";
            }
            else echo "Saisie incorecte";
        ?>
    </form>
</body>
</html>