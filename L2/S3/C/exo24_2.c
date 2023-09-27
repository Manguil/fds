#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    if (argc != 3)
    {
        printf("commmande format: %s -[8|c8] chemin\n", argv[0]);
        return 1;
    }

    FILE *f = fopen(argv[2],"r");
    if (f == NULL) 
    {
        printf("erreur d'ouverture de %s\n",argv[2]);
        return 2;
    }

    int nb = 0;
    int nbALire = 0;
    
    if (argv[1][1] == 'c') 
    {
        nbALire = atoi(argv[1]+2); //pour sauter -c
        char *tampon = malloc(sizeof(char)*nbALire);
        if (fread(tampon, sizeof(char), nbALire, f) != nbALire) 
        {
            printf("erreur de lecture (surement fin de fichier)\n");
            return 3;
        }
        printf("%s\n",tampon);
        nb++;
    }

    else 
    {
        nbALire = atoi(argv[1]+1); // pour sauter -
        char *tampon = malloc(sizeof(char)*100);
        while (nb < nbALire)
        {
            if (char *temp = fgets(, 1, f)) 
            {
                printf("erreur de lecture (surement fin de fichier)\n");
                return 3;
            }
            printf("%c",c);
            nb++;
        }
    }

    fclose(f);
}