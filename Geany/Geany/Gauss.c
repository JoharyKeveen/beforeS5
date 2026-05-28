#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void problem(char* message);
float *newVect(int dim);
float** newMat(int dim);
void getData(float*** A,float** b,int* dim,float** x);
void displayResult(float** A,float*b,int dim,float* x);
void gauss(float * x,float** a,int N,float* b);
int main(){
	printf("Resolution de A.x=b\n");
	//donnees
	float** A=NULL; //La matrice A
	float* b=NULL; //Second membre
	int dim=3; //Dimension
	float* x=NULL;
	getData(&A,&b,&dim,&x);
	//Resolution par la methode de Gauss
	gauss(x,A,dim,b);
	
	//Sortie de resultat
	displayResult(A,b,dim,x);
	
///	nettoyage des espaces alloues dynamiquement
	free(x);
	free(b);
	for(int i=0;i<dim;i++)
		free(A[i]);
	free(A);
	return 0;
}
float max(float** A,int k,int N,int* p){
	float max=0;
	int i=0;
	for(i=k;i<N;i++){
		if(fabs(A[p[i]][k])>=max){
			max=fabs(A[p[i]][k]);
		}
	}
	return max;
}
int getLpiv(float max,int k,float** A,int N, int*p){
	int val=0;
	int i=0;
	for(i=k;i<N;i++){
		if(fabs(A[p[i]][k])==max){
			val=i;
		}
	}
	return val;
}
void resolutionSystemeTriangularise(int*p ,float * x,int dim,float** A,float*b){
	float somme=0;
	for(int i=dim-1;i>=0;i--){
		somme=0;
		for(int j=i+1;j<dim;j++){
			somme=somme+A[p[i]][j]*x[j];
		}
		x[i]=(1/A[p[i]][i])*(b[p[i]]-somme);
	}
}
void gauss(float * x,float** a,int N,float* b){
	int k=0;
	int i=0;
	int j=0;
	int* p=malloc(N*sizeof(int));
	for(i=0;i<N;i++){
		p[i]=i;
	}
	for(k=0;k<N;k++)
	{
		float m=max(a,k,N,p);
		int lpiv=getLpiv(m,k,a,N,p);
		int t=p[k];
		p[k]=p[lpiv];
		p[lpiv]=t;
		for(i=k+1;i<N;i++)
		{
			for(j=k+1;j<N;j++)
			{
				a[p[i]][j]=a[p[i]][j]-((a[p[i]][k]/a[p[k]][k])*a[p[k]][j]);
			}
			b[p[i]]=b[p[i]]-((a[p[i]][k]/a[p[k]][k])*b[p[k]]);
			a[p[i]][k]=0;
		}
	}
	printf("La matrice A\n");
	for(i=0;i<N;i++){
		for(j=0;j<N;j++)
		{
			printf( "%g\t",a[p[i]][j]);
		}
		printf("\n");
	}
	printf("Le second membre b\n");
	for(i=0;i<N;i++){
		printf("%g\n",b[p[i]]);
	}
	resolutionSystemeTriangularise(p,x,N,a,b);
}
void displayResult(float** A,float*b,int dim,float* x){
	int i=0;
	printf("La solution x\n");
	for(i=0;i<dim;i++){
		printf("%g\n",x[i]);
	}
}
void getData(float*** A,float** b,int* dim,float** x){
	float ** M=NULL;
	float *v=NULL;
	float *sol=NULL;
	
	FILE* pf=NULL;
	pf=fopen("D:\\projet\\gnuplot\\cholesky.txt","r");
	
	if(pf!=NULL){
		fscanf(pf,"%d",dim); //recupere la dimension
		M=newMat(*dim); 	//alloue la place pour la matrice
		v=newVect(*dim);	//alloue la place pour le second membre
		sol=newVect(*dim);	//allloue la place pour la solution
		for(int i=0;i<*dim;i++){
			for(int j=0;j<*dim;j++)
				fscanf(pf,"%f", &M[i][j]); //lit la matrice ligne par ligne
		}
		for(int i=0;i<*dim;i++)
			fscanf(pf,"%f",&v[i]);
		fclose(pf);
		for(int i=0;i<*dim;i++) sol[i]=0;	//initialise le vecteur solution
	}
	else{
		problem("Can't open file");
	}
///	Renvoie les adresses des contenus vers main
	*A=M;
	*b=v;
	*x=sol;
}
float** newMat(int dim){
	float** A=NULL;
	A=malloc(dim*sizeof(float*));
	if(A==NULL) problem("Ne peut allouer une matrice\n");
	int i=0;
	for(i=0;i<dim;i++){
		A[i]=malloc(dim*sizeof(float));
		if(A[i]==NULL) problem("Ne peut allouer une ligne de matrice\n");
	}
	return A;
}
float *newVect(int dim){
	float* v=NULL;
	v=malloc(dim*sizeof(float));
	if(v==NULL) problem("Ne peut allouer un vecteur\n");
	return v;
}
void problem(char* message){
	printf("%s\n",message);
	exit(2);
}
