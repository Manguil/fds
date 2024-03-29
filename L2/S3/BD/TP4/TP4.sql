SELECT COUNT(*) FROM personne;
SELECT COUNT(*) FROM personne WHERE prenom IS NULL;
SELECT COUNT(*) FROM voiture GROUP BY Idproprio;
SELECT nom, prenom, SUM(prix) FROM personne, voiture WHERE personne.id = voiture.Idproprio GROUP BY Idproprio;
SELECT marque, AVG(prix) FROM voiture GROUP BY marque;
SELECT nom, prenom, COUNT(*) FROM personne, voiture WHERE personne.id = voiture.Idproprio AND prix > 20000 GROUP BY Idproprio;
SELECT nom, prenom, COUNT(*) FROM personne, voiture WHERE personne.id = voiture.Idproprio AND prix > 20000 GROUP BY Idproprio;
SELECT nom, prenom, SUM(prix) FROM personne, voiture WHERE personne.id = voiture.Idproprio GROUP BY Idproprio HAVING SUM(prix) > 50000;
SELECT Idproprio, YEAR(dateachat), SUM(prix) FROM voiture GROUP BY Idproprio, YEAR(dateachat);
SELECT nom, prenom, YEAR(dateachat), SUM(prix) FROM personne, voiture WHERE personne.id = voiture.Idproprio GROUP BY Idproprio, YEAR(dateachat);
//connect to mongoDB in python?