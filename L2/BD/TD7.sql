EXERCICE 1:
SELECT nom, prenom FROM personne WHERE idP NOT IN (SELECT idProp FROM véhicule) ;

SELECT nom, prenom FROM personne WHERE idP NOT IN (SELECT idProp FROM véhicule WHERE prix > 20 000);

SELECT nom, prenom FROM personne WHERE idP NOT IN (SELECT idProp FROM voiture WHERE MAX(prix) <> (SELECT MAX(prix) FROM voiture));
SELECT nom, prenom FROM personne,voiture WHERE idP = idProp GROUP BY idP, nom, prenom HAVING MAX(prix) == (SELECT MAX(prix) FROM voiture);

SELECT nom, prenom FROM personne WHERE idP NOT IN (SELECT idProp FROM voiture WHERE COUNT(*) <> MAX(SELECT COUNT(*) FROM voiture GROUP BY idProp ) );
SELECT nom, prenom FROM personne, voiture WHERE idP = idProp GROUP BY idP, nom, prenom HAVING COUNT(*) >= ALL(SELECT COUNT(*) FROM voiture GROUP BY idProp );

EXERCICE 2:
SELECT numAvion FROM avion WHERE capacité = (SELECT MIN(capacité) FROM avion );

SELECT DISTINCT nom FROM avion WHERE capacité > (SELECT AVG(capacité) FROM avion );

SELECT numPilote FROM pilote WHERE numPilote NOT IN (SELECT numPilote FROM pilote);

SELECT numPilote FROM pilote WHERE numPilote NOT IN (SELECT numPilote FROM vol WHERE COUNT(numPilote) > MAX(SELECT COUNT(*)) FROM vol GROUP BY numPilote);
SELECT numPilote FROM vol GROUP BY numPilote HAVING COUNT(*) >= ALL(SELECT COUNT(*) FROM vol GROUP BY numPilote);
