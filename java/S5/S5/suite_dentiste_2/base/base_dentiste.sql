CREATE  TABLE "public".genres ( 
	id                   serial  NOT NULL  ,
	genre                varchar(50)  NOT NULL  ,
	CONSTRAINT pk_genres PRIMARY KEY ( id )
 );

CREATE  TABLE "public".niveau_etude ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	rang                 integer  NOT NULL  ,
	CONSTRAINT pk_niveau_etude PRIMARY KEY ( id )
 );

CREATE  TABLE "public".personne ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	prenom               varchar(50)  NOT NULL  ,
	genre                integer  NOT NULL  ,
	date_naissance       date  NOT NULL  ,
	fk_id_etude          integer  NOT NULL  ,
	CONSTRAINT pk_personne PRIMARY KEY ( id ),
	CONSTRAINT fk_personne_genres FOREIGN KEY ( genre ) REFERENCES "public".genres( id ) ON DELETE SET NULL ON UPDATE CASCADE ,
	CONSTRAINT fk_personne_niveau_etude FOREIGN KEY ( fk_id_etude ) REFERENCES "public".niveau_etude( id ) ON DELETE SET NULL ON UPDATE CASCADE 
 );

CREATE  TABLE "public".post ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	salaire              double precision  NOT NULL  ,
	CONSTRAINT pk_post PRIMARY KEY ( id )
 );

CREATE  TABLE "public".service ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_service PRIMARY KEY ( id )
 );

CREATE  TABLE "public".specialiter ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_specialiter PRIMARY KEY ( id )
 );

CREATE  TABLE "public".employer ( 
	id                   serial  NOT NULL  ,
	id_personne          integer  NOT NULL  ,
	date_embauche        date  NOT NULL  ,
	CONSTRAINT pk_employer PRIMARY KEY ( id ),
	CONSTRAINT fk_employer_personne FOREIGN KEY ( id_personne ) REFERENCES "public".personne( id )  ON UPDATE CASCADE 
 );

CREATE  TABLE "public".personne_specialiter ( 
	id_personne          integer  NOT NULL  ,
	id_specialiter       integer  NOT NULL  ,
	CONSTRAINT fk_personne_specialiter FOREIGN KEY ( id_personne ) REFERENCES "public".personne( id )  ON UPDATE CASCADE ,
	CONSTRAINT fk_personne_specialiter2 FOREIGN KEY ( id_specialiter ) REFERENCES "public".specialiter( id )  ON UPDATE CASCADE 
 );

CREATE  TABLE "public".post_service ( 
	id_post              integer  NOT NULL  ,
	id_employer          integer  NOT NULL  ,
	CONSTRAINT fk_post_employer_employer FOREIGN KEY ( id_employer ) REFERENCES "public".employer( id )  ON UPDATE CASCADE ,
	CONSTRAINT fk_post_employer2 FOREIGN KEY ( id_post ) REFERENCES "public".post( id )  ON UPDATE CASCADE 
 );

CREATE  TABLE "public".service_specialiter ( 
	id_service           integer  NOT NULL  ,
	id_post              integer  NOT NULL  ,
	CONSTRAINT fk_service_require_service FOREIGN KEY ( id_service ) REFERENCES "public".service( id )   ,
	CONSTRAINT fk_service_require_specialiter FOREIGN KEY (  ) REFERENCES "public".specialiter(  )   ,
	CONSTRAINT fk_service_specialiter_post FOREIGN KEY ( id_post ) REFERENCES "public".post( id )   
 );
