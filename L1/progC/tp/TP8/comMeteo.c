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
    if(argc != 3) {
        fprintf(stderr,"Usage: %s fichier_meteo num_jour\n",argv[0]);
        return EXIT_FAILURE;
    }
    
    // Recuperation du numero de jour
    int num = atoi(argv[2]);
    if(num<1 || num>366) {
        fprintf(stderr,"%s : numero de jour incorrect\n",argv[2]);
        return EXIT_FAILURE;
    }

    // Ouverture du fichier source
    FILE *pf = fopen(argv[1], "r+");
    if (pf == NULL) {
        fprintf(stderr, "%s introuvable\n",argv[1]);
        return EXIT_FAILURE;
    }
    
    // lecture taille du fichier
    if(fseek(pf,0,SEEK_END) == -1) {
        fprintf(stderr, "erreur de positionnement dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    int nb = ftell(pf);
    if(nb == -1) {
        fprintf(stderr, "erreur de lecture de taille de %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Verification du numero de jour
    nb = nb / sizeof(struct data_meteo);
    if(num > nb) {
        fprintf(stderr,"jour %d impossible : il n'y a que %d jours dans %s\n",num,nb,argv[1]);
        fclose(pf);
        return EXIT_FAILURE;

    }
    
    // Positionnement au jour voulu
    if(fseek(pf,(num-1)*sizeof(struct data_meteo),SEEK_SET) == -1) {
        fprintf(stderr, "erreur de positionnement dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Lecture des donnees du jour
    struct data_meteo weather;
    if(fread(&weather,sizeof(struct data_meteo), 1, pf) != 1) {
        fprintf(stderr, "erreur de lecture dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Saisie du commentaire
    printf("Saisissez le commentaire à ajouter au jour %d (tmin=%f tmax=%f pluv=%d) : \n\t",num,weather.tmin,weather.tmax,weather.pluv);
    int i = 0;
    int c;
    do {
        c = fgetc(stdin);
        if (c == EOF) {
            fprintf(stderr, "Données météo incomplètes\n");
            fclose(pf);
            return EXIT_FAILURE;
        }
        weather.com[i] = c;
        i++;
    } while(i<256 && c!='\n');
    if(c!='\n') weather.com[255] = '\0';
    else weather.com[i-1] = '\0';
    
    // Re-positionnement au jour voulu
    if(fseek(pf,(num-1)*sizeof(struct data_meteo),SEEK_SET) == -1) {
        fprintf(stderr, "erreur de positionnement dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Réécriture des donnees
    int res;
    if((res=fwrite(&weather,sizeof(struct data_meteo), 1, pf)) != 1) {
        printf("Aie : %d\n",res);
        fprintf(stderr, "erreur d'écriture du commentaire dans %s\n",argv[1]);
        fclose(pf);
        return EXIT_FAILURE;
    }
    
    // Fermeture du fichier
    if(fclose(pf)==EOF) {
        fprintf(stderr, "erreur de fermeture de %s\n",argv[1]);
        return EXIT_FAILURE;
    }
    printf("Commentaire \"%s\" ajouté au jour %d de %s\n",weather.com, num, argv[1]);
    return EXIT_SUCCESS;
}
