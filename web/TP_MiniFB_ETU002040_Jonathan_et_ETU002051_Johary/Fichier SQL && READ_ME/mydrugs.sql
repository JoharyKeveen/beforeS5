drop mydrugs;
create database mydrugs;
use mydrugs;

create table membres(
    idMembre INTEGER PRIMARY KEY auto_increment,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Motdepasse VARCHAR(30),
    DateNaissance date
);
insert into membres values(null,'Jean','Paul','jp@gmail.com','00j00p00','2004-02-01');
insert into membres values(null,'Super','Smash','sm@gmail.com','sm','2006-02-01');
insert into membres values(null,'Chales','Lampard','cl@gmail.com','cl','1999-02-01');

create table amis(
    idMembre1 INTEGER,
    idMembre2 INTEGER,
    DateHeureDemande datetime,
    DateHeureAcceptation datetime,
    FOREIGN KEY(idMembre1) REFERENCES membres(idMembre),
    FOREIGN KEY(idMembre2) REFERENCES membres(idMembre)
);
insert into  amis values(1,2,now(),now());
insert into  amis values(3,1,now(),null);

create table publications(
    idPublication INTEGER PRIMARY KEY auto_increment,
    DateHeurePublication datetime,
    TextePublication text,
    TypeAffichage VARCHAR(6),
    idMembre INTEGER,
    FOREIGN KEY(idMembre) REFERENCES membres(idMembre)
);

create table commentaires(
    idCommentaires INTEGER PRIMARY KEY auto_increment,
    DateHeureCommentaires datetime,
    TexteCommentaire text,
    idPublication INTEGER,
    idMembre INTEGER,
    FOREIGN KEY(idPublication) REFERENCES publications(idPublication),
    FOREIGN KEY(idMembre) REFERENCES membres(idMembre)
);

create table reactions(
    idPublication INTEGER,
    idMembre INTEGER,
    idTypeReaction INTEGER,
    FOREIGN KEY(idPublication) REFERENCES publications(idPublication),
    FOREIGN KEY(idMembre) REFERENCES membres(idMembre)
);