#include <stdio.h>
#include <math.h>

float f(float x);
void displayResult(float a,float b,float aire);
float simpson(float a,float b,float n);
int main()
{
	printf("Integration de f entre a et b\n");
/// Donnees
	float a=0, b=1; 	//bornes de l'integrale
	float aire=4554; 	//l'integrale a calculer 
	int n=10;
	
/// Traitement
	aire=simpson(a,b,n);
	
/// Sortie de resultats
	displayResult(a, b, aire);
	return 0;
}
float simpson(float a,float b,float n)
{
	float aire=0;
	float s1=0,s2=0;		// pour la sommation
	float h=0.1,				// pas de discretisation
		  x2=0,
		  x=0;
		  h=(b-a)/n;
		  float i=0;
	x=a;  s1=0;			
	for(int i=1; i<n; i++)
	{
		x +=h;
		printf("x1==%g",x);
		s1 +=f(x);
	}
	while(i<n)
	{
		float temp=i/10;
		x2=temp+0.05;
		s2 += f(x2);
		i++;
	}
	aire=h/6*(f(a)+2*s1+f(b)+4*s2);
	return aire;
}
void displayResult(float a,float b,float aire){
	printf("L'integrale de f entre %g et %g est:\n",a,b);
	printf("aire = %g\n",aire);

}
float f(float x)
{
	return exp(sin(5*x));
}

