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
        <input type="number" name="exp" id="exp">
        <button type="submit">Calculer</button>
        <br>
        <?php 
            if (!empty($_GET["n"]) && !empty($_GET["exp"])){
                $nb = $_GET["n"];
                $exposant = $_GET["exp"];
                $res = $nb**$exposant;
                echo "$nb exposant $exposant est égale à $res";
            }
            else echo "Saisie incorecte";
        ?>
    </form>
</body>
</html>