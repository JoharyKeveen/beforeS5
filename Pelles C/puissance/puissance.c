#include <stdio.h>
int power (int nb,int n)
{
	int p=1;
	int res=1;
	while(p<=n)
		{
			res=res*nb;
			p++;
		}
	return res;
}

void main()
{
	int zvtr=5;
	int puis=3;
	int x=power(zvtr,puis);
	printf("la valeur est %i", x);

}

