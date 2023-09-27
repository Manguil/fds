#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[], char *env[]) {
    if(argc!=3){
        printf("Syntaxe incorrecte : %s -8 fichier\n",argv[0]);
        return 1;
    }
    FILE *f=fopen(argv[2], "r");
    if (f==NULL){
        printf("Impossible d'ouvrir le fichier : %s \n",argv[2]);
        return 2;
    }
    #define TAILLE 2048
    char ligne[TAILLE]; /* espérons que cela suffise ! */
    int nb=atoi(argv[1]+1); /* +1 pour éviter le - */
    int FDF=0; /* Fin De Fichier */
    for(int i=1;i<=nb && !FDF;i++){
        if(fgets(ligne,TAILLE,f))
            printf("%s",ligne);
        else
    FDF=1;
    }
    fclose(f);
}