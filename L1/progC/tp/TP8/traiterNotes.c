#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char*argv[]) {
    
    // Verification du nombre de parametres
    if(argc!=2) {
        fprintf(stderr,"%s nom_fichier\n",argv[0]);
        exit(EXIT_FAILURE);
    }
    
    // Ouverture du fichier
    FILE *fs = fopen(argv[1],"r");
    if (fs == NULL) {
        fprintf(stderr,"%s introuvable\n",argv[1]);
        exit(EXIT_FAILURE);
    }
    
    // Creation d'une chaine de caracteres pour nom du fichier cree
    char nomficabi[strlen(argv[1])+4+1];
    strcpy(nomficabi,argv[1]);
    strcat(nomficabi,".ABI");
    
    // Creation du fichier de sortie
    FILE *fd = fopen(nomficabi,"w");
    if (fd == NULL) {
        fprintf(stderr,"impossible de créer %s\n",nomficabi);
        fclose(fs);
        exit(EXIT_FAILURE);
    }
    
    // Boucle de traitement des lignes du fichier
    int num;
    char nom[51];
    char pre[51];
    float note;
    float somme = 0;
    int nbEtu = 0;
    int nbPresent = 0;
    char chaine_abi[4];
    int res;
    do {
        // lecture formatee des donnees
        res = fscanf(fs, "%d%50s%50s%f",&num,pre,nom,&note);
        switch(res) {
            case EOF :  // fin de fichier
                break;
            case 4 :    // ligne avec note
                nbEtu ++;
                somme += note ;
                nbPresent ++;
                break;
            case 3 :    // ligne avec ABI ? => lire l'ABI et écrire la ligne
                if(fscanf(fs, "%3s",chaine_abi) == 1 && strcmp(chaine_abi,"ABI")==0) {
                    nbEtu ++;
                    fprintf(fd,"%s;%s;%d\n",pre,nom,num);
                    break;
                }
            default :   // erreur format
                fprintf(stderr,"Erreur de format ligne %d\n",nbEtu+1);
                fclose(fs);
                fclose(fd);
                exit(EXIT_FAILURE);
        }
    } while(res != EOF);
    
 
    // Affichage du resultat
    printf("Il y a %d présents sur %d étudiants : moyenne %f\n",nbPresent,nbEtu,somme/nbPresent);
    
    //  Fermeture des fichiers
    fclose(fs);
    if(fclose(fd)==EOF) {
        fprintf(stderr, "erreur de fermeture de %s\n",nomficabi);
        return EXIT_FAILURE;
    }
    else printf("Absents enregistrés dans le fichier %s\n",nomficabi);
    
    exit(EXIT_SUCCESS);
}
