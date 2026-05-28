#include<stdio.h>
#include<math.h>
void displayResult(float a,float b,float x);
float f(float x);
float f_derive(float x);
float newton(float a,float b,float eps);
float bissection(float a,float b,float eps);
int main(){
	printf("Calcul approximation d'une racine\n");
	printf("1-methode de racine \n2-methode de bissection");
	
///donnees
	float methode=0;
	float a=0.1,b=1;	 //les bornes
	float eps=1e-6;		//precision de l'approximation
	float x=0;			//la solution
	
	scanf("%f",&methode);
	
///traitement
	if(methode==2){
		printf("la methode est bissection\n");
		x=newton(a,b,eps);
		
	}else{
		printf("la methode est racine\n");
		x=bissection(a,b,eps);
	}


///resultat
	displayResult(a,b,x);
	return 0;
	
}
void displayResult(float a,float b,float x){
	printf("Les bornes de l'intervalle %g et % g \n",a,b);
	printf("%g",x);
}
float f(float x){
	return x-2-log(x);
}
float f_derive(float x){
	return 1-(1/x);
}
float newton(float a,float b,float eps){
	float x=0;
	float x0=a;
	float x1=a-(f(a)/f_derive(a));
	if(((x1-a)*(x1-b))>0){
		x0=b;
		x1=b-(f(b)/f_derive(b));
	}
	while(fabs(x1-x0)>eps){
		x0=x1;
		x1=x0-(f(x0)/f_derive(x0));
		x=x1;
	}
	return x;
}
float bissection(float a,float b,float eps){
	float x=0;
	while(fabs(b-a)>eps){
		x=(a+b)/2;
		if(f(a)*f(x)<=0)b=x;
		else if(f(b)*f(x)<=0)a=x;
	}
	return x;
}

