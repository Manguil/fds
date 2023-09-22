<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Liste d'étudiants</h1>
    <table>
        <tr>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Statut</th>
            <th>groupe</th>
            <th>Email</th>
            <th>Option</th>
            <th>NumStage</th>
        </tr>
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
    /*foreach($dbh->query('SELECT * from etudiant') as $row) {
        print("<tr><td>". $row['nom'] ."</td><td>". $row['prenom'] ."</td><td>". $row['tatut'] ."</td><td>". $row['groupe'] ."</td><td>". $row['email'] ."</td><td>". $row['opt'] ."</td><td>". $row['numStageA'] ."</td></tr>");
    }*/
    foreach($dbh->query('SELECT * from etudiant') as $row) {
        print("<tr>");
        foreach(array_unique($row) as $col){
            print("<td>". $col ."</td>");
        }
        print("</tr>");
    }
    ?>
    </table>
</body>
</html>