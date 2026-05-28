#include <stdio.h>
void main()
{
	int nbr=11;
	while (nbr<=99)
	{
		int diz=nbr/10;
		int unit=nbr-(diz*10);
		if((diz+unit)*2==nbr)
		{
			printf("le nombre est %i", nbr);
		}
		nbr=nbr+1;
	}
}









