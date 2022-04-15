#include <stdio.h>
#include <stdlib.h>
#include "image.h"

void lire_nb_lignes_colonnes_image_pgm(char nom_image[], int *nb_lignes, int *nb_colonnes) {
printf("On essaye d'ouvrir le fichier %s\n", nom_image);
FILE* fd = fopen(nom_image, "r");
if (fd == NULL) {printf("Le fichier n'est pas accessible !\n");exit(EXIT_FAILURE);}
char magicNumber[3];
int niveauxDeGris;
fscanf(fd, "%s", magicNumber);
if (strcmp(magicNumber,"P5") != 0){printf("Ce n'est pas un PGM binaire !\n");exit(EXIT_FAILURE);}
fscanf(fd, "%d %d\n%d", nb_lignes, nb_colonnes, &niveauxDeGris);
printf("Nombre de lignes = %d et colonnes = %d %d\n", *nb_lignes, *nb_colonnes, niveauxDeGris);
fclose(fd);
}

void lire_image_pgm(char nom_image[], OCTET *pt_image, int taille_image) {
FILE* fd = fopen(nom_image, "r");
int nb_lignes, nb_colonnes, niveauxDeGris;
fscanf(fd, "P5\n%d %d\n%d\n", &nb_lignes, &nb_colonnes, &niveauxDeGris);
fread(pt_image, sizeof(OCTET), taille_image, fd);
fclose(fd);
}

void ecrire_image_pgm(char nom_image[], OCTET *pt_image, int nb_lignes, int nb_colonnes) {
FILE* fd = fopen(nom_image, "w");
fprintf(fd, "P5\n%d %d\n255\n", nb_lignes, nb_colonnes);
fwrite(pt_image, sizeof(OCTET), nb_lignes*nb_colonnes, fd);
fclose(fd);
}

void lire_nb_lignes_colonnes_image_ppm(char nom_image[], int *nb_lignes, int *nb_colonnes) {}
void lire_image_ppm(char nom_image[], OCTET *pt_image, int taille_image) {}
void ecrire_image_ppm(char nom_image[], OCTET *pt_image, int nb_lignes, int nb_colonnes) {}

int main(int argc, char** argv) {
if (argc != 3) {printf("Le nombre de paramètres est incorrect !\n"); exit(EXIT_FAILURE);}

int nb_lignes, nb_colonnes;
lire_nb_lignes_colonnes_image_pgm(argv[1], &nb_lignes, &nb_colonnes);

OCTET *pt_image;
allocation_tableau(pt_image, OCTET, nb_lignes*nb_colonnes);
lire_image_pgm(argv[1], pt_image, nb_lignes*nb_colonnes);
ecrire_image_pgm(argv[2], pt_image, nb_lignes, nb_colonnes);
return 0;
}

