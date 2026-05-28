
create database Foot;
use Foot;

create table equipe(
nom varchar(20),
pt integer,
poules varchar(5)
);

create table match(
equipe1 varchar(20),
equipe2 varchar(20),
score1 int,
score2 int,

);

INSERT INTO equipe VALUES ('Equateur',0,'A');
INSERT INTO equipe VALUES ('Senegal',0,'A');
INSERT INTO equipe VALUES ('Pays-Bas',0,'A');
INSERT INTO equipe VALUES ('Qatar',0,'A');

INSERT INTO equipe VALUES ('Angleterre',0,'B');
INSERT INTO equipe VALUES ('Etat-unis',0,'B');
INSERT INTO equipe VALUES ('Iran',0,'B');
INSERT INTO equipe VALUES ('Pays de Galles',0,'B');

INSERT INTO equipe VALUES ('Arabie Saoudite',0,'C');
INSERT INTO equipe VALUES ('Argentine',0,'C');
INSERT INTO equipe VALUES ('Mexique',0,'C');
INSERT INTO equipe VALUES ('Pologne',0,'C');

INSERT INTO equipe VALUES ('Australie',0,'D');
INSERT INTO equipe VALUES ('Danemark',0,'D');
INSERT INTO equipe VALUES ('France',0,'D');
INSERT INTO equipe VALUES ('Tunisie',0,'D');

INSERT INTO equipe VALUES ('Allemagne',0,'E');
INSERT INTO equipe VALUES ('Costa Rica',0,'E');
INSERT INTO equipe VALUES ('Espagne',0,'E');
INSERT INTO equipe VALUES ('Japon',0,'E');

INSERT INTO equipe VALUES ('Belgique',0,'F');
INSERT INTO equipe VALUES ('Canada',0,'F');
INSERT INTO equipe VALUES ('Croatie',0,'F');
INSERT INTO equipe VALUES ('Maroc',0,'F');

INSERT INTO equipe VALUES ('Bresil',0,'G');
INSERT INTO equipe VALUES ('Cameroun',0,'G');
INSERT INTO equipe VALUES ('Serbie',0,'G');
INSERT INTO equipe VALUES ('Suisse',0,'G');

INSERT INTO equipe VALUES ('Coree de Sud',0,'H');
INSERT INTO equipe VALUES ('Ghana',0,'H');
INSERT INTO equipe VALUES ('Portugal',0,'H');
INSERT INTO equipe VALUES ('Uruguay',0,'H');

