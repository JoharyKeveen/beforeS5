#include <stdio.h>
#include <stdlib.h>
int*PGCD(int a, int b)
{
	int*res=malloc(3*sizeof(int));
	int r=1;
	int u1=1;
	int v1=0;
	int u2=0;
	int v2=1;
	while ( r!=0)
	{
		r=a%b;
		int q=(a-r)/b;
		int u=u1-(q*u2);
		int v=v1-(q*v2);
		if(r>0)
		{
			a=b;
			b=r;
			u1=u2;
			u2=u;
			v1=v2;
			v2=v;
		}
		else
		{
			res[0]=b;
			res[1]=u2;
			res[2]=v2;
			return res;
		}
	}
}

void main()
{
	int*x=PGCD(11,280);
	printf("le PGCD  est %i\n %i=u\n%i=v\n",x[0],x[1],x[2]);
}

