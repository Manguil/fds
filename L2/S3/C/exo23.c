#include <stdio.h>



int main(int argc, char *argv[], char *env[]) {
    if(argc!=2){
        printf("Syntaxe incorrecte : %s fichier\n",argv[0]);
        return 1;
    }
    FILE *f=fopen(argv[1], "r");
    if (f==NULL){
        printf("Impossible d'ouvrir le fichier : %s \n",argv[1]);
        return 2;
    }
    char c;
    int i=0;
    while(fread(&c,1,1,f))
    {
        i++;
        printf("%c",c);
    }
    fclose(f);
    printf("\n");
    printf("il y a %d caracteres\n",i);
}
