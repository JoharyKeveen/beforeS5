#include <stdio.h>
#include <stdlib.h>
char*trans(char*sr1, char*sr2)
{
	for (int i=0; i<100; i++)
	{
		if((sr1[i]-sr2[i])==(32) || (sr1[i]-sr2[i])==(-32))
		{
			sr1[i]=sr2[i];
		}
	}
}

char*espace (char*tab)
{
	for (int e=0; e<100; e++)
	{
		if(tab[e]==32)
		{
			tab[e]=tab[e+1];
		}
	}
}

char*comparer (char*sr1, char*sr2)
{
	int i=0;
	sr1= espace(sr1);
	sr2=espace(sr2);
	trans( sr1, sr2);
	while(sr1[i]!='\0' && sr2[i]!='\0')
	{
		if(sr1[i]==sr2[i])
		{
			i++;
		}
		else
		{
			return "ces chaines sont differentes";
		}
	}
	return "ces chaines sont egales";
}


void main()
{
	int t1=10;
	int t2=10;

	char*ch1=malloc(t1*sizeof(char));
	ch1[0]=' ';
	ch1[1]='B';
	ch1[2]='O';
	ch1[3]='N';
	ch1[4]='J';
	ch1[5]='O';
	ch1[6]='U';
	ch1[7]=' ';
	ch1[8]='r';
	ch1[9]='\0';

	char*ch2=malloc(t2*sizeof(char));
	ch2[0]='b';
	ch2[1]=' ';
	ch2[2]='o';
	ch2[3]='n';
	ch2[4]='j';
	ch2[5]='o';
	ch2[6]=' ';
	ch2[7]='u';
	ch2[8]='r';
	ch2[9]='\0';

	char*a=comparer(ch1,ch2);
	printf(" %s \n", a);
}
