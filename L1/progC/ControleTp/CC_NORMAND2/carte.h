#ifndef carte_h
#define carte_h

typedef struct scarte{
    int valeur;     // 2, 3, ... , 10, 11 pour VALET, 12 pour DAME, 13 pour ROI, 14 pour AS
    char couleur;   // 'C' pour COEUR, 'R' pour CARREAU, 'P' pour PIQUE, 'T' pour TREFLE
} carte;

void afficherCarte(carte c);

void afficherTabCartes(carte *tab, int taille);

#endif
