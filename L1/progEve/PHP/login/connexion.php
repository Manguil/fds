<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <form method="post">
    <?php 
    session_start();
    $usersLogin = ["Manguil" => "Mangu_il_N34", "ohhnyx" =>"CMRRT"];
    if(isset($_POST["user"])){
        $_SESSION["user"] = $_POST["user"];
        $_SESSION["mdp"] = $_POST["mdp"];
        foreach (array_keys($usersLogin) as $users){
            echo ''.$users.':'.$_SESSION["user"].'<br>';
            echo ''.$_SESSION["mdp"].':'.$usersLogin[$users].'<br>';
            if ($_SESSION["user"] == $users){
                if ($_SESSION["mdp"] == $usersLogin[$users]){
                    header('Location: http://localhost:8888/index.php?'.$users.'');
                    exit;
                } else {
                    header('Location: http://localhost:8888/index.php?mdp');
                    exit;
                };
            } else {
                header('Location: http://localhost:8888/index.php?id');
                exit;
            };
        }
    } else {
        echo "<h1>Connexion</h1>";
    }
    ?>
    <label for="user">Identifiant : </label>
    <input type="text" name="user" required> <br> <br>
    <label for="mdp">Mot de passe : </label>
    <input type="password" name="mdp" required>
    <input type="submit" value="Connexion">
    </form>
</body>
</html>