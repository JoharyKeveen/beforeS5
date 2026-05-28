#include <stdlib.h>
#include <stdio.h>
void problem(char* message);
float **newMat(int dim);
float *newVect(int dim);

int main()
{
	return 0;
}

float **newMat(int dim)
{
	float** A=NULL;
	A=malloc(dim*sizeof(float*));
	if(A==NULL)
	{
		problem("Ne peut allouer une matrice");
	}
	for(int i=0;i<dim;i++)
	{
		A[i]=malloc(dim*sizeof(float));
		if(A[i]==NULL)
		{
			problem("Ne peut allouer une ligne de matrice");
		}
	}
	return A;
}

float *newVect(int dim)
{
	float* V=NULL;
	V=malloc(dim*sizeof(float));
	if(V==NULL)
	{
		problem("Ne peut allouer un vecteur");
	}
	return V;
}

void problem(char* message)
{
	printf("%s\n",message);
	exit(2);
}
