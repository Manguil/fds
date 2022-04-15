#include <stdio.h>
#include <stdlib.h>
#include "image.h"

int main(int argc, char** argv){
    if (argc != 3) {printf("Le nombre de paramètre est incorecte\n"); exit(EXIT_FAILURE);}
    printf("tentative d'ouvetrure de %s\n", argv[1]);
    FILE* fd = fopen(argv[1], "r");
    if (fd == NULL) {printf("Le fichier ne peut etre ouvert\n"); exit(EXIT_FAILURE);}
    char magicNumber[10];
    fscanf(fd, "%s", magicNumber)
    if (magicNumber != "P5") {printf("ce nest pas un fichier pgm binaire"); exit(EXIT_FAILURE);}
    return 0;
}

void ignorer_commentaires(FILE * f){

}


void lire_nb_lignes_colonnes_image_pgm(char nom_image[], int *nb_lignes, int *nb_colonnes){

}


void lire_image_pgm(char  nom_image[], OCTET *pt_image, int taille_image){

}


void ecrire_image_pgm(char  nom_image[], OCTET *pt_image, int nb_lignes, int nb_colonnes){

}


void lire_nb_lignes_colonnes_image_ppm(char nom_image[], int *nb_lignes, int *nb_colonnes){

}


void lire_image_ppm(char  nom_image[], OCTET *pt_image, int taille_image){

}


void ecrire_image_ppm(char  nom_image[], OCTET *pt_image, int nb_lignes, int nb_colonnes){

}