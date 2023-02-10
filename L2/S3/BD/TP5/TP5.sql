CREATE TABLE laboratoire (
    id INT,
    nom VARCHAR(10),
    addresse VARCHAR(10),
    PRIMARY KEY (id)
);

CREATE TABLE medicament (
    code INT,
    libelle VARCHAR(10),
    addresse VARCHAR(10),
    idLabo VARCHAR(10) REFERENCES laboratoire(id),
    PRIMARY KEY (code)
);

CREATE TABLE mutuelle (
    id INT,
    nom VARCHAR(10),
    addresse VARCHAR(10),
    PRIMARY KEY (id)
);

CREATE TABLE patient (
    numSS INT,
    nom VARCHAR(10),
    prenom VARCHAR(10),
    PRIMARY KEY (numSS)
);

CREATE TABLE consultation (
    num INT,
    annee DATE,
    addresse VARCHAR(10),
    numSSPat INT REFERENCES patient(numSS),
    idMut INT REFERENCES mutuelle(id),
    PRIMARY KEY (num)
);

CREATE TABLE prescrit (
    idMed INT REFERENCES medicament(code),
    idC INT REFERENCES consultation(id),
    PRIMARY KEY (idMut,idC)
);

CREATE TABLE rembourse (
    annee DATE,
    numSSPat INT REFERENCES patient(numSS),
    idMut INT REFERENCES mutuelle(id),
    idC INT REFERENCES consultation(num),
    PRIMARY KEY (numSSPat,idMut,idC)
);

CREATE TABLE salle (
    num INT,
    idMut INT REFERENCES mutuelle(id),
    PRIMARY KEY (num)
);