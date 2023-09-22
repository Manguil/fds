#include <stdio.h>
#include "carte.h"


int nombrePique(carte *tab, int taille){
    int nbPique = 0;
    for(int i=0; i<taille; i++) {
        if(tab[i].couleur == 'P') nbPique += 1;
    }
    return nbPique;
}


_Bool plusPetitTrefle(carte *tab,int taille, carte *ppt){
    for(int i=0; i<taille; i++) {
        if(tab[i].couleur == 'T' && tab[i].valeur < (*ppt).valeur) (*ppt).valeur = tab[i].valeur;
    }
    if ((*ppt).valeur == 15) {
        return 0;
    }
    return 1;
}


int main() {
    int nbPique = 0;
    carte ppt = {15,'F'};
    carte maMain[] = {{7,'C'},{13,'C'},{11,'T'},{14,'R'},{14,'T'}};
    afficherTabCartes(maMain,5);
    nbPique = nombrePique(maMain, 5);
    printf("Cette main a %d Pique\n",nbPique);
    if (plusPetitTrefle(maMain, 5, &ppt)) printf("Son plus peit trèfle est le %d de trèfle\n", ppt.valeur);
    else printf("cette main n'a pas de trèfle\n");

    return 0;
}
