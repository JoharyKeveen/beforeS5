
create table utilisateur(
    id_utilisateurs int primary key auto_increment,
    username varchar(20),
    email varchar(20),
    mdp varchar(20),
    etat int 
);
create table categorie(
    id_categorie int primary key auto_increment,
    nom varchar(20)
);
create table objet(
    id_objet int primary key auto_increment,
    id_categorie int,
    id_prop int,
    titre varchar(20),
    descriptions varchar(70),
    prix float,
    foreign key(id_categorie) references categorie(id_categorie),
    foreign key(id_prop) references utilisateur(id_utilisateurs)
);
create table photo(
    id_objet int,
    photo varchar(20),
    foreign key (id_objet) references objet(id_objet)
);
create table proposition(
    id int primary key auto_increment,
    id_objet_prop int,
    id_prop int,
    id_objet_ech int,
    id_ech int,
    foreign key(id_prop) references utilisateur(id_utilisateurs),
    foreign key(id_ech) references utilisateur(id_utilisateurs),
    foreign key(id_objet_prop) references objet(id_objet),
    foreign key(id_objet_ech) references objet(id_objet)
);
create table historique(
    id int primary key auto_increment,
    id_ech int,
    id_objet_ech int,
    id_prop int,
    id_objet_prop int,
    daty DATETIME,
    foreign key(id_prop) references utilisateur(id_utilisateurs),
    foreign key(id_ech) references utilisateur(id_utilisateurs),
    foreign key(id_objet_prop) references objet(id_objet),
    foreign key(id_objet_ech) references objet(id_objet)
);

insert into utilisateur values(null,'bob','bob@gmail.com','0000',0);
insert into utilisateur values(null,'alice','alice@gmail.com','0000',0);
insert into utilisateur values(null,'admin','admin@gmail.com','admin',1);

insert into categorie values(null,'technologie');
insert into categorie values(null,'vetement');
insert into categorie values(null,'livre');
insert into categorie values(null,'DVD');

insert into objet values(null,1,1,'Tele vintage','tres bon etat',150000);
insert into objet values(null,1,1,'Galaxy Tab','tablette occasion de seconde main',1500000);
insert into objet values(null,2,1,'Chemise carreaux','En coton Taille Xl',300000);
insert into objet values(null,2,1,'pantalon Cargo','Taille 38 slim',300000);
insert into objet values(null,3,1,'Kuroko Basket','BD ',50000);
insert into objet values(null,3,1,'LeRobert','dictionnaire de poche',45000);
insert into objet values(null,4,1,'Top Gun','Un Film de 2022',100000);
insert into objet values(null,4,1,'Blur','Digital Pc Game',95000);

insert into objet values(null,1,2,'Laptop Microsoft','Laptop ultra slim',1000000);
insert into objet values(null,1,2,'Imprimante Canon','Facile a utiliser et pratique',320000);
insert into objet values(null,2,2,'Nike sb','Pt 41 couleur eclatante',210000);
insert into objet values(null,2,2,'Short','Taille 35 couleur rouge',35000);
insert into objet values(null,3,2,'Cedric','BD',43000);
insert into objet values(null,3,2,'Histoire de france','un livre de Daniel Sassier et Bruno Le Sourd',50000);
insert into objet values(null,4,2,'Tom AND Jerry','original film with 8 episodes',30000);
insert into objet values(null,4,2,'Adobe Photoshop','Beginners Guide',20000);

insert into objet values(null,1,3,'IPhone 14','128go tres bon etat',5500000);
insert into objet values(null,2,3,'Doudoune','tres chaud',30000);
insert into objet values(null,3,3,'Stephen King','thriller',20000);
insert into objet values(null,4,3,'DVD','pour enfants',4500);


insert into photo values(1,'T1.jpg');
insert into photo values(2,'tablette.jpg');
insert into photo values(3,'chemise.jpg');
insert into photo values(4,'pantalon.jpg');
insert into photo values(5,'BD2.jpg');
insert into photo values(6,'dictionnaire.jpg');
insert into photo values(7,'Film1.jpg');
insert into photo values(8,'Jeux.jpg');
insert into photo values(9,'microsoft.jpg');
insert into photo values(10,'imprimante.jpg');
insert into photo values(11,'Nike.jpg');
insert into photo values(12,'Short.jpg');
insert into photo values(13,'BD.jpg');
insert into photo values(14,'histoire.jpg');
insert into photo values(15,'Film2.jpg');
insert into photo values(16,'.jpg');
insert into photo values(17,'teladmin.jpg');
insert into photo values(18,'vadmin.jpg');
insert into photo values(19,'livreadmin.jpg');
insert into photo values(20,'cdadmin.jpg');
