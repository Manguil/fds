SELECT titre from film, genre WHERE(idGenre = genre.idG) description = 'horreur' ORDER BY annee;
SELECT nom, prenom FROM acteur, jouer, film, genre WHERE(idA = idActeur) AND (idFilm = idF) AND (idGenre = idG) AND (nationalite = 'francais' AND description = 'drame' GROUP BY idActeur,nom,prenom ORDER BY (nom, prenom);
SELECT realisateur.nom, realisateur.prenom FROM realisateur, acteur, jouer, film WHERE((idA = idActeur) AND (idFilm = idF) AND (acteur.nom = 'Cotillard' and acteur.prenom = 'Marion') GROUP BY idActeur;
SELECT MIN(nbspectateurs), MAX(nbspectateurs), AVG(nbspectateurs) FROM film, genre WHERE(idG = idGenre) AND (description = 'policier');
SELECT SUM(nbspectateurs) FROM film, realisateur WHERE(idR = idRealisateur) AND (nom = 'Scorcesse' AND prenom = 'Martin');
SELECT SUM(nbspectateurs)*6 FROM film, realisateur WHERE(idRealisateur = idR) AND (annee = 2000 AND nationalite = 'francais')
SELECT COUNT(idA),nationalite FROM acteur GROUP BY nationalite;
SELECT COUNT(idF) FROM film, genre WHERE(idG = idGenre) GROUP BY description,idG;
SELECT COUNT(idF) FROM film GROUP BY idGenre;
SELECT nom, prenom, AVG(nbspectateurs), MAX(nbspectateurs) FROM film, realisateur WHERE(idR = idRealisateur) GROUP BY idR; --nom,prenom
SELECT (nom,prenom) FROM acteur, jouer WHERE (idA = idActeur) GROUP BY idA HAVING AVG(salaire)>1000000;
SELECT COUNT(idF) FROM film; --tp2-8
SELECT  MIN(year(annee)) FROM film;
SELECT MAX(nbspectateurs) FROM film GROUP BY annee;
SELECT COUNT(idF) FROM film WHERE year(annee) > 1990 GROUP BY annee;
SELECT COUNT(idF) FROM film WHERE nbspectateurs > 1000000 GROUP BY annee;