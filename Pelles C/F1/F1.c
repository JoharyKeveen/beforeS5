#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct pilote
{
	char*nom;
	double salaire;
	double vitesse; 
};

struct moteur
{
	double puissance;
	double consommation;
};

struct voiture
{
	char*marque;
	double aerodinamisme;
	struct moteur mot;
};

struct F1
{
	struct pilote pilote;
	struct voiture voiture;
};
typedef struct F1 fiara;

void af(struct F1 f1)
{
	printf("la marque de la voiture de %s est une %s.\n",f1.pilote.nom,f1.voiture.marque);
}

char* classement(fiara F)
{
	F=malloc(t*sizeof(char));
	for(int i=0; i<t; i++)
	{

	}

}

void main()
{
	fiara f1,f2;
		f1.pilote.nom="Achyl";
		f1.pilote.salaire=9999;
		f1.pilote.vitesse=250;
		f1.voiture.aerodinamisme=700;
		f1.voiture.marque="Mercedes";
		f1.voiture.mot.consommation=9;
		f1.voiture.mot.puissance=1000;

		f2.pilote.nom="Jean";
		f2.pilote.salaire=1000;
		f2.pilote.vitesse=200;
		f2.voiture.aerodinamisme=200;
		f2.voiture.marque="Audi";
		f2.voiture.mot.consommation=7;
		f2.voiture.mot.puissance=800;

	double asa1=f1.pilote.vitesse+f1.voiture.aerodinamisme+f1.voiture.mot.puissance;
	double asa2=f2.pilote.vitesse+f2.voiture.aerodinamisme+f2.voiture.mot.puissance;

	if(asa1>asa2)
	{
		af(f1);
		af(f2);
	}
	else
	{
		af(f2);
		af(f1);
	}

}

