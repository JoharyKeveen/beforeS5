#include <stdio.h>

int main()
{
	printf("Open a pipe to gnuplot:\n");
	FILE *gnuplotPipe=popen("D:\\log\\gnuplot\\gnuplot\\bin\\gnuplot -persist","w");
	
	if(gnuplotPipe)
	{
		fprintf(gnuplotPipe,"set term wxt size 800,600\n");
		fprintf(gnuplotPipe,"set title 'Resultat de exo.txt et (exp(-x)/3)*(5*(exp(-x)**3)+1)'\n");
		fprintf(gnuplotPipe,"set xlabel 'Temps (s)'\n");
		fprintf(gnuplotPipe,"set ylabel 'Valeurs'\n");
		fprintf(gnuplotPipe,"set xrange [-1.5:2]\n");
		fprintf(gnuplotPipe,"set yrange [-0.5:3]\n");
		fprintf(gnuplotPipe,"set style data linespoints\n");
		fprintf(gnuplotPipe,"set loadpath 'D:/projet/gnuplot'\n");
		fprintf(gnuplotPipe,"set datafile separator ','\n");
		
		fprintf(gnuplotPipe,"plot 'exo.txt', sin(2*x)\n");
		fflush(gnuplotPipe);
		pclose(gnuplotPipe);
	}
	else printf("Gnuplot not found\n");
	return 0;
}

