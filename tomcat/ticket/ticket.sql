delete from promotion where fin<current_timestamp;
connect sys as sysdba

drop user ticketing cascade;
CREATE USER ticketing IDENTIFIED BY ticket;
GRANT ALL PRIVILEGES TO ticketing;
connect ticketing;
ticket

create sequence seqReservation start with 1;

create table client(
    id int primary key not null,
    nom VARCHAR2(50)
);
create table evenement(
    id int primary key not null,
    nom VARCHAR2(50),
    validation double precision,
    daty Date
);
create table zone(
    id int primary key not null,
    idEvent int,
    nom VARCHAR2(50),
    prix double precision,
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);
create table seza(
    id int primary key not null,
    idZone int,
    idEvent int,
    num int,
    etat VARCHAR2(10),
    FOREIGN KEY (idZone) REFERENCES zone(id),
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);
create table sezaL(
    id int primary key not null,
    idEvent int,
    nombre int,
    prix double precision,
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);
create table promotion(
    id int primary key not null,
    idEvent int,
    debut DATE,
    fin DATE,
    valeur double precision,
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);
create table reservation(
    id int primary key not null,
    idClient int,
    idEvent int,
    entre Date,
    FOREIGN KEY (idClient) REFERENCES client(id),
    FOREIGN KEY (idEvent) REFERENCES evenement(id)
);
create table detres(
    idReservation int,
    idSeza int,
    FOREIGN KEY (idSeza) REFERENCES seza(id),
    FOREIGN KEY (idReservation) REFERENCES reservation(id)
);
insert into client values(1,'Tahiry');
insert into client values(2,'Johary');
insert into client values(3,'Jean');

insert into evenement values(1,'mahaleo',3600,TO_DATE('2023-02-04 14:00:00','yyyy-mm-dd hh24:mi:ss'));
insert into evenement values(2,'OBOY',3600,TO_DATE('2023-02-04 20:00:00','yyyy-mm-dd hh24:mi:ss'));

insert into zone values(1,1,'zone A',40000);
insert into zone values(2,1,'zone B',30000);
insert into zone values(3,1,'zone C',20000);

insert into zone values(4,2,'zone A',40000);
insert into zone values(5,2,'zone B',30000);
insert into zone values(6,2,'zone C',20000);

insert into sezaL values(1,1,3000,10000);
insert into sezaL values(2,2,4000,10000);

insert into seza values(1,1,1,1,'vert');
insert into seza values(2,1,1,2,'vert');
insert into seza values(3,1,1,3,'vert');
insert into seza values(4,1,1,4,'vert');
insert into seza values(5,1,1,5,'vert');
insert into seza values(6,1,1,6,'vert');
insert into seza values(7,1,1,7,'vert');
insert into seza values(8,1,1,8,'vert');
insert into seza values(9,1,1,9,'vert');
insert into seza values(10,1,1,10,'vert');

insert into seza values(11,2,1,11,'vert');
insert into seza values(12,2,1,12,'vert');
insert into seza values(13,2,1,13,'vert');
insert into seza values(14,2,1,14,'vert');
insert into seza values(15,2,1,15,'vert');
insert into seza values(16,2,1,16,'vert');
insert into seza values(17,2,1,17,'vert');
insert into seza values(18,2,1,18,'vert');
insert into seza values(19,2,1,19,'vert');
insert into seza values(20,2,1,20,'vert');

insert into seza values(21,3,1,21,'vert');
insert into seza values(22,3,1,22,'vert');
insert into seza values(23,3,1,23,'vert');
insert into seza values(24,3,1,24,'vert');
insert into seza values(25,3,1,25,'vert');
insert into seza values(26,3,1,26,'vert');
insert into seza values(27,3,1,27,'vert');
insert into seza values(28,3,1,28,'vert');
insert into seza values(29,3,1,29,'vert');
insert into seza values(30,3,1,30,'vert');

insert into seza values(31,4,2,1,'vert');
insert into seza values(32,4,2,2,'vert');
insert into seza values(33,4,2,3,'vert');
insert into seza values(34,4,2,4,'vert');
insert into seza values(35,4,2,5,'vert');
insert into seza values(36,4,2,6,'vert');
insert into seza values(37,4,2,7,'vert');
insert into seza values(38,4,2,8,'vert');
insert into seza values(39,4,2,9,'vert');
insert into seza values(40,4,2,10,'vert');

insert into seza values(41,5,2,11,'vert');
insert into seza values(42,5,2,12,'vert');
insert into seza values(43,5,2,13,'vert');
insert into seza values(44,5,2,14,'vert');
insert into seza values(45,5,2,15,'vert');
insert into seza values(46,5,2,16,'vert');
insert into seza values(47,5,2,17,'vert');
insert into seza values(48,5,2,18,'vert');
insert into seza values(49,5,2,19,'vert');
insert into seza values(50,5,2,20,'vert');

insert into seza values(51,6,2,21,'vert');
insert into seza values(52,6,2,22,'vert');
insert into seza values(53,6,2,23,'vert');
insert into seza values(54,6,2,24,'vert');
insert into seza values(55,6,2,25,'vert');
insert into seza values(56,6,2,26,'vert');
insert into seza values(57,6,2,27,'vert');
insert into seza values(58,6,2,28,'vert');
insert into seza values(59,6,2,29,'vert');
insert into seza values(60,6,2,30,'vert');

insert into promotion values(1,2,TO_DATE('2023-01-30','yyyy-mm-dd'),TO_DATE('2023-02-04','yyyy-mm-dd'),20);

create view diffTime as
select id,(sysdate - entre)*24*60*60 as diff from reservation;

commit;