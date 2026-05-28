drop database immobilier;
create database immobilier;
\c immobilier;

create table membres(
    idMembre SERIAL PRIMARY KEY,
    email VARCHAR(100),
    nom VARCHAR(100),
    mdp VARCHAR(100),
    numero VARCHAR(15),
    etat INT
);

INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('user@gmail.com','user','0000','0346798735',1);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('randria@gmail.com','Randria','0000','0346794365',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('rakoto@gmail.com','Rakoto','0000','0346594375',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('anne@gmail.com','Anne','0000','0341222109',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('mavo@gmail.com','Mavo','0000','0324987855',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('paiso@gmail.com','Paiso','0000','0324153434',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('tovo@gmail.com','Tovo','0000','0347823312',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('maka@gmail.com','Maka','0000','0347823489',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('rabe@gmail.com','Rabe','0000','0335699832',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('fetra@gmail.com','Fetra','0000','0324512393',0);
INSERT INTO membres(email,nom,mdp,numero,etat) VALUES ('lova@gmail.com','Lova','0000','0331657532',0);

create table typ(
    id_type SERIAL primary key ,
    nom varchar(20)
);
INSERT INTO typ(nom) VALUES ('maison');
INSERT INTO typ(nom) VALUES ('studio');
INSERT INTO typ(nom) VALUES ('appartement');

create table trano(
    id_trano SERIAL primary key ,
    id_type int,
    nb_chambre int,
    loyer FLOAT,
    quartier varchar(20),
    descriptions varchar(200),
    FOREIGN KEY (id_type) REFERENCES  typ(id_type)
);
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (1,3,12000,'Andavamamba','moderne en plein ville');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (1,3,10500,'Ivato','securisee avec piscine');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (3,2,8000,'Ivandry','confortable et meuble');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (3,1,7500,'Ivato','immeuble intéressant au rez-de-chaussee');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (2,2,8000,'Analakely','situe au coeur de la ville avec terrasse');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (2,2,9500,'Isoraka','3eme etage avec ascenseur, securise');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (1,4,15000,'Alarobia','nombreuses chambres et un espace ouvert a l avant et a l arriere');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (1,2,9500,'Antanimena','maison familiale, tres conviviale');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (2,1,4500,'Mahamasina','confortable et bien pratique pour vivre solo');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (2,1,3000,'Ivato','situee dans une zone privilegiee');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (3,3,10500,'Ivandry','entierement renove, spacieux');
INSERT INTO trano(id_type,nb_chambre,loyer,quartier,descriptions) VALUES (3,2,9500,'Andoharanofotsy','pour les etudiants, tres pratique');

create table photo(
    id_photo SERIAL primary key ,
    id_trano int,
    sary varchar(30),
    FOREIGN KEY (id_trano) REFERENCES trano (id_trano)
);
INSERT INTO photo(id_trano,sary) values(2,'m1.jpg');
INSERT INTO photo(id_trano,sary) values(2,'m11.jpg');
INSERT INTO photo(id_trano,sary) values(2,'m12.jpg');
INSERT INTO photo(id_trano,sary) values(1,'m2.jpg');
INSERT INTO photo(id_trano,sary) values(1,'m21.jpg');
INSERT INTO photo(id_trano,sary) values(1,'m22.jpg');
INSERT INTO photo(id_trano,sary) values(3,'a1.jpg');
INSERT INTO photo(id_trano,sary) values(3,'a11.jpg');
INSERT INTO photo(id_trano,sary) values(3,'a12.jpg');
INSERT INTO photo(id_trano,sary) values(4,'a2.jpg');
INSERT INTO photo(id_trano,sary) values(4,'a21.jpg');
INSERT INTO photo(id_trano,sary) values(4,'a22.jpg');
INSERT INTO photo(id_trano,sary) values(5,'s1.jpg');
INSERT INTO photo(id_trano,sary) values(5,'s11.jpg');
INSERT INTO photo(id_trano,sary) values(5,'s12.jpg');
INSERT INTO photo(id_trano,sary) values(6,'s2.jpg');
INSERT INTO photo(id_trano,sary) values(6,'s21.jpg');
INSERT INTO photo(id_trano,sary) values(6,'s22.jpg');
INSERT INTO photo(id_trano,sary) values(7,'m3.jpg');
INSERT INTO photo(id_trano,sary) values(7,'m31.jpg');
INSERT INTO photo(id_trano,sary) values(7,'m32.jpg');
INSERT INTO photo(id_trano,sary) values(8,'m4.jpg');
INSERT INTO photo(id_trano,sary) values(8,'m41.jpg');
INSERT INTO photo(id_trano,sary) values(8,'m42.jpg');
INSERT INTO photo(id_trano,sary) values(9,'a3.jpg');
INSERT INTO photo(id_trano,sary) values(9,'a31.jpg');
INSERT INTO photo(id_trano,sary) values(9,'a32.jpg');
INSERT INTO photo(id_trano,sary) values(10,'a2.jpg');
INSERT INTO photo(id_trano,sary) values(10,'a21.jpg');
INSERT INTO photo(id_trano,sary) values(10,'a22.jpg');
INSERT INTO photo(id_trano,sary) values(11,'s3.jpg');
INSERT INTO photo(id_trano,sary) values(11,'s31.jpg');
INSERT INTO photo(id_trano,sary) values(11,'s32.jpg');
INSERT INTO photo(id_trano,sary) values(12,'s4.jpg');
INSERT INTO photo(id_trano,sary) values(12,'s41.jpg');
INSERT INTO photo(id_trano,sary) values(12,'s42.jpg');\

create table reservation(
    id_reserv SERIAL primary key ,
    idMembre int,
    id_trano int,
    date_arrive date,
    date_depart date,
    FOREIGN KEY (idMembre) REFERENCES membres (idMembre),
    FOREIGN KEY (id_trano) REFERENCES trano (id_trano)
);
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(2,3,'11-11-2022','21-11-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(3,3,'20-12-2022','31-12-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(4,2,'02-12-2022','14-12-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(5,4,'12-06-2022','31-10-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(6,6,'23-11-2022','30-11-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(7,8,'04-11-2022','30-11-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(8,12,'20-12-2022','29-12-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(9,9,'24-12-2022','31-12-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(10,5,'10-11-2022','12-12-2022');
insert into reservation(idMembre,id_trano,date_arrive,date_depart) values(3,10,'01-11-2022','21-12-2022');

