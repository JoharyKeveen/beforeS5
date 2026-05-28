create database ensemble;
\c ensemble

drop table genre cascade;
drop table diplome cascade;
drop table specialite cascade;
drop table employe cascade;
drop table lienspecialiteemploye cascade;
drop table emploi cascade;
drop table service cascade;
drop table employee_service cascade;
drop table materielservice cascade;
drop table materiel cascade;


create table genre(
                      id serial primary key,
                      nom varchar(40)
);

create table diplome(
                        id serial primary key,
                        nom varchar
);

create table specialite(
                           id SERIAL PRIMARY KEY,
                           nom VARCHAR
);

create table Emploi(
                       id serial primary key,
                       nom varchar(40),
                       salairemensuel real,
                       debutdureesalaire date,
                       findureesalaire date
);

create table employe(
                        id SERIAL PRIMARY KEY,
                        nom VARCHAR(40),
                        prenom VARCHAR(40),
                        idgenre INT constraint FK_idgenre references genre,
                        date_naissance DATE,
                        iddiplome INT constraint FK_iddiplome references diplome,
                        idemploi INT constraint FK_idemploi references emploi
);

create table lienspecialiteemploye(
                                      idemploye INT constraint FK_idemploye references employe,
                                      idspecialite INT constraint FK_idspecialite references specialite
);

create table Service(
                        id serial primary key,
                        nom varchar(40),
                        montant real,
                        margebeneficiaire real
);

create table Employee_Service(
                                 EmployeeId INT constraint FK_EmployeeId references employe,
                                 ServiceId INT constraint FK_ServiceId references service,
                                 dureeminuteemployee real
);

drop view v_salairemensuel;
drop view v_listeemployer;

drop view v_salairemensuel;

Create view v_salairemensuel AS
select m.id idemploye, e.salairemensuel salaire from Emploi e
JOIN employe m ON e.id= m.idemploi;

drop view v_listeemployer;

Create view v_listeemployer
AS select * from employe e
                     JOIN Employee_Service a ON e.id= a.EmployeeId
;

create table materiel(
                         id serial,
                         nom varchar(40),
                         prixunitaire real,
                         primary key(id)
);

create table materielservice(
                                idmateriel int,
                                unite real,
                                idservice int,
                                foreign key(idmateriel) references materiel(id),
                                foreign key(idservice) references service(id)
);

drop view vSommeMateriel;

create or replace view vSommeMateriel as
select materielservice.unite*m.prixunitaire somme, materielservice.idservice idservice from materielservice
                                                                                                join materiel m on materielservice.idmateriel = m.id
                                                                                                join service s on materielservice.idservice = s.id;

select sum(somme) somme from vSommeMateriel where idservice=1;

insert into public.genre values(1,'homme');
insert into public.genre values(2,'femme');

insert into public.diplome(nom) values('BACC');
insert into public.diplome(nom) values('License');
insert into public.diplome(nom) values('Master');

insert into public.specialite(nom) values('Mecanicien');
insert into public.specialite(nom) values('Mecanicien pro');
insert into public.specialite(nom) values('Mecanicien medium');

insert into emploi(nom,salairemensuel,debutdureesalaire,findureesalaire) values ('mec1',100000,'2000-01-01','2000-01-01');
insert into emploi(nom,salairemensuel,debutdureesalaire,findureesalaire) values ('mec2',200000,'2000-01-01','2000-01-01');
insert into emploi(nom,salairemensuel,debutdureesalaire,findureesalaire) values ('mec3',300000,'2000-01-01','2000-01-01');

insert into employe(nom,prenom,date_naissance,idgenre,iddiplome,idemploi) values ('jean','bas','2000-01-01',1,1,1);
insert into employe(nom,prenom,date_naissance,idgenre,iddiplome,idemploi) values ('jean','paul','2001-01-01',1,2,2);
insert into employe(nom,prenom,date_naissance,idgenre,iddiplome,idemploi) values ('jean','laborde','2002-01-01',1,2,3);

insert into service(nom,montant,margebeneficiaire) values ('vidange1',100000,20);
insert into service(nom,montant,margebeneficiaire) values ('vidange2',200000,30);
insert into service(nom,montant,margebeneficiaire) values ('vidange3',300000,10);

insert into employee_service(employeeid,serviceid,dureeminuteemployee) values (1,1,60);
insert into employee_service(employeeid,serviceid,dureeminuteemployee) values (2,1,30);
insert into employee_service(employeeid,serviceid,dureeminuteemployee) values (3,1,40);

insert into materiel(nom,prixunitaire) values ('huile',1000);
insert into materiel(nom,prixunitaire) values ('savon',2500);
insert into materiel(nom,prixunitaire) values ('essence',3000);

insert into materielservice(idmateriel,unite,idservice) values (1,3,1);
insert into materielservice(idmateriel,unite,idservice) values (2,4,1);
insert into materielservice(idmateriel,unite,idservice) values (3,2,1);
insert into materielservice(idmateriel,unite,idservice) values (2,5,2);
insert into materielservice(idmateriel,unite,idservice) values (3,5,2);
insert into materielservice(idmateriel,unite,idservice) values (3,3,3);
