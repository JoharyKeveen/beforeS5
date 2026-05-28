#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void main()
{
	char c[]="je mange avec le prof";
	char**tab=malloc(5*sizeof(char*));
	tab[0]=strtok(c, " ");
	for(int i=1;i<5;i++)
	{
		tab[i]=strtok(NULL, " ");
	}
	printf("%s\n",tab[2]);
}
