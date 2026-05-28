#include <stdio.h>
#include <stdlib.h>
int comparerDate(int*D1,int*D2,int t)
{
	int jour=D1[0]-D2[0];
	int mois=D1[1]-D2[1];
	int an=D1[2]-D2[2];

	int ecart=(an*365)-((mois*30)+jour);

3
return ecart;
}

void main()
{
	int t=3;
	int*D1=malloc(t*sizeof(int));
	D1[0]=10;
	D1[1]=2;
	D1[2]=2022;

	int*D2=malloc(t*sizeof(int));
	D2[0]=23;
	D2[1]=2;
	D2[2]=2021;

	int x = comparerDate(D1,D2,t);
	printf("la difference est %i",x);
}
