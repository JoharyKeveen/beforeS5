drop database template;
create database template;
use template;
create table product(
    idprod int primary key auto_increment,
    nom varchar(30),
    prix double,
    img varchar(30),
    typ varchar(30),
    daty date,
    zem int,
    view int
);

insert into product values(seqProd.nextval,'Hena be',40.00,'feature-1.jpg','fresh-meat',now(),5,8);
insert into product values('','Akondro',30.00,'feature-2.jpg','oranges',now(),3,6;
insert into product values('','Goavy',30.00,'feature-3.jpg','oranges',now(),0,6);
insert into product values('','Pasteky',30.00,'feature-4.jpg','vegetables',now(),3,5);
insert into product values('','Voaloboka',30.00,'feature-5.jpg','oranges',now(),1,1);
insert into product values('','Mofo misy fangarony',30.00,'feature-6.jpg','fastfood',now(),0,1);
insert into product values('','Manga',30.00,'feature-7.jpg','oranges',now(),8,10);
insert into product values('','Paoma',30.00,'feature-8.jpg','fresh-meat',now(),3,6);


Postgres sql:
create sequence seqProd start with 1;

CREATE TABLE IF NOT EXISTS public.product
(
    idprod integer NOT NULL,
    nom text COLLATE pg_catalog."default",
    prix double precision,
    img text COLLATE pg_catalog."default",
    typ text COLLATE pg_catalog."default",
    daty date,
    zem integer,
    view integer,
    CONSTRAINT product_pkey PRIMARY KEY (idprod)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;


insert into public.product values(nextval('seqProd'),'Hena be',40.00,'feature-1.jpg','fresh-meat',now(),5,8);
insert into public.product values(nextval('seqProd'),'Akondro',30.00,'feature-2.jpg','oranges',now(),3,6);
insert into product values(nextval('seqProd'),'Goavy',30.00,'feature-3.jpg','oranges',now(),0,6);
insert into product values(nextval('seqProd'),'Pasteky',30.00,'feature-4.jpg','vegetables',now(),3,5);
insert into product values(nextval('seqProd'),'Voaloboka',30.00,'feature-5.jpg','oranges',now(),1,1);
insert into product values(nextval('seqProd'),'Mofo misy fangarony',30.00,'feature-6.jpg','fastfood',now(),0,1);
insert into product values(nextval('seqProd'),'Manga',30.00,'feature-7.jpg','oranges',now(),8,10);
insert into product values(nextval('seqProd'),'Paoma',30.00,'feature-8.jpg','fresh-meat',now(),3,6);