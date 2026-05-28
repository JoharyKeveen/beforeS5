create table prod(
    idProduit VARCHAR(10) primary key,
    nomProduit VARCHAR(50),
    prix DECIMAL(10,2)
); 
create table recette(
    idProduit VARCHAR(10),
    idIngredient VARCHAR(10),
    quantite DECIMAL(10,1),
    foreign key(idProduit) references prod(idProduit),
    foreign key(idIngredient) references prod(idProduit)
);

/*
INSERT INTO prod VALUES ('P1', 'Limonade',null);
INSERT INTO prod VALUES ('P2', 'Fanta',null);
INSERT INTO prod VALUES ('P3', 'Bierre',null);
INSERT INTO prod VALUES ('P4', 'Limonade GM',null);
INSERT INTO prod VALUES ('P5', 'Bierre PM',null);
INSERT INTO prod VALUES ('C1', 'Eau gazeuse',null);
INSERT INTO prod VALUES ('C2', 'Sucre',2400);
INSERT INTO prod VALUES ('C3', 'Arome',5000);
INSERT INTO prod VALUES ('C4', 'Alcool',1000);
INSERT INTO prod VALUES ('C5', 'Orge',null);
INSERT INTO prod VALUES ('C6', 'Eau',1000);
INSERT INTO prod VALUES ('C7', 'Gaz',1000);
INSERT INTO prod VALUES ('C8', 'Mais',1800);
INSERT INTO prod VALUES ('C9', 'Formol',4000);
INSERT INTO prod VALUES ('C10', 'Levure',600);
INSERT INTO prod VALUES ('C11', 'Bouteille',1000);
INSERT INTO prod VALUES ('C12', 'Etiquette',null);
INSERT INTO prod VALUES ('C13', 'Papier',100);
INSERT INTO prod VALUES ('C14', 'Impression',200);
*/

/*
INSERT INTO recette VALUES ('P1', 'C1', 1);
INSERT INTO recette VALUES ('P1', 'C2', 0.150);
INSERT INTO recette VALUES ('P1', 'C3', 0.150);
INSERT INTO recette VALUES ('P1', 'C11', 0.33);
INSERT INTO recette VALUES ('P1', 'C12', 1);
INSERT INTO recette VALUES ('C12', 'C13', 1);
INSERT INTO recette VALUES ('C12', 'C14', 1);
INSERT INTO recette VALUES ('C1', 'C6', 0.5);
INSERT INTO recette VALUES ('C1', 'C7', 0.5);
INSERT INTO recette VALUES ('P2', 'C1', 1.5);
INSERT INTO recette VALUES ('P2', 'C2', 0.250);
INSERT INTO recette VALUES ('P2', 'C3', 0.250);
INSERT INTO recette VALUES ('P3', 'C1', 0.60);
INSERT INTO recette VALUES ('P3', 'C3', 0.2);
INSERT INTO recette VALUES ('P3', 'C4', 0.1);
INSERT INTO recette VALUES ('P3', 'C5', 0.1);
INSERT INTO recette VALUES ('C5', 'C8', 0.5);
INSERT INTO recette VALUES ('C5', 'C9', 0.3);
INSERT INTO recette VALUES ('C5', 'C10', 0.250);
INSERT INTO recette VALUES ('P4', 'P1', 3);
INSERT INTO recette VALUES ('P5', 'P3', 0.5);   
*/

insert into prod values('PRD0001','eau_gazeuse',null);
insert into prod values('PRD0002','liqueur',null);
insert into prod values('PRD0003','biere',null);
insert into prod values('PRD0004','jus',null);
insert into prod values('PRD0005','cocktail',null);
insert into prod values('PRD0006','eau',10);
insert into prod values('PRD0007','gaz',20);
insert into prod values('PRD0008','sucre',12.5);
insert into prod values('PRD0009','arome',27.5);
insert into prod values('PRD0010','alcool',30);
insert into prod values('PRD0011','conservateur',120);


insert into recette values('PRD0001','PRD0006',0.5);
insert into recette values('PRD0001','PRD0007',0.5);

insert into recette values('PRD0002','PRD0008',1);
insert into recette values('PRD0002','PRD0009',1);
insert into recette values('PRD0002','PRD0010',1);

insert into recette values('PRD0003','PRD0011',1);
insert into recette values('PRD0003','PRD0002',1);

insert into recette values('PRD0004','PRD0011',1);
insert into recette values('PRD0004','PRD0001',0.5);
insert into recette values('PRD0004','PRD0009',1);

insert into recette values('PRD0005','PRD0004',1);
insert into recette values('PRD0005','PRD0003',1);


 SELECT p.idProduit,p.nomProduit,
           (SELECT SUM(r.quantite * c.prix)
            FROM recette r
            INNER JOIN prod c
            ON r.idIngredient = c.idProduit
            WHERE r.idProduit = p.idProduit
            START WITH r.idProduit = p.idProduit
            CONNECT BY PRIOR r.idIngredient = r.idProduit) AS prix
    FROM prod p;