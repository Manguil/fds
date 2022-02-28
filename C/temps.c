#include "temps.h"

void modifierTemps(tps *t){
    (*t).h += 1;
}

void tempToSeconde(tps *t){
    (*t).s = (*t).h*3600+(*t).m*60+(*t).s;
    (*t).h = 0;
    (*t).m = 0;
}