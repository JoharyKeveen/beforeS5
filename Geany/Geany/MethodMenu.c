#include <stdio.h>
#include <math.h>

float f(float x);
float deriv(float x);
void displayresult(float resultat,float a,float b);
float bissection(float a,float b,float eps);
float newton(float a,float b,float eps);

int main(){
	printf("Resolution de f(x)=0 \n");
	
///Donnees
	float a=0.1,b=1;   //bornes de l'intervalle
	float epsilon=1e-6; //precision de l'approximation
	float solution=546;  //solution
	float rep=5464;
///Traitement
	solution=bissection(a,b,epsilon);
	rep=newton(a,b,epsilon);
///Resultats	
	 int fin=0;   //pour la boucle
	while(!fin)
		{
			int c;
			printf("1.Bissection\n"
					"2.Newton\n"
					"3.Quitter\n"
					);
			c=getchar();
			if(c !='\n' && c !=EOF)
			{
				int d;
				while((d=getchar()) !='\n' && d !=EOF);
			}
			
			switch(c)
			{
				case '1':
				printf("Bissection\n");
				displayresult(solution,a,b);
				
					break;				
				case '2':

				solution=
				printf("Methode de Newton\n");
				displayresult(rep,a,b);
					break;				
				case '3':
					fin=1;
					break;									
			}
		} 

	//displayresult(solution,a,b);	
	
	return 0;
}
void displayresult(float resultat,float a,float b){
	printf("La solution dans [%g , %g] est %g\n",a,b,resultat);
	
}
float newton(float a,float b,float eps){
	float x0=a;
	float x1=a-(f(a)/deriv(a));
	float result=0;
	if(((x1-a)*(x1-b))>b)
	{
		x0=b;
		x1=b-(f(b)/deriv(b));
	}
	while((fabs(x1-x0))>eps)
	{
		x0=x1;
		x1=x0-(f(x0)/deriv(x0));
		result=x1;
	}
	return result;
}
float bissection(float a,float b,float eps){
	float result=0;
	float x=0;
	int i=0;
	while((fabs(a-b))>eps){
		x=(a+b)/2;
		if(f(a)*f(x)<=0){
			b=x;			
		}else{
			a=x;			
			}
		i++;	
	}
	printf("nb d'operations= %i\n",i);
	result=x;
	return result;
}
float deriv(float x){
	return (1-(1/x));
}
float f(float x){
	return (x-2-log(x));
}
