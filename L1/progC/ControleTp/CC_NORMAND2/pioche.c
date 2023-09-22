#include <stdlib.h>
#include <stdio.h>
#include "pioche.h"

int restePioche(pileCartes pioche) {
    if (pioche.val == NULL) return 0;
    return 1+restePioche(pioche.suiv);
}

pileCartes creerPioche(carte jeu[], int nbcartes) {

    return NULL;
}

void detruirePioche(pileCartes pioche) {
    
}

carte piocher(pileCartes *ppioche) {
    carte c = {9,'C'};
    return c;
}
