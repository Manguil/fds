#include "image.h"
int seuil = -1; // Pour l'instant le seuil n'existe pas

void ignorerCommentaires(FILE* fd) {
  // Il faut ignorer les commentaires
  printf("Analyse de la zone de commentaires :\n");
  int car;
  while ((char)fgetc(fd) == '#') {
      printf("#");
      while ((car = fgetc(fd)) != '\n') printf("%c", car);
  }
  printf("%c", car);
  fseek(fd, -1, SEEK_CUR);
}

void lire_nb_lignes_colonnes_image_ppm(char nom_image[], int *nb_lignes, int *nb_colonnes) {
  printf("On essaye d'ouvrir le fichier %s\n", nom_image);
  FILE* fd = fopen(nom_image, "r");
  if (fd == NULL) {printf("Le fichier n'est pas accessible !\n");exit(EXIT_FAILURE);}
  char magicNumber[3];
  int niveau;
  fscanf(fd, "%s\n", magicNumber);
  if (strcmp(magicNumber,"P6") != 0){printf("Ce n'est pas un PPM binaire !\n");exit(EXIT_FAILURE);}  
  ignorerCommentaires(fd);
  fscanf(fd, "%d %d\n%d", nb_lignes, nb_colonnes, &niveau);
  printf("Nombre de lignes = %d et colonnes = %d %d\n", *nb_lignes, *nb_colonnes, niveau);
  fclose(fd);
}

void lire_image_ppm(char nom_image[], OCTET *pt_image,
                    int taille_image)  {
  printf("Je lis %d octetsn", taille_image);
  FILE* fd = fopen(nom_image, "r");
  int nb_lignes, nb_colonnes, niveau;
  fscanf(fd, "P6\n");
  ignorerCommentaires(fd);
  fscanf(fd, "%d %d\n%d\n", &nb_lignes, &nb_colonnes, &niveau);  
  fread(pt_image, sizeof(OCTET), taille_image, fd);
  fclose(fd);
}

void ecrire_image_ppm(char nom_image[], OCTET *pt_image, int nb_lignes, int nb_colonnes)  {
  FILE* fd = fopen(nom_image, "w");
  fprintf(fd, "P6\n%d %d\n255\n", nb_lignes, nb_colonnes);
  printf("J'écris %d octetsn", nb_lignes*nb_colonnes*3);
  fwrite(pt_image, sizeof(OCTET), nb_lignes*nb_colonnes*3, fd);
  fclose(fd);
}

void lire_nb_lignes_colonnes_image_pgm(char nom_image[], int *nb_lignes, int *nb_colonnes) {}
void lire_image_pgm(char  nom_image[], OCTET *pt_image, int taille_image) {}
void ecrire_image_pgm(char  nom_image[], OCTET *pt_image, int nb_lignes, int nb_colonnes) {}

int main(int argc, char** argv) {
  if (argc != 3) {
      printf("Le nombre de paramètres est incorrect !\n"); 
      exit(EXIT_FAILURE);
  }

  int nb_lignes, nb_colonnes;
  lire_nb_lignes_colonnes_image_ppm(argv[1], &nb_lignes, &nb_colonnes);

  OCTET *pt_image;
  allocation_tableau(pt_image, OCTET, nb_lignes*nb_colonnes*3);
  lire_image_ppm(argv[1], pt_image, nb_lignes*nb_colonnes*3);
  ecrire_image_ppm(argv[2], pt_image, nb_lignes, nb_colonnes);
  return 0;
}



