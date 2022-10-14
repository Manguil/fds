CREATE TABLE genre (idG INT,description VARCHAR(50) NOT NULL); --erreur car pas de cle primaire primary key()
CREATE TABLE film (idF INT,titre VARCHAR(255) NOT NULL,annee INT NOT NULL,nbSpectateurs INT NOT NULL,idRealisateur INT,idGenre INT,PRIMARY KEY (idF)) ; --erreur car pas de cle etrangere avec references
CREATE TABLE jouer (idActeur INT REFERENCES acteur(idA),idFilm INT REFERENCES Film(idF),salaire INT NOT NULL,PRIMARY KEY (idActeur,idFilm)) ; --erreur car la cle primaire n'existe plus