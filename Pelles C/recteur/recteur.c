#include <stdio.h>
int main()
{
	printf("Affichage des tailles des types en C\n");
	printf ("Taille d'un char =%d-Byte=%d-bit\n", sizeof(char),8*sizeof(char));
	printf ("Taille d'un int =%d-Byte=%d-bit\n", sizeof(int),8*sizeof(int));
	printf ("Taille d'un short =%d-Byte=%d-bit\n", sizeof(short),8*sizeof(short));
	printf ("Taille d'un long =%d-Byte=%d-bit\n", sizeof(long),8*sizeof(long));
	printf ("Taille d'un long long =%d-Byte=%d-bit\n", sizeof(long long),8*sizeof(long long));

	char x=35;
	char y=99;
	char z=x+y;

	printf("%d + %d = %d\n",x,y,z);

	int a=489521;
	int b=7000000;
	int c=a*b;

	printf("%i * %i= %i\n",a,b,c);

	return 0;
}
