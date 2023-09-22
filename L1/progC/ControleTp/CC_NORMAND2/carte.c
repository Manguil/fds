#include <stdio.h>
#include "carte.h"

void afficherCarte(carte c) {
    switch(c.valeur) {
        case 2: case 3 : case 4 : case 5 : case 6 :
        case 7: case 8 : case 9 : case 10 :
            printf("%d",c.valeur); break;
        case 11 :
            printf("Valet"); break;
        case 12 :
            printf("Dame"); break;
        case 13 :
            printf("Roi"); break;
        case 14 :
            printf("As"); break;
    }
    printf(" de ");
    switch(c.couleur) {
        case 'C' :
            printf("Coeur"); break;
        case 'R' :
            printf("Carreau"); break;
        case 'P' :
            printf("Pique"); break;
        case 'T' :
            printf("Trefle"); break;
    }
}
        
void afficherTabCartes(carte *tab, int taille) {
    printf("[ ");
    for(int i=0; i<taille; i++) {
        afficherCarte(tab[i]);
        if(i!=taille-1) printf(" | ");
    }
    printf(" ]\n");
}
