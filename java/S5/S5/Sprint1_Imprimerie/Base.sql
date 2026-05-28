CREATE TABLE autrePrix (
  id          SERIAL NOT NULL, 
  valeur      float8 NOT NULL, 
  TypeAutreid int4 NOT NULL, 
  DatePrix    date NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Client (
  id              SERIAL NOT NULL, 
  login           varchar(50) NOT NULL, 
  mdp             varchar(50) NOT NULL, 
  matriculeClient varchar(50) NOT NULL UNIQUE, 
  Personneid      int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Commande (
  id           SERIAL NOT NULL, 
  prixCommande float8 NOT NULL, 
  quantite     float8 NOT NULL, 
  Devisid      int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Devis (
  id           SERIAL NOT NULL, 
  totalDevis   float8 NOT NULL, 
  grammage     float8 NOT NULL, 
  isRectoVerso int4 NOT NULL, 
  isCouleur    int4 NOT NULL, 
  quantite     int4 NOT NULL, 
  TypeFormatid int4 NOT NULL, 
  TypePapierid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Employe (
  id           SERIAL NOT NULL, 
  dateEmbauche date NOT NULL, 
  matricule    varchar(50) NOT NULL UNIQUE, 
  Personneid   int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Employe_Commande (
  Employeid      int4 NOT NULL, 
  Commandeid     int4 NOT NULL, 
  dureeDeTravail float8 NOT NULL, 
  PRIMARY KEY (Employeid, 
  Commandeid));
CREATE TABLE Genre (
  id    SERIAL NOT NULL, 
  genre varchar(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE NiveauEtude (
  id     SERIAL NOT NULL, 
  niveau varchar(20) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Personne (
  id            SERIAL NOT NULL, 
  nom           varchar(20) NOT NULL, 
  prenom        varchar(20) NOT NULL, 
  dateNaissance date NOT NULL, 
  Genreid       int4, 
  NiveauEtudeid int4, 
  PRIMARY KEY (id));
CREATE TABLE Personne_Specialite (
  Personneid   int4 NOT NULL, 
  Specialiteid int4 NOT NULL, 
  PRIMARY KEY (Personneid, 
  Specialiteid));
CREATE TABLE PrixFormat (
  id           SERIAL NOT NULL, 
  valeur       float8 NOT NULL, 
  datePrix     date NOT NULL, 
  TypeFormatid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE PrixPapier (
  id           SERIAL NOT NULL, 
  valeur       float8 NOT NULL, 
  datePrix     date NOT NULL, 
  TypePapierid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE SalaireEmploye (
  id          SERIAL NOT NULL, 
  valeur      float8 NOT NULL, 
  dateSalaire date NOT NULL, 
  Employeid   int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Specialite (
  id            SERIAL NOT NULL, 
  nomSpecialite varchar(50) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE TypeAutre (
  id   SERIAL NOT NULL, 
  type varchar(50) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE TypeFormat (
  id                SERIAL NOT NULL, 
  designationFormat varchar(20) NOT NULL, 
  dimension         varchar(20) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE TypePapier (
  id                SERIAL NOT NULL, 
  designationPapier varchar(50) NOT NULL, 
  description       int4 NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE Personne ADD CONSTRAINT FKPersonne589037 FOREIGN KEY (Genreid) REFERENCES Genre (id);
ALTER TABLE Personne ADD CONSTRAINT FKPersonne426642 FOREIGN KEY (NiveauEtudeid) REFERENCES NiveauEtude (id);
ALTER TABLE Personne_Specialite ADD CONSTRAINT FKPersonne_S618597 FOREIGN KEY (Personneid) REFERENCES Personne (id);
ALTER TABLE Personne_Specialite ADD CONSTRAINT FKPersonne_S137919 FOREIGN KEY (Specialiteid) REFERENCES Specialite (id);
ALTER TABLE Employe ADD CONSTRAINT FKEmploye666220 FOREIGN KEY (Personneid) REFERENCES Personne (id);
ALTER TABLE Client ADD CONSTRAINT FKClient873475 FOREIGN KEY (Personneid) REFERENCES Personne (id);
ALTER TABLE PrixFormat ADD CONSTRAINT FKPrixFormat790784 FOREIGN KEY (TypeFormatid) REFERENCES TypeFormat (id);
ALTER TABLE PrixPapier ADD CONSTRAINT FKPrixPapier942390 FOREIGN KEY (TypePapierid) REFERENCES TypePapier (id);
ALTER TABLE autrePrix ADD CONSTRAINT FKautrePrix163089 FOREIGN KEY (TypeAutreid) REFERENCES TypeAutre (id);
ALTER TABLE Devis ADD CONSTRAINT FKDevis888419 FOREIGN KEY (TypeFormatid) REFERENCES TypeFormat (id);
ALTER TABLE Devis ADD CONSTRAINT FKDevis533962 FOREIGN KEY (TypePapierid) REFERENCES TypePapier (id);
ALTER TABLE Employe_Commande ADD CONSTRAINT FKEmploye_Co938917 FOREIGN KEY (Employeid) REFERENCES Employe (id);
ALTER TABLE Employe_Commande ADD CONSTRAINT FKEmploye_Co394844 FOREIGN KEY (Commandeid) REFERENCES Commande (id);
ALTER TABLE SalaireEmploye ADD CONSTRAINT FKSalaireEmp823761 FOREIGN KEY (Employeid) REFERENCES Employe (id);
ALTER TABLE Commande ADD CONSTRAINT FKCommande461752 FOREIGN KEY (Devisid) REFERENCES Devis (id);
