SELECT AVG(salaire), nom, prenom FROM acteur, jouer WHERE idActeur = idA GROUP BY idA, nom, prenom;
SELECT COUNT(*), nom, prenom FROM realisateur, film WHERE idRealisateur = idR  GROUP BY idR, nom, prenom;
SELECT nom, prenom FROM acteur, jouer WHERE idActeur = idA GROUP BY idA, nom, prenom HAVING (SELECT AVG(salaire) FROM jouer)<MAX(salaire);
SELECT titre FROM film WHERE nbspectateurs >= (SELECT AVG(nbspectateurs) FROM film);
SELECT nom, prenom FROM realisateur, film WHERE idR = idRealisateur GROUP BY idR, nom, prenom HAVING idR NOT IN (SELECT idRealisateur FROM film, genre WHERE idG = idGenre AND description <> 'policier');
SELECT nom, prenom FROM realisateur, film WHERE idR = idRealisateur GROUP BY idR, nom, prenom HAVING COUNT(*) >= ALL(SELECT COUNT(*) FROM film GROUP BY idRealisateur);
SELECT nom, prenom FROM acteur, jouer WHERE idActeur=idA AND salaire = (SELECT MAX(salaire) FROM jouer) GROUP BY nom,prenom,idA ;
SELECT nom, prenom FROM film, realisateur WHEREidRealisateur=idR GROUP BY idR,nom,prenom HAVINGMIN(nbspectateurs)>(SELECT AVG(nbspectateurs) FROM film);