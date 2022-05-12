#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
    FILE *pf = fopen(argv[1], "a");
    if (pf == NULL) {
        fprintf(stderr, "ouverture de %s impossible\n",argv[1]);
        return EXIT_FAILURE;
    }
    
    // Saisie des informations
    struct data_meteo weather = {};
    printf("Saisissez les valeurs du jour (tmin tmax pluv) : ");
    if(scanf("%f%f%d",&(weather.tmin),&(weather.tmax),&(weather.pluv)) != 3) {
        fprintf(stderr, "Données météo incomplètes\n");
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Ecriture des données
    if(fwrite(&weather, sizeof(struct data_meteo), 1, pf) != 1) {
        fprintf(stderr, "erreur d'écriture dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Fermeture du fichier
    if(fclose(pf)==EOF) {
        fprintf(stderr, "erreur de fermeture de %s\n",argv[1]);
        return EXIT_FAILURE;
    }
    printf("Données enregistrées\n");
    return EXIT_SUCCESS;
}
