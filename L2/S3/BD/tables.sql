/* 
NE PAS MODIFIER LES LIGNES ENTRE ******
*******************************************************
*/
prompt "Suppression des relations"
BEGIN
EXECUTE IMMEDIATE 'DROP TABLE JOUER';
EXCEPTION
 WHEN OTHERS THEN
	IF SQLCODE != -942 THEN
	RAISE;
	END IF;
END;
/


BEGIN
EXECUTE IMMEDIATE 'DROP TABLE FILM';
EXCEPTION
 WHEN OTHERS THEN
	IF SQLCODE != -942 THEN
	RAISE;
	END IF;
END;
/

BEGIN
EXECUTE IMMEDIATE 'DROP TABLE REALISATEUR';
EXCEPTION
 WHEN OTHERS THEN
	IF SQLCODE != -942 THEN
	RAISE;
	END IF;
END;
/

BEGIN
EXECUTE IMMEDIATE 'DROP TABLE ACTEUR';
EXCEPTION
 WHEN OTHERS THEN
	IF SQLCODE != -942 THEN
	RAISE;
	END IF;
END;
/

BEGIN
EXECUTE IMMEDIATE 'DROP TABLE GENRE';
EXCEPTION
 WHEN OTHERS THEN
	IF SQLCODE != -942 THEN
	RAISE;
	END IF;
END;
/

/*
******************************************
*/

CREATE TABLE genre (
  idG INT,
  description VARCHAR(50) NOT NULL,
  PRIMARY KEY (idG)
);

CREATE TABLE acteur (
  idA INT,
  nom VARCHAR(100) NOT NULL,
  prenom VARCHAR(100) NOT NULL,
  nationalite VARCHAR(50) NOT NULL,
  PRIMARY KEY (idA)
);

CREATE TABLE realisateur (
  idR INT,
  nom VARCHAR(100) NOT NULL,
  prenom VARCHAR(100) NOT NULL,
  nationalite VARCHAR(50) NOT NULL,
  PRIMARY KEY (idR)
);

CREATE TABLE film (
  idF INT,
  titre VARCHAR(255) NOT NULL,
  annee INT NOT NULL,
  nbSpectateurs INT NOT NULL,
  idRealisateur INT REFERENCES realisateur(idR),
  idGenre INT REFERENCES genre(idG),
  PRIMARY KEY (idF) 
) ;

CREATE TABLE jouer (
  idActeur INT REFERENCES acteur(idA),
  idFilm INT REFERENCES Film(idF),
  salaire INT NOT NULL,
  PRIMARY KEY (idActeur,idFilm)
);


