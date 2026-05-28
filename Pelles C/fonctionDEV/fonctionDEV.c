
//reste , paire, premier//
#include <stdio.h>
#include <stdlib.h>
#include<string.h>

int reste(int nb, int diviseur)
{
	int q=nb/diviseur;
	int r=nb-q*diviseur;
	return r;
}

/*char paire(char nb)
{
	
	if(reste(nb,2)==0)
		{
			char rep='E';
			printf("%c",rep);
		}
	else
		{
			char repo='T';
			printf("%c", repo);
		}
}*/

char*premier(double nb)
{
	double a;
		a=2;
	while(a<nb)
		{
			if(reste(nb,a)==0)
			{
				return "ce nombre est composer";	
			}
			a++;
		}
	return "ce nombre est premier";
}

void main()
{
	char*b;
	b=premier(2);
	printf("%s\n", b);

}

