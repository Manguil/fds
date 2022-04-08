#include <stdio.h>
#include "vector.h"


int main() {
    vector v;
    int n;
    printf("Quelle taille de vecteur voulez-vous ? ");
    scanf("%d",&n);
    
    // creation d'un vecteur de taille n
    int ok = newVec(n,&v);
    if(!ok) {
        printf("Impossible de creer le vecteur\n");
        return 1;
    }
    
    // initialisation des cases du vecteur avec les n premiers entiers
    for(int i=0;i<size(v);i++) setVal(&v,i,i);
    
    // affichage des proprietes du vecteur
    printVector(v);

    // Ajout de 12 entiers negatifs et affichage
    for(int i=11;i<=121;i=i+11) {
        if(!addVal(&v,i)) {
            printf("Impossible d'etendre le tableau\n");
            return 1;
        }
        printf("Ajout de %d : ",i);
        printVector(v);
    }

    // suppression du vecteur et affichage
    deleteVec(&v);
    printVector(v);
    
    return 0;
}
