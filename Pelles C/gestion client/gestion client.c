#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct client{
	char*nom;
	char*prenom;
	char*mail;
	char*date_de_naissance;
};
typedef struct client client;

struct prix{
	double prixHT;
	double taxe;
	double remise;
};
typedef struct prix prix;

struct article{
	char*designation;
	double stock;
	prix prix;
};
typedef struct article article;


struct detail_panier{
	article articl;
	double quantite;
};
typedef struct detail_panier detail_panier;

struct panier{
	client client;
	detail_panier*DP;
};
typedef struct panier panier;

double TTC(article A)
{
	double pt=(A.prix.prixHT*A.prix.taxe)/100;
	double pTTC=A.prix.prixHT+pt;
	return pTTC;
}

double remiser(article A)
{
	double pr=(TTC(A)*A.prix.remise)/100;
	double res=TTC(A)-pr;	
	return res;
}

panier ajouter(panier arona, article zvtr, double nb, double tarona)
{
	for(int i=0; i<tarona; i++)
	{
		if(strcmp(arona.DP[i].articl.designation, zvtr.designation)==0)
		{
			arona.DP[i].quantite = arona.DP[i].quantite+nb;
			return arona;
		}
	}
	int a=tarona;
	arona.DP[a].articl.designation=zvtr.designation;
	arona.DP[a].quantite=nb;
	return arona;
}

panier retirer(panier arona, article zvtr, double nb, double tarona)
{
	for(int i=0; i<tarona; i++)
	{
		if(strcmp(arona.DP[i].articl.designation, zvtr.designation)==0)
		{
			arona.DP[i].quantite = arona.DP[i].quantite-nb;
			if(arona.DP[i].quantite==0)
			{
				for(int a=i+1; a<tarona; a++)
				{
					arona.DP[i].articl.designation=arona.DP[a].articl.designation;
					arona.DP[i].articl.prix=arona.DP[a].articl.prix;
					arona.DP[i].articl.stock=arona.DP[a].articl.stock;
					arona.DP[i].quantite=arona.DP[a].quantite;
				}
			}
			return arona;
		}
	}
}

/*	for(int i=0;i<t;i++)
	{
		if(*(tab+i)>max)
		{
			max=*(tab+i);
		}
	}
	printf("\nle maximum est %g \n",max);

panier best();
*/

void af(panier P,int tarona)
{
	for(int i=0; i<tarona; i++)
	{
		printf("nom de l'article: %s\n quantite: %g \n", P.DP[i].articl.designation, P.DP[i].quantite);
	}
}

int main(void)
{
	panier p1;
	p1.DP=malloc(2*sizeof(p1.DP));
	p1.DP[0].articl.designation="bonbon";
	p1.DP[0].articl.prix.prixHT=100;
	p1.DP[0].quantite=3;
	p1.DP[1].articl.designation="ballon";
	p1.DP[1].articl.prix.prixHT=200;
	p1.DP[1].quantite=4;
	
	article zvtr;
	zvtr.designation="ballon";


	//ajouter(p1,zvtr,3,2);
	//ajouter(p1,"bike",6,3);
	retirer(p1,zvtr,4,2);
	af(p1,2);
}
