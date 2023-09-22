#include <dirent.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


void parcoursRecursif(char* nomDossier) {
    DIR* dossier = opendir(nomDossier);

    struct dirent* ent = readdir(dossier);
    while (ent!=NULL) {
        if (ent->d_type == DT_DIR) {
            printf("dossier : %s\n", ent->d_name);
            if (strcmp(ent->d_name, ".") != 0 && strcmp(ent->d_name, "..") != 0) {
                char* chemin = malloc(strlen(nomDossier)+1+strlen(ent->d_name));
                strcat(chemin,nomDossier);
                strcat(chemin, "/");
                strcat(chemin, ent->d_name);
                parcoursRecursif(chemin);
            }
        }
        else if (ent->d_type == DT_REG) {
            printf("fichier : %s\n", ent->d_name);
        }
        ent = readdir(dossier);
    }
}

int main(int argc, char **argv){
    char* nomDossier = argv[1];
    parcoursRecursif(nomDossier);
    return 0;
}