-- create sequence seqEvent start with 1;
-- create sequence seqZone start with 1;
-- create sequence seqSeza start with 1;

-- drop table evenement;
-- drop table zone;
-- drop table seza;

create table evenement(
    id int primary key not null,
    nom VARCHAR2(50)
);
create table zone(
    id int primary key not null,
    idEvent int,
    nom VARCHAR2(50),
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);
create table seza(
    id int primary key not null,
    idZone int,
    etat VARCHAR2(10),
    FOREIGN KEY (idZone) REFERENCES zone(id)
);
create table sezaL(
    id int primary key not null,
    idEvent int,
    nombre int,
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);

insert into evenement values(1,'mahaleo');
insert into evenement values(2,'OBOY');

insert into zone values(1,1,'zone A');
insert into zone values(2,1,'zone B');
insert into zone values(3,1,'zone C');

insert into zone values(4,2,'zone A');
insert into zone values(5,2,'zone B');
insert into zone values(6,2,'zone C');

insert into sezaL values(1,1,3000);
insert into sezaL values(2,2,4000);

insert into seza values(1,1,'vert');
insert into seza values(2,1,'vert');
insert into seza values(3,1,'vert');
insert into seza values(4,1,'vert');
insert into seza values(5,1,'vert');
insert into seza values(6,1,'vert');
insert into seza values(7,1,'vert');
insert into seza values(8,1,'vert');
insert into seza values(9,1,'vert');
insert into seza values(10,1,'vert');

insert into seza values(11,2,'vert');
insert into seza values(12,2,'vert');
insert into seza values(13,2,'vert');
insert into seza values(14,2,'vert');
insert into seza values(15,2,'vert');
insert into seza values(16,2,'vert');
insert into seza values(17,2,'vert');
insert into seza values(18,2,'vert');
insert into seza values(19,2,'vert');
insert into seza values(20,2,'vert');

insert into seza values(21,3,'vert');
insert into seza values(22,3,'vert');
insert into seza values(23,3,'vert');
insert into seza values(24,3,'vert');
insert into seza values(25,3,'vert');
insert into seza values(26,3,'vert');
insert into seza values(27,3,'vert');
insert into seza values(28,3,'vert');
insert into seza values(29,3,'vert');
insert into seza values(30,3,'vert');

insert into seza values(31,4,'vert');
insert into seza values(32,4,'vert');
insert into seza values(33,4,'vert');
insert into seza values(34,4,'vert');
insert into seza values(35,4,'vert');
insert into seza values(36,4,'vert');
insert into seza values(37,4,'vert');
insert into seza values(38,4,'vert');
insert into seza values(39,4,'vert');
insert into seza values(40,4,'vert');

insert into seza values(41,5,'vert');
insert into seza values(42,5,'vert');
insert into seza values(43,5,'vert');
insert into seza values(44,5,'vert');
insert into seza values(45,5,'vert');
insert into seza values(46,5,'vert');
insert into seza values(47,5,'vert');
insert into seza values(48,5,'vert');
insert into seza values(49,5,'vert');
insert into seza values(50,5,'vert');

insert into seza values(51,6,'vert');
insert into seza values(52,6,'vert');
insert into seza values(53,6,'vert');
insert into seza values(54,6,'vert');
insert into seza values(55,6,'vert');
insert into seza values(56,6,'vert');
insert into seza values(57,6,'vert');
insert into seza values(58,6,'vert');
insert into seza values(59,6,'vert');
insert into seza values(60,6,'vert');