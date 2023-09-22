#include <stdio.h>
#include <stdlib.h>

struct data_meteo {
    float tmin, tmax;
    int pluv;
    char com[256];
};

int main(int argc, char* argv[]) {
    
    // Verification des parametres
    if(argc != 2) {
        fprintf(stderr,"Usage: %s fichier_meteo\n",argv[0]);
        return EXIT_FAILURE;
        }

    // Ouverture du fichier source
    FILE *pf = fopen(argv[1], "r");
    if (pf == NULL) {
        fprintf(stderr, "%s introuvable\n",argv[1]);
        return EXIT_FAILURE;
    }
    
    // Lecture taille du fichier
    if(fseek(pf,0,SEEK_END) == -1) {
        fprintf(stderr, "erreur de positionnement dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    int nb = ftell(pf);
    if(nb == -1) {
        fprintf(stderr, "erreur de position dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    nb = nb / sizeof(struct data_meteo);
        
    // Fermeture du fichier
    if(fclose(pf)==EOF) {
        fprintf(stderr, "erreur de fermeture de %s\n",argv[1]);
        return EXIT_FAILURE;
    }
    printf("Il y a %d jours enregistres dans %s\n",nb,argv[1]);
    return EXIT_SUCCESS;
}
