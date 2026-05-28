create database OneDay;
use OneDay;
create table Utilisateur(
    idUtilisateur int AUTO_INCREMENT not null PRIMARY KEY,
    email VARCHAR(100),
    motDePasse VARCHAR(50),
    estAdmin int
);
create table Cv(
    idCV int AUTO_INCREMENT not null PRIMARY KEY,
    idUtilisateur int,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    dateNaissance DATE,
    photo VARCHAR(50),
    FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur)
);
create table Parametre(
    codeParametre VARCHAR(2) PRIMARY KEY,
    descriptions VARCHAR(50),
    choix VARCHAR(50),
    valeur VARCHAR(20),
    coefficient int
);
create table DetailCv(
    idDetailCv int AUTO_INCREMENT not null PRIMARY KEY,
    idCV int,
    codeParametre VARCHAR(2),
    unDesChoix VARCHAR(50),
    FOREIGN KEY (idCV) REFERENCES Cv(idCV),
    FOREIGN KEY (codeParametre) REFERENCES Parametre(codeParametre)
);


insert into Utilisateur values(null,"admin@gmail.com","admin",1);
insert into Utilisateur values(null,"U1@gmail.com","U1",0);

insert into Cv values(null,2,"Rakoto","Bema","2000-05-23","foke.jpg");

insert into Parametre values("P1","niveau etude","Doctorat,Master,Licence,Bacc","10,7,5,3",5);
insert into Parametre values("P2","filiere","Info,Design,Gestion","5,5,3",3);
insert into Parametre values("P3","sportif","Oui,Non","3,0",2);
