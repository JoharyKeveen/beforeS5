#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAX_SIZE 100 // Taille maximale de la matrice et du vecteur

void getMatrix(char* filename, int n, int m, float matrix[][MAX_SIZE], float vector[]);
void getVector(int n, int m, float matrix[][MAX_SIZE], float vector[]);
void displayMatrix(int n,int m,float matrix[][MAX_SIZE]);
void getMatrixTriangular(int n,int m,float matrix[][MAX_SIZE]);
void mCholesky(int n,int m,float matrix[][MAX_SIZE]);
void resoudre(int n,int m, float matrix[][MAX_SIZE], float vector[], float solution[]);
void displayResult(int n,float solution[]);

int main(){
///donnees
	char* filename = "D:\\projet\\gnuplot\\cholesky.txt"; // Nom du fichier à lire
	float matrix[MAX_SIZE][MAX_SIZE]; // Matrice
	float vector[MAX_SIZE]; // Vecteur
	float solution[3]; // Vecteur solution
	int n=3,m=4;//tRow,tColumn
///traitement
	getMatrix(filename, n, m, matrix, vector);
	getVector(n, m,matrix,vector);
	mCholesky(n,m,matrix);
	resoudre(n,m, matrix,vector,solution);
///resultat
	displayMatrix(n,m,matrix);
	displayResult(n,solution);
	return 0;
}

//lire la matrice depuis un fichier
void getMatrix(char* filename, int n, int m, float matrix[][MAX_SIZE], float vector[]) {
  // Ouvre le fichier en lecture
  FILE* file = fopen(filename, "r");
  if (file == NULL) {
    fprintf(stderr, "Erreur d'ouverture du fichier %s\n", filename);
    exit(1);
  }

  // Lit la matrice et le vecteur depuis le fichier
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      fscanf(file, "%g", &matrix[i][j]);
    }
    fscanf(file,"\n");
  }
  // Ferme le fichier
  fclose(file);
}

//get vecteur
void getVector(int n, int m, float matrix[][MAX_SIZE], float vector[]){
	int a = 0;
	for(int j = 0;j < m;j++){
		for(int i = 0;i < n;i++){
			vector[a] = matrix[i][j];
			a++;
		}
	}
}


//aficher mattrice
void displayMatrix(int n,int m,float matrix[][MAX_SIZE]){
	for(int i = 0;i < n;i++){
		for(int j = 0;j < m;j++){
			printf("%g  ",matrix[i][j]);
		}
		printf("\n");
	}
}

//Cholesky A.x = b -> B.Bt.x = b -> B.y = b et Bt.x = y
void getMatrixTriangular(int n,int m,float matrix[][MAX_SIZE]){
	m = m-1;
	for(int i = 0;i < n;i++){
		for(int j = 0;j < m;j++){
			int Z = 0;
			if(j <= i-1){
				for(int k = 0;k <= j-1;k++){
					Z = Z + matrix[i][k] * matrix[j][k];
				}
				matrix[i][j] = ((matrix[i][j] - Z) / matrix[j][j]);
			} else if(j == i){
				for(int k = 0;k <= i-1;k++){
					Z = Z + matrix[i][k] * matrix[i][k];
				}
				matrix[i][i] = (pow((matrix[i][i] - Z),0.5));
			} else {
				matrix[i][j] = 0;
			}
		}
	}
}

void transposeMatrix(int n,int m,float matrix[][MAX_SIZE]){
	m = m-1;
	float matrixT[MAX_SIZE][MAX_SIZE];
	for(int i = 0;i < n;i++){
		for(int j = 0;j < m;j++){
			matrixT[i][j] = matrix[j][i];
		}
	}
	for(int i = 0;i < n;i++){
		for(int j = 0;j < m;j++){
			matrix[i][j] = matrixT[i][j];
		}
	}
}

void getY(int n,int m,float matrix[][MAX_SIZE]){
	for(int i = 0;i < n;i++){
		int Z = 0;
		for(int j = 0;j <= i-1;j++){
			Z = Z + matrix[i][j] * matrix[j][m-1];
		}
		matrix[i][m-1] = (matrix[i][m-1] - Z) / matrix[i][i];
	}
}

void mCholesky(int n,int m,float matrix[][MAX_SIZE]){
	getMatrixTriangular(n,m,matrix);
	getY(n,m,matrix);
	transposeMatrix(n,m,matrix);
}

//résoudre le système triangulaire
void resoudre(int n,int m, float matrix[][MAX_SIZE], float vector[], float solution[]) {
	for(int i = n-1;i >= 0;i--){
		int k = m-1;
		float Z = 0;
		for(int j = k-1;j >= i+1;j--){
			if(j > n) break;
			Z = Z + matrix[i][j] * solution[j];
		}
		solution[i] = (matrix[i][k] - Z) / matrix[i][i];
	}
}

//afficher resultat
void displayResult(int n,float solution[]){
	for(int i = 0;i < n;i++){
		printf("x[%i] = %g",i,solution[i]);
		if(i < n-1) printf(",");
	}
}
//1 3 1 4
//2 4 1 1
//3 2 4 3

/*
 * void TriangInf(float** T,float* v,float* u,int dim)
 * {
	 * 	for(int i=dim-1;i>=0;i--)
	 * 	{
	 * 		float sum=0;
	 * 		for(int j=i+1;j<dim;j++)
	 * 		{
	 * 			sum+=T[i][j]*u[j];
	 * 		}
	 * 		u[i]=(v[i]-sum)/T[i][i];
	 * 	}
 * }
*/
/*
 * void triangSup(float** S,float* u,float* w,int dim)
 * {
	 * 	for(int i=0;i<dim;i++)
	 * 	{
	 * 		float sum=0;
	 * 		for(int j=0;j<i;j++)
	 * 		{
	 * 			sum+=S[i][j]*w[j];
	 * 		}
	 * 		w[i]=(u[i]-sum)/S[i][i];
	 * 	}
 * }
*/
/*
void Cholesky(float** A,int n)
{
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<i+1;j++)
		{
			float s=0;
			for(int k=0;k<j;k++)
			{
				s+=A[i][k]*A[j][k];
			}
			if(i==j)
			{
				A[i][j]=sqrt(A[i][i]-s);
			}
			else
			{
				A[i][j]=(1.0/A[j][j]*(A[i][j]-s));
			}
		}
	}
}
*/
