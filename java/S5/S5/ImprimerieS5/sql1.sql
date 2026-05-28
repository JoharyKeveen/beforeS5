/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Tolotra
 * Created: 19 janv. 2023
 */
CREATE TABLE Activite (
  id          SERIAL NOT NULL, 
  nomActivite varchar(50) NOT NULL, 
  PRIMARY KEY (id));
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
  nom             varchar(20) NOT NULL, 
  prenom          varchar(20) NOT NULL, 
  PRIMARY KEY (id));

CREATE TABLE Devis (
  id           SERIAL NOT NULL, 
  totalDevis   float8 NOT NULL, 
  grammage     float8 NOT NULL, 
  isRectoVerso int4 NOT NULL, 
  isCouleur    int4 NOT NULL, 
  quantite     float8 NOT NULL, 
  TypeFormatid int4 NOT NULL, 
  TypePapierid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Employe (
  id           SERIAL NOT NULL, 
  dateEmbauche date NOT NULL, 
  matricule    varchar(50) NOT NULL UNIQUE, 
  Personneid   int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE EmployeActivite (
  id           SERIAL NOT NULL, 
  duree        float8 NOT NULL, 
  Activiteid   int4 NOT NULL, 
  Specialiteid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Genre (
  id    SERIAL NOT NULL, 
  genre varchar(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE marge (
  id         SERIAL NOT NULL, 
  valeur     float8 NOT NULL, 
  Activiteid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Materiel (
  id          SERIAL NOT NULL, 
  nomMateriel varchar(50) NOT NULL, 
  prix        float8 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE MaterielActivite (
  id         SERIAL NOT NULL, 
  quantite   float8 NOT NULL, 
  Activiteid int4 NOT NULL, 
  Materielid int4 NOT NULL, 
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
CREATE TABLE Specialite (
  id            SERIAL NOT NULL, 
  nomSpecialite varchar(50) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Specialite_salaire (
  id           SERIAL NOT NULL, 
  valeur       float8 NOT NULL, 
  Specialiteid int4 NOT NULL, 
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
  description       text NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE Personne ADD CONSTRAINT FKPersonne589037 FOREIGN KEY (Genreid) REFERENCES Genre (id);
ALTER TABLE Personne ADD CONSTRAINT FKPersonne426642 FOREIGN KEY (NiveauEtudeid) REFERENCES NiveauEtude (id);
ALTER TABLE Personne_Specialite ADD CONSTRAINT FKPersonne_S618597 FOREIGN KEY (Personneid) REFERENCES Personne (id);
ALTER TABLE Personne_Specialite ADD CONSTRAINT FKPersonne_S137919 FOREIGN KEY (Specialiteid) REFERENCES Specialite (id);
ALTER TABLE Employe ADD CONSTRAINT FKEmploye666220 FOREIGN KEY (Personneid) REFERENCES Personne (id);
ALTER TABLE PrixFormat ADD CONSTRAINT FKPrixFormat790784 FOREIGN KEY (TypeFormatid) REFERENCES TypeFormat (id);
ALTER TABLE PrixPapier ADD CONSTRAINT FKPrixPapier942390 FOREIGN KEY (TypePapierid) REFERENCES TypePapier (id);
ALTER TABLE autrePrix ADD CONSTRAINT FKautrePrix163089 FOREIGN KEY (TypeAutreid) REFERENCES TypeAutre (id);
ALTER TABLE Devis ADD CONSTRAINT FKDevis888419 FOREIGN KEY (TypeFormatid) REFERENCES TypeFormat (id);
ALTER TABLE Devis ADD CONSTRAINT FKDevis533962 FOREIGN KEY (TypePapierid) REFERENCES TypePapier (id);
ALTER TABLE Specialite_salaire ADD CONSTRAINT FKSpecialite162477 FOREIGN KEY (Specialiteid) REFERENCES Specialite (id);
ALTER TABLE EmployeActivite ADD CONSTRAINT FKEmployeAct76734 FOREIGN KEY (Activiteid) REFERENCES Activite (id);
ALTER TABLE EmployeActivite ADD CONSTRAINT FKEmployeAct651554 FOREIGN KEY (Specialiteid) REFERENCES Specialite (id);
ALTER TABLE MaterielActivite ADD CONSTRAINT FKMaterielAc907849 FOREIGN KEY (Activiteid) REFERENCES Activite (id);
ALTER TABLE MaterielActivite ADD CONSTRAINT FKMaterielAc99135 FOREIGN KEY (Materielid) REFERENCES Materiel (id);
ALTER TABLE marge ADD CONSTRAINT FKmarge555876 FOREIGN KEY (Activiteid) REFERENCES Activite (id);

insert into EmployeActivite(duree,Activiteid,Specialiteid) values(1,1,1);
insert into EmployeActivite(duree,Activiteid,Specialiteid) values(0.5,1,2);
insert into EmployeActivite(duree,Activiteid,Specialiteid) values(0.75,1,3);

insert into Materiel(nomMateriel,prix) values('encre',1000);
insert into Materiel(nomMateriel,prix) values('cartouche',1500);

insert into MaterielActivite(duree,Activiteid,Materielid) values(1,1,2);
insert into MaterielActivite(duree,Activiteid,Materielid) values(0.5,1,1);

insert into Specialite_salaire(valeur,Specialiteid) values(20000,2);
insert into Specialite_salaire(valeur,Specialiteid) values(10000,3);
insert into Specialite_salaire(valeur,Specialiteid) values(25000,1);

insert into Activite(nomActivite) values ('Fiche');
insert into Activite(nomActivite) values ('Pancarte');




insert into marge (valeur,Activiteid) values(10,1);
insert into marge (valeur,Activiteid) values(20,2);
insert into marge (valeur,Activiteid) values(15,3);

create view v_ma as select a.id,nomActivite,Activiteid,valeur from Activite a join marge m on a.id=m.Activiteid;


insert into EmployeActivite(duree,Activiteid,Specialiteid) values(1,2,1);
insert into EmployeActivite(duree,Activiteid,Specialiteid) values(0.5,2,2);
insert into EmployeActivite(duree,Activiteid,Specialiteid) values(0.75,2,3);

insert into EmployeActivite(duree,Activiteid,Specialiteid) values(1,3,1);
insert into EmployeActivite(duree,Activiteid,Specialiteid) values(0.5,3,2);
insert into EmployeActivite(duree,Activiteid,Specialiteid) values(0.75,3,3);

insert into MaterielActivite(duree,Activiteid,Materielid) values(1,2,2);
insert into MaterielActivite(duree,Activiteid,Materielid) values(0.5,2,1);

insert into MaterielActivite(duree,Activiteid,Materielid) values(1,3,2);
insert into MaterielActivite(duree,Activiteid,Materielid) values(0.5,3,1);

update marge set valeur = where activiteid = 1;


CREATE TABLE margeDePrix (
  id      SERIAL NOT NULL, 
  minimum float8 NOT NULL, 
  maximum float4, 
  marge   float4, 
  PRIMARY KEY (id));


INSERT INTO MargeDePrix VALUES(DEFAULT,1,5000,50);
INSERT INTO MargeDePrix VALUES(DEFAULT,5000,10000,10);
INSERT INTO MargeDePrix VALUES(DEFAULT,10000,1000000000000,5);

create view V_prixMateriel as 
select m.id,nomMateriel,prix,minimum,maximum,marge,(prix+((marge/100)*prix)) as prixConseille,((marge/100)*prix) as benefice from Materiel m , margeDePrix ma 
where prix between minimum and maximum;


insert into Materiel(nomMateriel,prix) values('papier type 1',500);

INSERT INTO Client VALUES(DEFAULT,'root',md5('root'),'CLIENT_1','Randria','Zafy');
INSERT INTO Client VALUES(DEFAULT,'root',md5('root'),'CLIENT_2','Bertrand','Meunier');

CREATE TABLE facture (
  id          SERIAL NOT NULL, 
  dateFacture date NOT NULL, 
  total       float8 NOT NULL, 
  Clientid    int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE facture_detail (
  quantite   int4 NOT NULL, 
  prixTotal  float8 NOT NULL, 
  factureid  int4 NOT NULL, 
  Activiteid int4 NOT NULL);
CREATE TABLE paiement_facture (
  id     SERIAL NOT NULL, 
  valeur float8 NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE facture_detail ADD CONSTRAINT FKfacture_de801441 FOREIGN KEY (factureid) REFERENCES facture (id);
ALTER TABLE facture_detail ADD CONSTRAINT FKfacture_de224729 FOREIGN KEY (Activiteid) REFERENCES Activite (id);
ALTER TABLE facture ADD CONSTRAINT FKfacture303798 FOREIGN KEY (Clientid) REFERENCES Client (id);

alter table facture_detail
ADD COLUMN id INteger primary key;