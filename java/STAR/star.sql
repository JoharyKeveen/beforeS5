create sequence seqProd start with 1;

create table produit(
	id varchar(7) primary key,
	nom varchar(20),
	quantite DOUBLE PRECISION,
	prodFini varchar(20),
	prix DOUBLE PRECISION
);
