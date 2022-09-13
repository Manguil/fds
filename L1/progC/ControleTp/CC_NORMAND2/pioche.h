#ifndef pioche_h
#define pioche_h
#include "carte.h"

// une pile de cartes est une liste chainee de cartes

struct cellule {
    carte val;
    struct cellule *suiv;
};

typedef struct cellule *pileCartes;

pileCartes creerPioche(carte jeu[], int nbcartes);
void detruirePioche(pileCartes pioche);
carte piocher(pileCartes *ppioche);
int restePioche(pileCartes pioche);

#endif
