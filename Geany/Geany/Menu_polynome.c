#include "stdio.h"
#include "stdlib.h"

int main()
{
	int fin=0;
	 float a[100],sum=0,x;
     int n,i;
     int test=0;
	while(!fin)
		{
			int c;
			printf("1.Entrer les coeficients\n"
					"2.Calcul de P(x)\n"
					"3.Quitter\n"
					);
			
			c=getchar();
			
			switch(c)
			{
				case'1':
					test=1;
					printf("\n Degre X :: ");
					scanf("%d",&n);
					for(i=n;i>=0;i--)
					{
						printf("\n Coefficient de [ X^%d ] :: ",i);
						scanf("%f",&a[i]);
					}
					break;
					
				
				case'2':
					if(test==0)
					{
						printf("veuillez remplir les coefficients avant de faire un calcul\n\n");
						break;
					}
				    printf("\n Valeur de X :: ");
					scanf("%f",&x);
					for(i=n;i>0;i--)
					{
						sum=(sum+a[i])*x;
					}
					sum=sum+a[0];
					printf("\n P(x) = [ %f ]\n",sum);
					break;
					
					
				case'3':
					fin=1;
					break;
			}
		}
	return 0;
}
