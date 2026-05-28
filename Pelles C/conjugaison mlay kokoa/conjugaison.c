 #include <stdio.h>
#include <stdlib.h>
char*trans(char*sr1, char*sr2)
{
	for (int i=0; i<60; i++)
	{
		if((sr1[i]-sr2[i])==(32) || (sr1[i]-sr2[i])==(-32))
		{
			sr1[i]=sr2[i];
		}
	}
}

char***separer(char*ch)
{
	char**s=malloc(9*sizeof(char*));
}


char*mifidy(char**sujet)
{
	sujet=malloc(9*sizeof(char*));
	sujet[0][0]='j';
	sujet[0][1]='e';
	sujet[0][2]='\0';

	sujet[1][0]='t';
	sujet[1][1]='u';
	sujet[1][2]='\0';

	sujet[2][0]='i';
	sujet[2][1]='l';
	sujet[2][2]='\0';

	sujet[3][0]='e';
	sujet[3][1]='l';
	sujet[3][2]='l';
	sujet[3][3]='e';
	sujet[3][4]='\0';

	sujet[4][0]='o';
	sujet[4][1]='n';
	sujet[4][2]='\0';

	sujet[5][0]='n';
	sujet[5][1]='o';
	sujet[5][2]='u';
	sujet[5][3]='s';
	sujet[5][4]='\0';

	sujet[6][0]='v';
	sujet[6][1]='o';
	sujet[6][2]='u';
	sujet[6][3]='s';
	sujet[6][4]='\0';

	sujet[7][0]='i';
	sujet[7][1]='l';
	sujet[7][2]='s';
	sujet[7][3]='\0';

	sujet[8][0]='e';
	sujet[8][1]='l';
	sujet[8][2]='l';
	sujet[8][3]='e';
	sujet[8][4]='s';
	sujet[8][5]='\0';
}
