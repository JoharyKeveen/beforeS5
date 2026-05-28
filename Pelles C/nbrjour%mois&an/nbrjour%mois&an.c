#include <stdio.h>
#include <stdlib.h>

int NJ(int*tab)
{
	if(tab[2]%4==0)
	{
		if(tab[1]==1)
		{
			int val=32;
			return val;
		}
		else if(tab[1]==2)
		{
			int val=29;
			return val;
		}
		else if(tab[1]==3|| tab[1]==5|| tab[1]==7 || tab[1]==8|| tab[1]==10|| tab[1]==12)
		{
			int val=31;
			return val;
		}
		else
		{
			int val=30;
			return val;
		}
	}
	if(
	{
		if(tab[1]==1)
		{
			int val=32;
			return val;
		}
		else if(tab[1]==2)
		{
			int val=28;
			return val;
		}
		else if(tab[1]==3|| tab[1]==5|| tab[1]==7 || tab[1]==8|| tab[1]==10|| tab[1]==12)
		{
			int val=31;
			return val;
		}
		else
		{
			int val=30;
			return val;
		}
	}
}
