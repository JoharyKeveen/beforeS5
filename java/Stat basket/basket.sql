create sequence seq_team start with 1;
create sequence seq_player start with 1;
create sequence seq_matche start with 1;
create sequence seq_chrono start with 1;
create view vtir as(select*from statis where action='tir');
create view passD as(select*from statis where action='passD');
create view RebondD as(select*from statis where action='rebondDeff');
create view RebondO as(select*from statis where action='rebondOff');
create table team(
	idteam varchar(5) primary key,
	name varchar(20)
);
create table chrono(
	idchrono varchar(5),
    idmatche varchar(5),
    idsend varchar(5),
    idreceive varchar(5),
    fotoana number(15)
);
create table player(
	idplayer varchar(5) primary key,
	idteam varchar(5),
	name varchar(20),
	foreign key (idteam) references team(idteam)
);
create table matche(
	idmatche varchar(5) primary key,
	teama varchar(20),
	scora int,
	teamb varchar(20),
	scorb int,
	daty number
);
create table statis(
	idplayer varchar(5),
	idmatche varchar(5),
	action varchar(15),
	nb int,
	foreign key (idplayer) references player(idplayer),
	foreign key (idmatche) references matche(idmatche)
);