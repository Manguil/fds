#include <dirent.h>
#include <stdio.h>


void parcoursRecursif(char* nomDossier) {
    
}

int main(int argc, char **argv){
    char * nomDossier = argv[1];
    DIR* dossier = opendir(nomDossier);

    struct dirent* ent = readdir(dossier);
    while (ent!=NULL) {
        if (ent->d_type == DT_DIR) {
            printf("dossier : %s\n", ent->d_name);
        }
        else if (ent->d_type == DT_REG) {
            printf("fichier : %s\n", ent->d_name);
        }
        ent = readdir(dossier);
    }
    


    return 0;
}