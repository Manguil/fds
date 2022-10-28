DROP TABLE voiture;
DROP TABLE personne;

CREATE TABLE personne (
    Id VARCHAR(5),
    Nom VARCHAR(20),
    Prenom VARCHAR(20),
    PRIMARY KEY(Id)
);

CREATE TABLE voiture (
    Immatriculation CHAR(8),
    Marque VARCHAR(15),
    Anne INT,
    Prix INT CHECK(Prix>0),
    Idproprio VARCHAR(5) REFERENCES personne(Id),
    PRIMARY KEY(Immatriculation)
);


INSERT INTO personne VALUES('Id01','Martin','Paul');
INSERT INTO personne VALUES('Id02','Duval',NULL);

INSERT INTO voiture VALUES('1111AA01','Peugeot',1997,16000,'Id01');
INSERT INTO voiture VALUES('2222BB02','Peugeot',2000,41200,'Id01');
INSERT INTO voiture VALUES('4444DD13','Fiat',1995,30300,'Id02');