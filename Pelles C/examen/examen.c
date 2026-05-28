#include <stdio.h>
#include <stdlib.h>
#include <string.h>

double noteComp(char*c1,char*c2)
{
	double init=0;
	for(int i=0; c1[i]!='\0'; i++)
	{
		if(c1[i]==c2[i])
		{
			init++;
		}
	}
	double t=strlen(c1);
	double note=(init/t)*100;
	return note;
}

char***allo3D(int t1, int t2, int t3)
{
	char***tab=malloc(t1*sizeof(char**));
	for(int a=0; a<t1;a++)
	{
		tab[a]=malloc(t2*sizeof(char*));
		for(int b=0;b<t2;b++)
		{
			tab[a][b]=malloc(t3*sizeof(char));
		}
	}
	return tab;
}

char***GetAllWord(void)
{
	char***trad=allo3D(2,5,11);
	trad[0][0]="je";
	trad[0][1]="mange";
	trad[0][2]="avec";
	trad[0][3]="le";
	trad[0][4]="professeur";

	trad[1][0]="i";
	trad[1][1]="eat";
	trad[1][2]="with";
	trad[1][3]="the";
	trad[1][4]="professor";
	
	return trad;
}

char*traduction(char*teny)
{
	char***mot=GetAllWord();
	for(int i=0; i<6; i++)
	{
		if(mot[0][i]==teny)
		{
			return mot[1][i];
		}
	}
	return "aucune traduction possible";
}

char*translation(char*teny)
{
	char***word=GetAllWord();
	double*tab=malloc(5*sizeof(double));
	for(int n=0;n<5;n++)
	{
	tab[n]=noteComp(teny,word[1][n]);
	}

	double max=*tab;
	for(int i=0; i<6; i++)
	{
		if(tab[i]>max)
		{
			max=tab[i];
		}
	}

	for(int a=0;a<6;a++)
	{
		if(noteComp(teny,word[1][a])==max)
		{
			return word[0][a];
		}
	}
	return "no translation possible";
}

char*langue(char*phrase)
{
	char***word=GetAllWord();
	char**piece=malloc(5*sizeof(char*));
	piece[0]=strtok(phrase, " ");
	for(int i=1;i<5;i++)
	{
		piece[i]=strtok(NULL, " ");
	}

	double*frs=malloc(5*sizeof(double));
	for(int n=0;n<5;n++)
	{
		frs[n]=noteComp(piece[n],word[0][n]);
	}

	double*ang=malloc(5*sizeof(double));
	for(int n=0;n<5;n++)
	{
		ang[n]=noteComp(piece[n],word[1][n]);
	}

	double francais=frs[0]+frs[1]+frs[2]+frs[3]+frs[4];
	double anglais=ang[0]+ang[1]+ang[2]+ang[3]+ang[4];


	if(anglais<francais)
	{
		char*P1="langue francaise";
		return P1;
	}
	else if(anglais>francais)
	{
		char*P2="langue anglaise";
		return P2;
	}
}

int main (void)
{
	char*c1=malloc(7*sizeof(char));
	c1[0]='m';
	c1[1]='a';
	c1[2]='n';
	c1[3]='g';
	c1[4]='e';
	c1[5]='r';
	c1[6]='\0';
	char*c2=malloc(7*sizeof(char));
	c2[0]='m';
	c2[1]='a';
	c2[2]=' ';
	c2[3]='g';
	c2[4]='e';
	c2[5]='r';
	c2[6]='\0';
	double x=noteComp(c1,c2);
	printf("la note est %g\n",x);

	char*c3="avec";
	char*trad=traduction(c3);
	printf("%s\n",trad);

	char*c4="prof";
	char*trans=translation(c4);
	printf("%s\n",trans);
	
	char*c5="je mange avec le professeur";
	char*tap=langue(c5);
	printf("%s\n",tap);
}


