#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>

int main(void){

    char* name = "poeme.txt";
    
    //MODIFIE UN FICHIER NON OUVERT
    chmod("./poeme.txt",0000);    


    //MODIFIE UN FICHIER OUVERT
    int d = open(name,O_RDONLY);        //On ne peut pas ouvrir ce fichier car 
                                            //on n'a pas les droits de lecture

    fchmod(d,0777);  // Ne fonctionne pas car on n'a pas réussi a ouvrir le fichier, on peut donc pas le modif
    close(d);

    
    struct stat buf;
    stat(name,&buf);

    printf("%ld\n",buf.st_size);
    if (buf.st_mode & S_IRUSR & S_IRUSR){
        printf("utilisateur a r\n");
    }
    else printf("utilisateur n'a pas r\n");


    printf("Inode: %ld\n",buf.st_ino); // Afficher l'inode

    char* dateF = ctime(&buf.st_mtime);
    printf("%s", dateF);

    return 0;
}