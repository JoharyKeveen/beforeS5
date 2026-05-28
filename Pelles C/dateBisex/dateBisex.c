#include <stdio.h>
#include <stdlib.h>
int estBisex(int an)
{
	if(an%4==0)
	{

	}
}
int comparerDate(int*D1,int*D2,int t)
{
	int jour=D1[0]-D2[0];
	int mois=D1[1]-D2[1];
	int an=D1[2]-D2[2];

	int ecart=(an*365)-(mois*30)+jour;

	int init1=0;
	int init2=0;

	for(int i=0 ; i<t ; i++)
	{
		init1 = init1 + D1[i] ;
		init2 = init2 + D2[i] ;
	}
return ecart;
}

void main()
{
	int t=3;
	int*D1=malloc(t*sizeof(int));
	D1[0]=10;
	D1[1]=2;
	D1[2]=2004;

	int*D2=malloc(t*sizeof(int));
	D2[0]=20;
	D2[1]=2;
	D2[2]=2004;

	int x = comparerDate(D1,D2,t);
	printf("la difference est %i",x);
}

