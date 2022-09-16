#include <stdio.h>
#include <math.h>
#include "tp4.h"

/* --------------------- fonction tp4 exo 1 --------------------- */
int sommDiv(int n)
{
	int div = 0;
	for (int i = 1; i < floor(n / 2) + 1; i++)
	{
		if (n % i == 0)
			div += i;
	}
	return div;
}

_Bool testParfait(int n)
{
	return (sommDiv(n) == n);
}

int nbParfait(int a, int b)
{
	int nb = 0;
	for (int i = a; i <= b; i++)
	{
		if (testParfait(i))
			nb++;
	}
	return nb;
}

int niemeParfait(int n)
{
	int i = 0, dernierParfait = 1;
	while (i <= n)
	{
		if (testParfait(i))
		{
			dernierParfait = i;
		}
		i++;
	}
	return dernierParfait;
}

/* --------------------- fonction tp4 exo 2 ---------------------*/
void afficherTemps(tps *t)
{
	printf("%02d:%02d:%02.3f \n", (*t).h, (*t).m, (*t).s);
}

void verifTemps(tps *t)
{
	if ((t->s >= 60) || (t->m >= 60))
	{
		float s = tempsEnSeconde(t);
		secondeEnTemps(s, t);
	}
}

float tempsEnSeconde(tps *t)
{
	float s = (*t).h * 3600 + (*t).m * 60 + (*t).s;
	printf("%.3f\n", s);
	return s;
}

void secondeEnTemps(float s, tps *t)
{
	long sInt = s * 1000;
	(*t).h = (sInt - (sInt % (3600 * 1000))) / (3600 * 1000);
	(*t).m = ((sInt - ((*t).h) * 3600 * 1000) - (sInt % (60 * 1000))) / (60 * 1000);
	(*t).s = ((float)(sInt % (60 * 1000))) / 1000;
}

float duree(tps *debut, tps *fin)
{
	float sDebut = tempsEnSeconde(debut);
	float sFin = tempsEnSeconde(fin);
	float sDuree = fabs(sDebut - sFin);
	return sDuree;
}

void heureArriveeV1(tps *tempsDepart, tps *duree, float coeff, tps *tempsMax, tps *tempsMin)
{
	float sDepart = 0, sDuree = 0;
	verifTemps(tempsDepart);
	verifTemps(duree);
	sDepart = tempsEnSeconde(tempsDepart);
	sDuree = tempsEnSeconde(duree);
	secondeEnTemps(sDepart + sDuree, tempsMin);
	secondeEnTemps(sDepart + (sDuree * coeff), tempsMax);
	verifTemps(tempsMax);
	verifTemps(tempsMin);
}