EXERCICE 1:
SELECT titre FROM film WHERE nbspectateurs > (SELECT AVG(nbspectateurs) FROM film);
SELECT nom,prenom FROM realisateur,film WHERE idR = idRealisateur AND nbspectateurs > (SELECT AVG(nbspectateurs) FROM film);
SELECT nom,prenom FROM acteur,jouer,film WHERE idA = idActeur AND idF = idFilm AND nbspectateurs = (SELECT MAX(nbspectateurs) FROM film);
SELECT DISTINCT nom,prenom FROM acteur,jouer WHERE idA NOT IN (SELECT idActeur FROM jouer);
SELECT DISTINCT description FROM genre WHERE idG NOT IN (SELECT idGenre FROM film);
SELECT DISTINCT nom,prenom FROM realisateur WHERE idR NOT IN (SELECT idRealisateur FROM film, realisateur WHERE annee > 2002 AND idR = idRealisateur);
SELECT description FROM genre WHERE idG NOT IN (SELECT idGenre FROM film WHERE nbspectateurs < 50000);

EXERCICE 2:
