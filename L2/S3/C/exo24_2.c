#include <stdio.h>
#include <stdlib.h>



int main(int argc, char *argv[], char *env[]) {
    if(argc!=3){
        printf("Syntaxe incorrecte : %s -[8|c123] fichier\n",argv[0]);
        return 1;
    }
    FILE *f=fopen(argv[2], "r");
    if (f==NULL){
        printf("Impossible d'ouvrir le fichier : %s \n",argv[2]);
        return 2;
    }
    int nb; /* nb de lignes ou de car */
    int CAR=0; /* bool CAR ou LIGNES */
    if(argv[1][1]=='c'){ /* si n caractères */
        CAR=1;
        nb=atoi(argv[1]+2); /* +2 pour éviter le -c */
    }else{
        nb=atoi(argv[1]+1); /* +1 pour éviter le - */
    }
    if(CAR){
        char tampon[nb+1];
        int n=fread(tampon,1,nb,f); /* lire les nb car d'un coup */
        tampon[n]='\0';
        printf("%s",tampon);
    }else{
        #define TAILLE 2048
        
        char ligne[TAILLE]; /* espérons que cela suffise ! */
        int FDF=0; /* Fin De Fichier */
        for(int i=1;i<=nb && !FDF;i++){
            if(fgets(ligne,TAILLE,f))
                printf("%s",ligne);
            else
                FDF=1;
        }
    }
    fclose(f);
}