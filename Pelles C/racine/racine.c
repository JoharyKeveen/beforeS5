#include <stdio.h>
void main()
{
	int nb=3*9;
	int inc=1;
	int n=3;
	double res=0;
	double borninf=0;
	double diviseur=1000;
	while (borninf<=nb)
	{
		res=res+(1/diviseur);
		borninf=1;
		while(inc<=n)
		{
			borninf=borninf*res;
			inc=inc+1;
		}
		inc=1;
	}
	printf("la racine est %f", res);
}
