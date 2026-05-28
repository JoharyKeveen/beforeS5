#include <stdio.h>
#include <math.h>

float f(float x);
float dicotomie(float a,float b,float eps,int nbTour);
void displayResult(float a,float b,float result,int nbTour);
int main()
{
	printf("Methode de dicotomie:\n");
///	Donnee 
	float a=0.1, b=1;		//Borne 
	float eps=1e-6;		//Test arret
	float result=0;		//Resultat
	int nbTour=0;		//nombre de tour pour resoudre
///	Traitement
	result=dicotomie(a,b,eps,nbTour);
///	Sortie de resultat
	displayResult(a,b,result,nbTour);
	return 0;
}
void displayResult(float a,float b,float result,int nbTour)
{
	printf("La valeur approximatif de X sur l'intervalle [%g;%g] est:\n",a,b);
	printf("X=%g\n",result);
	printf("Ce programme a tourner %i fois avant de trouver la reponse",nbTour);
}
float dicotomie(float a,float b,float eps,int nbTour)
{
	float result=0;
	while(fabs(b-a)>eps)
	{
		result=(a+b)/2;
		if(f(a)*f(result)<0)
		{
			b=result;
		}
		else
		{
			a=result;
		}
		nbTour++;
	}
	return result;
}
float f(float x)
{
	float f=x-2-log(x);
	return f;
}

