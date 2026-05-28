#include <stdio.h>
#include <stdlib.h>
double somme(double*nbr, int n)
{
	double init=0;
	for(int i=0; i<n;i++)
		{
			init=init+*(nbr+i);
		}
	return init;
}

double moyenne(double*nbr, int n)
{
	double so=somme(nbr,n);
	double m=so/n;
	return m;
}


double VA(double nbr)
{
	if(nbr<=0)
		{
			nbr=nbr*(-1);
			return nbr;
		}
	else
		{
			return nbr;
		}
}

double ET(double *nbr,double nb)
{
	double moy=moyenne(nbr,nb);
	double total=0;
	for(int i=0;i<nb;i++)
	{
		double note=VA(*(nbr+i)-moy);
		total=total+note;
	}
	double res=total/nb;
	return res;
}

double valeurProche(double*nbr, double t)
{
	double moy=moyenne(nbr,t);
	double valp=*(nbr+0);
	double init=VA(*(nbr+0));
	for(int i=0;i<t;i++)
	{
		if(VA(*(nbr+i)-moy)<init)
		{
				valp=*(nbr+i);
				init=VA(*(nbr+i)-moy);
		}
	}
	return valp;
}

double minMax(double*tab, int t)
{
	double min=*(tab+0);
	double max=*tab;
	for(int i=0; i<t;i++)
	{
		if(*(tab+i)<min)
		{
			min=*(tab+i);
		}
	}
	printf("\nle minimum est %g \n",min);

	for(int i=0;i<t;i++)
	{
		if(*(tab+i)>max)
		{
			max=*(tab+i);
		}
	}
	printf("\nle maximum est %g \n",max);

	double moy=moyenne(nbr,t);
	double valp=*(nbr+0);
	double init=VA(*(nbr+0));
	for(int i=0;i<t;i++)
	{
		if(VA(*(nbr+i)-moy)<init)
		{
				valp=*(nbr+i);
				init=VA(*(nbr+i)-moy);
		}
	}
	return valp;


}
void main()
{
	int nb=5;
	double*nbr=malloc(nb*sizeof(double));
	*(nbr+0)=7.5;
	*(nbr+1)=7.4;
	*(nbr+2)=7.3;
	*(nbr+3)=7.1;
	*(nbr+4)=7.2;

	for(int i=0; i<nb;i++)
		{
			printf("tableau %i  Valeur %g \n",i,*(nbr+i));
		}

	double s=somme(nbr,nb);
	printf("\nla somme est %g\n",s);
	double mo=moyenne(nbr,nb);
	printf("\nla moyenne est %g\n", mo);
	double et=ET(nbr,nb);
	printf("\nl'ecart type est %g\n", et);
	double valp=valeurProche(nbr,nb);
	printf("\nle plus proche est %g\n",valp);
	double valiny=minMax(nbr,nb);
	printf("\n%g",valiny);


}
