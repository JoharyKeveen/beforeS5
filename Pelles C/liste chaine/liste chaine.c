#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct liste{
	int valeur;
	struct liste* next;
	struct liste* precedent;
};
typedef struct liste liste;

/*void af(liste li)
{
	while(li.next!=NULL)
	{
		printf("%i", li.valeur);
		
	}
}*/
void af(liste i)
{
	while(&i!=NULL)
	{
		printf("%i\n", i.valeur);
		i=*i.next;
	}
}

int main(void)
{
	liste e1;
	liste e2;
	liste e3;
	liste e4;
	liste e5;
	liste e6;
	e1.valeur=1;
	e1.next=&e2;
	e1.precedent=&e5;

	e2.valeur=2;
	e2.next=&e3;
	e2.precedent=&e1;

	e3.valeur=3;
	e3.next=&e4;
	e3.precedent=&e2;

	e4.valeur=4;
	e4.next=&e5;
	e4.precedent=&e3;

	e5.valeur=5;
	e5.next=&e6;
	e5.precedent=&e4;

	e6.valeur=6;
	e6.next=&NULL;
	af(e1);
}
/*pointeur ny anarany 
	le adresse ny le toerana iny
	raha misy etoile d iny le valeur 
	raha & adresse du pointeur le izy */
