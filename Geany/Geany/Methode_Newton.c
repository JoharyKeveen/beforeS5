#include <stdio.h>
#include <math.h>
float newton(float a, float b, float eps);
void displayResult(float a, float b, float resultat);
float f(float x);
float f_prime(float x);
int main()
{
	printf("Methode de Newton:\n");
///	Donnee 
	float a=0.2, b=1;		//borne
	float eps=1e-6;		//Test arret
	float result=0;		//Resultat
///	Traitement
	result=newton(a,b,eps);
///	Sortie de resultat
	displayResult(a,b,result);
	return 0;
}
float newton(float a, float b, float eps)
{
	float x0=a;
	float x1=a-(f(a)/f_prime(a));
	if((x1-a)*(x1-b)>0)
	{
		x0=b;
		x1=b-(f(b)/f_prime(b));
	}
	while(fabs(x1-x0)>eps)
	{
		x0=x1;
		x1=x0-(f(x0)/f_prime(x0));
		printf("x1=%f \n",x1);
	}
	eps=x1;
	return eps;
}
void displayResult(float a, float b, float resultat)
{
	printf("La valeur approximatif de X sur l'intervalle [%g;%g] est:\n",a,b);
	printf("X=%g\n",resultat);
}
float f(float x)
{
	return sin(2*x)-1+x;
}
float f_prime(float x)
{
	//return (0-f(x))/(1-x);
	return 2*cos(2*x)+1;
}
