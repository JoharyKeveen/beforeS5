#include<stdio.h>
void main()
{
	int a=2;
	int b=3;
	int c=3;
	int aa=4;
	int bb=5;
	int cc=9;
	

	if ((b*aa)-(a*bb)==0)
	{
	printf("\nfalse");
	}
	else
	{
       double y= (c*aa-a*cc)/(b*aa-a*bb);
	double x=(c-b*y)/a;
	
       printf("la valeur de y est %g",y);
	printf("\n la valeur de x est %g",x);
	printf("\ntrue");
	}
}
       
