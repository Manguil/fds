#include <dirent.h>
#include <sys/stat.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[]) {
    if(argc > 1) {
        int n = 5;
        DIR* dossier = opendir(argv[1]);;
        struct dirent* entree;
        struct stat info;
        time_t now = time(NULL);
        time_t modif;
        int diff;
        char* name;
        if(dossier != NULL) {
            while((entree = readdir(dossier)) != NULL) {
                name = entree->d_name;
                stat(name, &info);
                modif = info.st_mtime;
                diff = difftime(now, modif);
                if(diff < n*24*60*60) {
                    printf("%s\n", name);
                }
            }
        }
    }
    return 0;
}