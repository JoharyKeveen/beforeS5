drop database Ajax9;
create database Ajax9;
use Ajax9;
create table Membre(
    nom VARCHAR(100),
    email VARCHAR(100),
    pwd VARCHAR(50)
);

insert into Membre values("Jean","j@gmail.com","test");
insert into Membre values("test","t@gmail.com","test");

create table publications(
    idPublication INTEGER PRIMARY KEY auto_increment,
    DateHeurePublication datetime,
    TextePublication text,
    nom VARCHAR(100),
    FOREIGN KEY(nom) REFERENCES Membre(nom)
);

create table commentaires(
    idCommentaires INTEGER PRIMARY KEY auto_increment,
    DateHeureCommentaires datetime,
    TexteCommentaire text,
    idPublication INTEGER,
    nom VARCHAR(100),
    FOREIGN KEY(idPublication) REFERENCES publications(idPublication),
    FOREIGN KEY(nom) REFERENCES Membre(nom)
);
select*from publications;