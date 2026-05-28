CREATE DATABASE comContrainte;
use comContrainte;

CREATE TABLE produit(
    id int,
    nom VARCHAR(20),
    idmarque int,
    disponible VARCHAR(3),
    prix double,
    foreign key(idmarque) references marque(id)
);
CREATE TABLE marque(
    id int,
    nom VARCHAR(20)
);
insert into produit values(1,"TN",1,"oui",90000);
insert into produit values(2,"Stan",2,"oui",90000);
insert into produit values(3,"Af1",1,"oui",90000);
insert into produit values(4,"Old school",2,"oui",90000);
insert into produit values(5,"Air Terra",1,"oui",90000);
insert into produit values(6,"Dunk Low",1,"oui",90000);
insert into produit values(7,"Carnaby",2,"oui",90000);
insert into produit values(8,"Lerond",2,"oui",Null);
insert into produit values(9,"Fiba",4,"oui",0);
insert into produit values(10,"test",4,"oui",Null);
insert into produit values(11,"lol",4,"oui",0);

insert into marque values(1,"Nike");
insert into marque values(2,"Adidas");
insert into marque values(3,"Lacoste");
insert into marque values(4,"Fila");
