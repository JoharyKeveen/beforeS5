#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char**separer(char*phrase)
{
	int x=strlen(phrase);
	char**mot=malloc(x*sizeof(char*));
	int iMot=0;
	int iLettre=0;
	for(int i=0; i!='\0';i++)
	{
		if(phrase[i]!=' ')
		{
			mot[iMot][iLettre]=phrase[i];
			iLettre++;
		}
		else
		{
			mot[iMot][iLettre]='\0';
			iMot++;
		}
	}
	return mot;
}

/*int nbrMot(char*phrase)
{
	int res=1;
	for(int i=0; i!='\0';i++)
	{
		if(phrase[i]==' ')
		{
			res++;
		}
	}
	return res;
}

char**getsujet(char*phrase)
{
	char**sujet=malloc(9*sizeof(char*));
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
	
	return sujet;
}

char*getverb(char*phrase)
{
	char**s=getsujet(phrase);
	char**m=separer(phrase);
	int n=nbrMot(phrase);
	for(int i=0;i<n;i++)
	{
		if(s[i]==m[i])
		{
			i++;
			return m[i];
		}
	}
}

char**terminaison(char*phrase)
{
	char**v=getverb(phrase);
	int n=strlen(v);
	for(int i=0;i<9;i++)
	{
		if(i!=5)
		{
			v[i][n-1]='e';
		}
	}
	v[0][n]='\0'

	v[1][n]='s';
	v[1][n+1]='\0';

	v[2][n]='\0';
	v[3][n+1]='\0';
	v[4][n+2]='\0';

	v[5][n-1]='o';
	v[5][n]='n';
	v[5][n+1]='s';
	v[5][n+2]='\0';

	v[6][n]='z';
	v[6][n+1]='\0';

	v[7][n]='n';
	v[7][n+1]='t';
	v[7][n+2]='\0';

	v[8][n]='n';
	v[8][n+1]='t';
	v[8][n+2]='\0';
}*/
void main()
{
	char*gt=malloc(9*sizeof(char));
	gt[0]='j';
	gt[1]='e';
	gt[2]=' ';
	gt[3]='d';
	gt[4]='a';
	gt[5]='n';
	gt[6]='s';
	gt[7]='e';
	gt[8]='\0';
	char**x=separer(gt);
	printf("%s",x[0]);
}
