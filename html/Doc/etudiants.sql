--
-- Base de données :  `mmeynard`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `nom` varchar(20) NOT NULL DEFAULT '',
  `prenom` varchar(20) NOT NULL DEFAULT '',
  `statut` char(2) NOT NULL DEFAULT 'FI',
  `groupe` tinyint(1) NOT NULL DEFAULT '0',
  `email` varchar(20) NOT NULL DEFAULT '',
  `opt` char(1) DEFAULT 'B',
  `numStageA` tinyint(2) unsigned DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`nom`, `prenom`, `statut`, `groupe`, `email`, `opt`, `numStageA`) VALUES
('BARTHEL', 'Marie Pierre', 'FI', 1, 'mpbarthe', 'L', 4),
('BEGNIS', 'Hélène', 'FI', 1, 'hbegnis', 'C', 16),
('BURRONI', 'Florent', 'FP', 2, 'fburroni', 'S', 5),
('CLAIR / TRABBIA', 'Séverine', 'FP', 2, 'sclair', 'W', 14),
('D AGATA', 'Richard', 'FP', 1, 'rdagata', 'B', 4),
('DELCROIX', 'Ludovic', 'FP', 1, 'ldelcroi', 'C', 4),
('DELEURY', 'Emeline', 'FI', 1, 'edeleury', 'B', 3),
('DEPAUL / BELLIER', 'Frédérique', 'FP', 1, 'fdepaul', 'W', 14),
('ESPIAU', 'Christophe', 'FP', 1, 'cespiau', 'W', 14),
('ETONO / MALANDA', 'Francine', 'FP', 1, 'fetono', 'S', 1),
('FELL', 'Laurent', 'FI', 1, 'lfell', 'S', 1),
('GAFFET', 'Patrick', 'FP', 1, 'pgaffet', 'W', 10),
('GARCIA', 'Carlos', 'FI', 1, 'cagarcia', 'C', 9),
('GERBAUD', 'Rémi', 'FI', 1, 'rgerbaud', 'C', 3),
('GLAUZY', 'Julien', 'FI', 1, 'jglauzy', 'W', 7),
('GOUAT', 'Isabelle', 'FI', 1, 'igouat', 'L', 17),
('GOURDON', 'Isabelle', 'FP', 1, 'igourdon', 'B', 17),
('GROUARD/ASTRUC', 'Nathalie', 'FP', 1, 'ngrouard', 'W', 19),
('GUILLAUME', 'Julien', 'FP', 1, 'juguilla', 'L', 6),
('GUITARD', 'Brice', 'FI', 2, 'bguitard', 'W', 15),
('HAET', 'Franck', 'FI', 1, 'fhaet', NULL, NULL),
('HERIZI', 'Abderraouf', 'FP', 1, 'aherizi', 'B', 19),
('JERIER', 'Philippe', 'FI', 1, 'pjerier', 'C', 9),
('JOTTRAS', 'Pierre', 'FI', 1, 'pjottras', 'S', 17),
('KHATTOU', 'Zara', 'FI', 1, 'zkhattou', NULL, NULL),
('LANAVE', 'Eric', 'FP', 1, 'elanave', 'W', 10),
('LAVEISSIERE', 'Eric', 'FP', 2, 'elaveiss', 'S', 16),
('MAILLE', 'Laurent', 'FI', 2, 'lmaille', 'C', 15),
('MARLHENS', 'Françoise', 'FP', 2, 'fmarlhen', 'B', 4),
('MENGOME ATOME', 'Nathalie', 'FP', 1, 'nmengome', 'L', 21),
('MESSIN', 'Eric', 'FP', 2, 'emessin', 'S', 5),
('MILCENT', 'Jean Pascal', 'FI', 2, 'jpmilcen', 'S', 18),
('MOREAU', 'Gilles', 'FP', 2, 'gmoreau', 'W', 5),
('MOREAU', 'Violaine', 'FI', 2, 'vmoreau', 'B', 21),
('MOYROUD', 'Nicolas', 'FI', 2, 'nmoyroud', 'B', 17),
('NAVARRO', 'Alexandrine', 'FI', 2, 'anavarro', 'L', 16),
('NGUYEN', 'Laure', 'FI', 2, 'lnguyen', 'S', 1),
('NOUGAREDE', 'Romain', 'FP', 2, 'rnougare', 'B', 21),
('PAILLARD', 'Mathieu', 'FI', 2, 'mpaillar', 'C', 3),
('PLAGNOL', 'Cédric', 'FI', 2, 'ceplagno', 'S', 18),
('POTHIN', 'Bertrand', 'FI', 2, 'bpothin', 'C', 15),
('RAYMOND', 'Bertrand', 'FI', 2, 'beraymon', 'L', 6),
('RODRIGUEZ', 'Pascal', 'FP', 2, 'prodrigu', 'B', 5),
('SCATENA', 'Catherine', 'FP', 2, 'cscatena', 'W', 16),
('SOLER', 'Yannick', 'FI', 1, 'ysoler', 'S', 8),
('TAILLET', 'Lisa', 'FI', 1, 'ltaillet', 'B', 18),
('TOGNA', 'Corinne', 'FP', 2, 'ctogna', 'S', 8),
('TORRE', 'Laetitia', 'FI', 1, 'ltorre', 'W', 9),
('TRANCHANT', 'Christine', 'FI', 2, 'ctrancha', 'B', 3),
('VERMEULEN', 'Styn', 'FI', 2, 'svermeul', 'L', 7);

-- --------------------------------------------------------

--
-- Structure de la table `options`
--

CREATE TABLE IF NOT EXISTS `options` (
  `code` char(1) NOT NULL DEFAULT '',
  `nom` varchar(30) NOT NULL DEFAULT '',
  `resp` varchar(30) NOT NULL DEFAULT '',
  `email` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `options`
--

INSERT INTO `options` (`code`, `nom`, `resp`, `email`) VALUES
('B', 'Bio-Informatique', 'Vincent Berry', 'vberry@lirmm.fr'),
('C', 'Chimie', 'Michel Meynard', 'meynard@lirmm.fr'),
('L', 'Langue naturelle', 'Mathieu Lafourcade', 'lafourca@lirmm.fr'),
('S', 'Syst. d''Info. Géo.', 'Thérèse Libourel', 'libourel@lirmm.fr'),
('W', 'Web et BD', 'Jean-François Vilarem', 'vilarem@lirmm.fr');

-- --------------------------------------------------------

--
-- Structure de la table `stageA`
--

CREATE TABLE IF NOT EXISTS `stageA` (
  `numStageA` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `sujet` varchar(255) NOT NULL DEFAULT '',
  `entreprise` varchar(50) NOT NULL DEFAULT '',
  `lieu` varchar(150) NOT NULL DEFAULT '',
  `respEnt` varchar(150) NOT NULL DEFAULT '',
  `respPeda` varchar(150) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `stageA`
--

INSERT INTO `stageA` (`numStageA`, `sujet`, `entreprise`, `lieu`, `respEnt`, `respPeda`) VALUES
(1, 'mise en oeuvre, dvt d''un SIE (Syst d''Info sur l''Environnement) - observatoire de l''environnement du TGV méditerrannée', 'BRL Ingénierie', 'NIMES', 'Jean Michel SIONNEAU', 'T. Libourel'),
(3, 'construction d''une BD pour la gestion-classement-étiquetage de l''ensemble des OGM réalisés en labo', 'CIRAD BIOTROP AMIS', 'TA 40/03 av Agropolis 34398 Montpellier Cedex', 'Thierry LEGAVRE tèl : 04 67 61 44 08', 'M. Meynard'),
(4, 'informatisation du labo PATHOTROP', 'CIRAD EMVT', 'Campus International Baillarguet 34398 Montpellier', 'F. THIAUCOURT tèl : 04 67 59 37 23', 'V. Prince'),
(5, '(2) analyse des procèdures pour télémaintenance, mise à jour de bornes interactives à distance en accés complet', 'DIGIDOC', '10 av du Vieux Cimetière 34500 BEZIERS', 'Benjamin GRASSET tèl : 04 67 62 10 10', 'C. Zurbach'),
(6, 'utilisation de XML dans l''application IMGT/LIGM-DB', 'IMGT', '141 rue de la  Cardonille 34095 Montpellier cedex', 'Denys CHAUME 04 99 61 99 09', 'V. Prince'),
(7, 'compatibilité entre les modèles conceptuels de données spécifiques aux approches par les processus bio-physiques et par les organisations des activités humaines', 'INRA', '2 place Viala 34060 Montpellier cedex 2', 'Sylvie LARDON tèl : 04 99 61 25 13', 'M. Sala'),
(8, 'procedure d''analyse et de choix d''un outil de messagerie et de gestion electronique de documents. Environnement Windows NT. Documents nombreux et variés...', 'Mairie de Castelnau le Lez', '2 rue de la Crouzette BP 67 43172 Castelnau le Lez', 'Véronique JEANJEAN tèl : 04 67 14 27 16', 'M. Meynard'),
(9, 'etude des problemes de securite informatique lie a l''ouverture de la mairie sur internet, analyse d''un site web de la mairie (internet/intranet/extranet ?)', 'Mairie de Castelnau le Lez', '2 rue de la Crouzette BP 67 43172 Castelnau le Lez', 'Véronique JEANJEAN tèl : 04 67 14 27 16', 'M. Meynard'),
(10, '(2) définir et mettre en place le syst d''info entre la direction commerciale et le direction du service client. Définir l''ontologie en vue d''installer un syst de gestion documentaire utilisant des bases de connaissance', 'NEMAUSIC', '151 rue Gilles Roberval 30900 Nîmes', 'Patrick REBOUX tèl : 04 66 28 78 78', 'J. Escojido'),
(14, 'gestion des contrôles de dépassement : étudier la réalisation d''une "boite noire" qui, appelée par des composants métiers permet de gérer et contrôler les droits utilisateurs en matière de saisie d''écritures comptables.', 'SINORG', 'Montpellier', 'JM Lappara tèl: 04 99 61 90 86', 'M. Meynard'),
(15, '(3) Analyse et conception pour le développement du ste Web de UPGEN.', 'UPGEN CEEI Cap Alpha', '34940 Montpellier cedex 9', 'Mustapha BENSAAD tèl : 04 67 59 36 21', 'M. Meynard'),
(16, 'Gestion d''un observatoire des agricultures méditerranéennes accessibles en HTTP. L''analyse porte sur la structure des données et des méta données selon les profils d''usage;', 'IAM', '3191 route de Mende 34093 Montpellier cedex 5', 'Marie Claire ALLAYA et Pierre ARAGON', 'I. Mougenot'),
(17, 'Une plate-forme de modélisation des plantes est en cours d''élaboration; Le stage consiste en une analyse conceptuelle de la plate-forme (type UML) et s''appuiera sur des travaux en cours', 'CIRAD-AMIS', 'av Agropolis 34398 Montpellier cedex 5', 'Christian BARON (tèl : 04 67 61 56 47) et Philippe Philippe REITZ (tèl : 06 62 32 20 50)', 'T. Libourel'),
(18, '(2 à 3) Analyse d''une base de données de gestion de collections botaniques et d''études phytoécologiques, développée sous Access 97.', 'CIRAD-CA', 'TA 74/09 av Agropolis 34398 Montpellier cedex 5', 'Thomas LE BOURGEOIS et Sandrine AUZOUX  Tèl : 04 67 59 38 71', 'M. Sala'),
(19, 'Analyse Traitement Données Médicales (Prénatales)', 'LIRMM  / milieux médicaux divers', 'Montpellier', 'M. ROCHE (Médecin)', 'T. Libourel'),
(21, 'Analyse UML d''acides nucléiques ARN et ADN', 'Institut of Biotechnology and Pharmacology', 'Faculte de Pharmacie  15 Av. Charles Flahault, 34090 Montpellier, France.', 'Franck Molina Tel: +33/0  467 548 646 ; Fax: +33/0 467 548 610 franck.molina@ibph.pharma.univ-montp1.fr', 'I. Mougenot');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `login` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`login`, `password`) VALUES
('deux', 'f83815aedaa1b6bf4211e85910e6bc82'),
('un', '0674272bac0715f803e382b5aa437e08');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
 ADD PRIMARY KEY (`nom`,`prenom`), ADD UNIQUE KEY `email` (`email`), ADD KEY `option` (`opt`), ADD KEY `numStageA` (`numStageA`);

--
-- Index pour la table `options`
--
ALTER TABLE `options`
 ADD PRIMARY KEY (`code`);

--
-- Index pour la table `stageA`
--
ALTER TABLE `stageA`
 ADD PRIMARY KEY (`numStageA`), ADD KEY `numStageA` (`numStageA`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
 ADD PRIMARY KEY (`login`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
ADD CONSTRAINT `etudiant_options` FOREIGN KEY (`opt`) REFERENCES `options`
(`code`),
ADD CONSTRAINT `etudiant_stagea` FOREIGN KEY (`numStageA`) REFERENCES `stageA`
(`numStageA`);
