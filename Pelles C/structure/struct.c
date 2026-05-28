#include "stdio.h"
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
	struct pilote Pilote;
	struct moteur mot;
};
struct F1
{
	struct pilote Pilote;
	struct voiture vot;
};
void afficher(struct pilote pil)
{
	printf("pilote %s son salaire= %g\n",pil.nom,pil.salaire);
	printf("pilote %s sa vitesse= %g\n",pil.nom,pil.vitesse);
}
void aff(struct voiture vot)
{
	printf("voiture marque %s",vot.marque);
	printf("voiture aerodinamisme=%g\n",vot.aerodinamisme);
	printf("voiture puissance=%g\n",vot.mot.puissance);
	printf("voiture consommation=%g\n",vot.mot.consommation);

}
void main()
{

struct pilote p1,p2;
	p1.salaire=19;			
	p1.vitesse=120;
	p1.nom="Movackic";
	p2.salaire=90;
	p2.vitesse=140;
	p2.nom="Kavinski";
struct voiture vot1,vot2;
	vot1.marque="Audi TT";
	vot1.aerodinamisme=120;
	vot1.mot.puissance=1200;
	vot1.mot.consommation=32;
	vot2.marque="Ford";
	vot2.aerodinamisme=1900;
	vot2.mot.puissance=720;
	vot2.mot.consommation=73;
		aff(vot2);
		aff(vot1);
		afficher(p1);
		afficher(p2);
struct F1 flw1,flw2;
	flw1.Pilote.nom=
	


}
