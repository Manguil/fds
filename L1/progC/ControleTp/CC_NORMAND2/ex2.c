#include <stdio.h>
#include <stdlib.h>
#include "carte.h"

/* Fonction : lirejeu
   Entree : nomfic : une chaine de caracteres designant le nom
            d'un fichier contenant une composition d'un jeu de cartes
   Sortie : pnbCartes : un entier qui sera affecte avec le nbre de cartes du jeu
   Resultat : un tableau de cartes contenant les cartes du fichier
   Indications : il faut ouvrir le fichier, lire son nombre de cartes et affecter pnbCartes, 
                 creer un tableau dynamique de cartes, le remplir avec les cartes du fichier,
                 fermer le fichier et renvoyer le tableau. */
carte *lirejeu(char *nomfic, int *pnbCartes){
    FILE* fd = fopen(nomfic, "r");
    if (fd == NULL) {printf("Le fichier n'est pas accessible !\n");exit(EXIT_FAILURE);}
    
}


int main(int argc, char *argv[]) {
    exit(EXIT_SUCCESS);
}
