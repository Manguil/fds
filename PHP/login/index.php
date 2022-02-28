<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    session_start();
    if (isset($_SERVER['QUERY_STRING'])){
        $msg = $_SERVER['QUERY_STRING'];
        if ($msg == $_SESSION["user"]) {
            echo '<div><a href="http://localhost:8888/deconnexion.php">Déconnexion</a><br>Bonjour '.$msg.' !</div>';
        }
        elseif ($msg == "id"){
            echo '<div><a href="http://localhost:8888/connexion.php">Connexion</a><br>Identifiant incorrect</div>'; 
        }
        elseif ($msg == "mdp"){
            echo '<div><a href="http://localhost:8888/connexion.php">Connexion</a><br>mot de passe incorrect</div>'; 
        };
    }
    
    ?>
</body>
</html>

