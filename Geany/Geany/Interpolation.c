#include <stdio.h>
#include <stdlib.h>

void getdata(int dim, float*xd, float*yd, char*file);
float pj(int j, float x, float *xd, int dim);
float lagrange(float x, float *xd, float *yd, int dim);
void ploting(FILE *gnuplotPipe,char*data);
void problem(char* messages);
void InternalDataBlock(FILE*gnuplotPipe, int dim, float *xd, float *yd);

int main(){
	printf("INTERPOLATION \n");
///Donnees
	int dim=8; //nombre de points
	float *xd=malloc(dim*sizeof(float)), *yd=malloc(dim*sizeof(float)); //les coordonees
	FILE *gnuplotPipe = popen("D:\\log\\gnuplot\\gnuplot\\bin\\gnuplot -persist","w");
///Traitement
	getdata(dim,xd,yd, "D:\\projet\\gnuplot\\interpolation.txt");
///Resultats	
	fprintf(gnuplotPipe, "set xrange [0:7]\n");
	fprintf(gnuplotPipe, "set yrange [-5:5]\n");
	InternalDataBlock(gnuplotPipe, dim, xd, yd);
}

void getdata(int dim, float*xd , float*yd, char*file){
    FILE *pf = fopen(file, "r");
    if(pf!=NULL){				
        for(int i=0; i < dim; i++){
            fscanf(pf,"%g, %g\n",&xd[i],&yd[i]);
        }
    }else{
        problem("Can't open file");
        exit(2);
    }
}

float pj(int j, float x, float *xd, int dim){
	float pjv = 1.0;
	for(int k=0; k < dim; k++){
		if(k != j) pjv *= ((x-xd[k])/(xd[j]-xd[k]));
	}
	return pjv;
}

float lagrange(float x, float*xd, float*yd, int dim){
	int j =0; 
	float y=0;
	for(j=0; j<dim; j++) y += (yd[j]*pj(j, x, xd, dim));
	return y;
}

void ploting(FILE *gnuplotPipe,char*data){
	if(gnuplotPipe){//IF gnuplot is found
		fprintf(gnuplotPipe, "plot %s\n", data);
	}else printf("Gnuplot not found \n");		
}

void problem(char* messages){
	printf("%s\n", messages);
	exit(2);
}

void InternalDataBlock(FILE*gnuplotPipe, int dim, float *xd, float *yd){
	fprintf(gnuplotPipe, " $data << EOF\n");
	for(int i=0; i<dim; i++){
		fprintf(gnuplotPipe, "%f %f\n", xd[i], yd[i]);
	}
	fprintf(gnuplotPipe, "EOF\n");
	
	float plus = 0.001;
	float x = 0;
	float y = lagrange(x, xd, yd, dim);
	fprintf(gnuplotPipe, " $lagrange << EOF\n");
	for(int lav=0; lav<6100; lav++){
        fprintf(gnuplotPipe,"%f %f\n", x, y);
        x += plus;
        y = lagrange(x, xd, yd, dim);
	}
	fprintf(gnuplotPipe, "EOF\n");
    ploting(gnuplotPipe,"$data using 1:2 w linespoint lc 'black' pointtype 7 lw 2 t 'Linear',$lagrange using 1:2 w lines lc 'blue' lw 2 t 'Lagrange',$data using 1:2 w linespoint lc 'red' lw 2 smooth csplines t 'splines cubic'");
	
}
	

