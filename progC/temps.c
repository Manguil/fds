#include <stdio.h>
#include "temps.h"

void afficherTemps(tps *t){
    printf("%d : %d : %f \n", (*t).h, (*t).m, (*t).s);
}

void modifierTemps(tps *t){
    (*t).h += 1;
}

long tempsEnSeconde(tps *t){
    long s = (*t).h*3600+(*t).m*60+(*t).s;
    return s;
}

void secondeEnTemps(long s, tps *t){
    (*t).h = (s-(s%3600)/3600);
	(*t).m = (s-(s%60)/60);
	(*t).s = s%60;

	afficherTemps(&t);
}