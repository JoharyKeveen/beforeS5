CREATE table produit(
    idProduit VARCHAR(9) PRIMARY KEY NOT NULL,
    nom VARCHAR(50),
    prixUnitaire decimal(10,3)
);

create table composant(
    idComposant VARCHAR(9),
    produit VARCHAR(9),
    quantite decimal(6,3),
    FOREIGN KEY (idComposant) REFERENCES produit(idProduit),
    FOREIGN KEY (produit) REFERENCES produit(idProduit)
);

INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('P0','Limonade GM',NULL);

INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('P1','limonade',NULL);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('P2','fanta',NULL);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('P3','biere',NULL);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C1','eau',30);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C2','gaz',4);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C3','eaugazeuse',NULL);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C4','arome',100);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C5','sucre',4200);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C6','orge',NULL);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C7','Alcool',5000);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C8','Bouteil',500);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C9','Etiquete',NULL);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C10','papier',80);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C11','print',40);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C12','mais',2150);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C13','formol',2800);
INSERT INTO produit(idProduit,nom,prixUnitaire) VALUES('C14','conservateur',3000);


INSERT INTO composant(idComposant,produit,quantite) VALUES ('P0','P1',1);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P1','C3',0.3);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P1','C4',0.5);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P1','C5',0.05);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P1','C8',0.3);

INSERT INTO composant(idComposant,produit,quantite) VALUES ('P2','C3',1.5);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P2','C4',4);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P2','C5',6);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P2','C8',1.7);

INSERT INTO composant(idComposant,produit,quantite) VALUES ('P3','C6',0.1);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P3','C3',0.56);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P3','C7',0.09);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P3','C8',0.6);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P3','C9',0.6);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('P3','C14',0.2);

INSERT INTO composant(idComposant,produit,quantite) VALUES ('C3','C1',0.9);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('C3','C2',50);


INSERT INTO composant(idComposant,produit,quantite) VALUES ('C6','C12',0.3);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('C6','C13',0.1);


INSERT INTO composant(idComposant,produit,quantite) VALUES ('C9','C10',1);
INSERT INTO composant(idComposant,produit,quantite) VALUES ('C9','C11',1);





CREATE VIEW AllC AS select composant, produit, quantite, nom, 
    CASE 
        WHEN prix!=0 Then prix
        ELSE 0
    END AS prix
from composant co JOIN produit p ON co.produit=p.id;


SELECT * FROM AllC start with IDCOMPOSANT='P1' connect by prior PRODUIT=IDCOMPOSANT;