#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct date{
	int j;
	int m;
	int a;
};
typedef struct date date;

struct alimentation{
	char* nom;
	double pu;
};
typedef struct alimentation alimentation;

struct race{
	char* race;
	char* pays;
};
typedef struct race race;

struct chien{
	char* nom;
	race rac;
	date dtn;
	alimentation Alimentation;
	double poidsAlimentationJour;
	int dureeMoisEnfant;
	double prixVente;
};
typedef struct chien chien;


int dateComp(date d1, date d2)
{
	int D1=d1.j+d1.m*30+d1.a*12*30;
	int D2=d2.j+d2.m*30+d2.a*12*30;
	if((D1-D2)==0)
	{
		return 0;
	}
	else if((D1-D2)>0)
	{
		return -1;
	}
	else
	{
		return 1;
	}
}

date addM(date D, int nbM)
{
	int resAdd=D.m + nbM;
	D.m=resAdd;
	while(D.m>12)
	{
		D.m= D.m-12;
		D.a= D.a+1;
	}
	return D;
}

chien* searchD(chien* dog,date dateV, int nbdogo)
{
	int* dateA=malloc(nbdogo*sizeof(int));;
	int nb_res=0;
	int dateV_res=dateV.a*12*30+dateV.m*30+dateV.j;
	for(int i=0; i<nbdogo; i++)
	{
		dateA[i]=(dog[i].dtn.a*12*30+dog[i].dtn.m*30+dog[i].dtn.j)+(dog[i].dureeMoisEnfant*30);
		if(dateA[i]>=dateV_res) nb_res++;
	}
	chien* res=malloc(nb_res*sizeof(chien));
	int b=0;
	for(int a=0; a>nbdogo; a++)
	{
		if(dateA[a]>=dateV_res)
		{
			res[b]=dog[a];
		}
	}
	return res;
}

chien* selectD(chien* dog,int nbdogo)
{
	chien perm;
	for(int a=0; a<nbdogo; a++)
	{
		for(int b=0; b<nbdogo; b++)
		{
			if(((dog[a].dtn.a*12*30+dog[a].dtn.m*30+dog[a].dtn.j)+(dog[a].dureeMoisEnfant*30)) > ((dog[b].dtn.a*12*30+dog[b].dtn.m*30+dog[b].dtn.j)+(dog[b].dureeMoisEnfant*30)))
			{
				perm=dog[a];
				dog[a]=dog[b];
				dog[b]=perm;
			}
		}
	} 
	return dog;
}

chien* sameP(chien* dog,date naissance, race R, int nbdogo)
{
	int n=naissance.a*12*30+naissance.m*30+naissance.j;
	chien* res=malloc(nbdogo*sizeof(chien));
	int a=0;
	for(int i=0; i<nbdogo; i++)
	{
		if((dog[i].dtn.a*12*30+dog[i].dtn.m*30+dog[i].dtn.j)== n && strcmp(dog[i].rac.race,R.race)==0)
		{
			res[a]=dog[i];
			a++;
		}
	}
	return res;
}
/*void main()
{
	chien d1;
	d1.dtn.a=2022;
	d1.dtn.m=2;
	d1.dtn.j=25;
	d1.dureeMoisEnfant=5;
	d1.nom="faly";

	chien d2;
	d2.dtn.a=2022;
	d2.dtn.m=2;
	d2.dtn.j=1;
	d2.dureeMoisEnfant=4;
	d2.nom="tsyfaly";

	chien d3;
	d3.dtn.a=2022;
	d3.dtn.m=1;
	d3.dtn.j=20;
	d3.dureeMoisEnfant=6;
	d3.nom="tsyfaly2";

	chien d4;
	d4.dtn.a=2021;
	d4.dtn.m=10;
	d4.dtn.j=25;
	d4.dureeMoisEnfant=5;
	d4.nom="Faly_be";

	date dateV;
	dateV.a=2022;
	dateV.m=3;
	dateV.j=5;


	chien* dogo=malloc(nbdogo*sizeof(dogo));
	dogo[0]=d1;
	dogo[1]=d2;
	dogo[2]=d3;
	dogo[3]=d4;

	chien* result= searchD(dogo,dateV,nbdogo);

	for(int a=0; a<nbdogo; a++)
	{
		printf("%s",result[0].nom);
	}
}*/
