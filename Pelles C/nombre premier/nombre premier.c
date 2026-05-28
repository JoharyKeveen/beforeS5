#include <stdio.h>
void main()
{
	int nb;
	nb=1;
	while(nb<=120)
	{
		if(nb==1||nb!=2&&nb%2==0||nb!=3&&nb%3==0||nb!=5&&nb%5==0||nb!=7&&nb%7==0)
		{
			printf("%i est compose\n",nb);
		}
		else
		{
			printf("%i est premier\n", nb);
		}
		nb=nb+1;
	}
	double x=1035125;
	double val=x*x;
	printf("%g",val);
}
