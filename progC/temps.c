#include <stdio.h>
#include <math.h>
#include "temps.h"

void afficherTemps(tps *t)
{
	printf("%2d:%2d:%2.3f \n", (*t).h, (*t).m, (*t).s);
}

void verifTemps(tps *t)
{
	if ((t->s >= 60) || (t->m >= 60))
	{
		float s = tempsEnSeconde(t);
		secondeEnTemps(s, t);
	}
}

void modifierTemps(tps *t)
{
	(*t).h += 1;
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
	verifTemps(tempsDepart);verifTemps(duree);
	sDepart = tempsEnSeconde(tempsDepart);
	sDuree = tempsEnSeconde(duree);
	secondeEnTemps(sDepart + sDuree, tempsMin);
	secondeEnTemps(sDepart + (sDuree * coeff), tempsMax);
	verifTemps(tempsMax);verifTemps(tempsMin);
}