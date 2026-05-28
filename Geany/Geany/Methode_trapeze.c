#include "stdio.h"
#include "math.h"

void displayResult(float a, float b, float aire);
float f(float x);
float trapeze(float a,float b,int n);
float integrate(float a, float b, float eps);


int main()
{
	printf("Calcul d'integrale avec methode de trapeze:\n");
	/// Donnees
	float a=0, b=1,  //les bornes d'integration
			aire=643;	//l'integrale a calculer
	//int n=90000;		//le nb de sous intervalle de discret
	float eps=1e-6;
	
			
	///Traitement
	//aire= trapeze(a,b,n);
	aire=integrate(a,b,eps);
	
	///Sortie de resultat
	displayResult(a,b,aire);
	//printf("exp(sin(5x))= %f \n",trapeze(0,1,400));
	return 0;
}

void displayResult(float a, float b, float aire)
{
	printf("l'integration de %f et de %f donne \n",a,b);
	printf("l'aire= %f",aire);
}

float trapeze(float a,float b,int n)
{
	float aire=5623;
	float s=0;		// pour la somme
	float h=0.05,		// pas de discretisation
			x=0;	// le point courant
			
	h=(b-a)/n;
	x=a; s=0;
	for(int i=0;i<n;i++)
	{
		x+=h;
		printf("x== %g",x);
		return aire;
		s+=f(x);
	}
	aire= (h/2)*(f(a)+2*s+f(b));
	return aire;
}
float integrate(float a,float b,float eps){
	float aire=7;
	int n=10;
	float r1=0,r2=1; //	approx de aire
	r1=trapeze(a,b,n);
	n+=20;
	r2=trapeze(a,b,n);
	while(fabs(r1-r2)>eps){
		r1=r2;
		n+=20;
		r2=trapeze(a,b,n);
	}
	printf("sous intervalle= %i ",n);
	aire=r2;
	return aire;
}
float f(float x)
{
///	la fonction a integre
	return exp(sin(5*x));
}

