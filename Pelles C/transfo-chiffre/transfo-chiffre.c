#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char**Allo2D(int t1, int t2)
{
	char**tab=malloc(t1*sizeof(char*));
	for(int i=0; i<t1;i++)
	{
		tab[i]=malloc(t2*sizeof(char));
	}
	return tab;
}

char*transfo(int chiffre)
{
	char**val=Allo2D(101,25);
	val[0]="zéro";
	val[1]="un";
	val[2]="deux";
	val[3]="trois";
	val[4]="quatre";
	val[5]="cinq";
	val[6]="six";
	val[7]="sept";
	val[8]="huit";
	val[9]="neuf";
	val[10]="dix";
	val[11]="onze";
	val[12]="douze";
	val[13]="treize";
	val[14]="quatorze";
	val[15]="quinze";
	val[16]="seize";
	val[17]="dix-sept";
	val[18]="dix-huit";
	val[19]="dix-neuf";
	val[20]="vingt";
	val[21]="vingt et un";
	val[22]="vingt-deux";
	val[23]="vingt-trois";
	val[24]="vingt-quatre";
	val[25]="vingt-cinq";
	val[26]="vingt-six";
	val[27]="vingt-sept";
	val[28]="vingt-huit";
	val[29]="vingt-neuf";
	val[30]="trente";
	val[31]="trente et un";
	val[32]="trente-deux";
	val[33]="trente-trois";
	val[34]="trente-quatre";
	val[35]="trente-cinq";
	val[36]="trente-six";
	val[37]="trente-sept";
	val[38]="trente-huit";
	val[39]="trente-neuf";
	val[40]="quarante";
	val[41]="quarante et un";
	val[42]="quarante-deux";
	val[43]="quarante-trois";
	val[44]="quarante-quatre";
	val[45]="quarante-cinq";
	val[46]="quarante-six";
	val[47]="quarante-sept";
	val[48]="quarante-huit";
	val[49]="quarante-neuf";
	val[50]="cinquante";
	val[51]="cinquante et un";
	val[52]="cinquante-deux";
	val[53]="cinquante-trois";
	val[54]="cinquante-quatre";
	val[55]="cinquante-cinq";
	val[56]="cinquante-six";
	val[57]="cinquante-sept";
	val[58]="cinquante-huit";
	val[59]="cinquante-neuf";
	val[60]="soixante";
	val[61]="soixante et un";
	val[62]="soixante-deux";
	val[63]="soixante-trois";
	val[64]="soixante-quatre";
	val[65]="soixante-cinq";
	val[66]="soixante-six";
	val[67]="soixante-sept";
	val[68]="soixante-huit";
	val[69]="soixante-neuf";
	val[70]="soixante-dix";
	val[71]="soixante et onze";
	val[72]="soixante-douze";
	val[73]="soixante-treize";
	val[74]="voixante-quatorze";
	val[75]="soixante-quinze";
	val[76]="soixante-seize";
	val[77]="soixante-dix-sept";
	val[78]="soixante-dix-huit";
	val[79]="soixante-dix-neuf";
	val[80]="quatre-vingt";
	val[81]="quatre-vingt-un";
	val[82]="quatre-vingt-deux";
	val[83]="quatre-vingt-trois";
	val[84]="quatre-vingt-quatre";
	val[85]="quatre-vingt-cinq";
	val[86]="quatre-vingt-six";
	val[87]="quatre-vingt-sept";
	val[88]="quatre-vingt-huit";
	val[89]="quatre-vingt-neuf";
	val[90]="quatre-vingt-dix";
	val[91]="quatre-vingt-onze";
	val[92]="quatre-vingt-douze";
	val[93]="quatre-vingt-treize";
	val[94]="quatre-vingt-quatorze";
	val[95]="quatre-vingt-quinze";
	val[96]="quatre-vingt-seize";
	val[97]="quatre-vingt-dix-sept";
	val[98]="quatre-vingt-dix-huit";
	val[99]="quatre-vingt-dix-neuf";
	val[100]="cent";
}
