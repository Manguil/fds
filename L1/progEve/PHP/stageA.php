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
        $user="e20210006359";$pass="Mangu_il_N34";
        try{
            $dbh = new PDO('mysql:host=mysql.etu.umontpellier.fr;
            dbname=e20210006359; charset=UTF8', $user, $pass,
            array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,));
        } catch(PDOException $e){
            echo $e->getMessage();
            die("Connexion impossible !");
        }
        $sql = 'SELECT * FROM etudiant, stagea';
        foreach($dbh->query($sql) as $row) {
            print($row['nom'] . "\t" . $row['sujet'] . "<br/>");
        }
    ?>
</body>
</html>