EXERCICE 1:
SELECT nom, prenom FROM personne WHEN idP NOT IN (SELECT idProp FROM véhicule) ;
SELECT nom, prenom FROM personne WHEN idP NOT IN (SELECT idProp FROM véhicule WHEN prix <= 20 000);
SELECT nom, prenom FROM personne WHEN idP NOT IN (SELECT idProp FROM voiture WHEN prix <> (SELECT MAX(prix) FROM voiture));
SELECT nom, prenom FROM personne WHEN idP NOT IN (SELECT idProp FROM voiture WHEN COUNT(*) <> MAX(SELECT COUNT(*) FROM voiture GROUP BY idProp ) );

EXERCICE 2:
SELECT numAvion FROM avion WHEN capacité = (SELECT MIN(capacité) FROM avion );
SELECT nom FROM avion WHEN capacité > (SELECT AVG(capacité) FROM avion ); 
SELECT numPilote FROM avion WHEN numPilote NOT IN (SELECT vol.numPilote FROM pilote, vol WHEN vol.numPilote = pilote.numPilote) );
SELECT numPilote FROM pilote WHERE numPilote NOT IN (SELECT numPilote FROM vol WHERE COUNT(numPilote) > MAX(SELECT COUNT(*)) FROM vol GROUP BY numPilote) );
