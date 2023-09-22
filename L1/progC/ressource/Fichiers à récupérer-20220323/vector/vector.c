#include "vector.h"
#include <stdlib.h>
#include <stdio.h>
#define UNIT_BLOC_ALLOC 5

int min(int a, int b) {
    return a<b ? a : b;
}

_Bool changeTaille(int **tab, int taille, int nouvTaille) {
    int *newTab = (int *) malloc(nouvTaille*sizeof(int));
    if(newTab == NULL) {
        return 0;
    } else {
        for(int i=0; i<min(taille,nouvTaille); i++) {
            newTab[i] = (*tab)[i];
        }
        free(*tab);
        *tab = newTab;
        return 1;
    }
}

