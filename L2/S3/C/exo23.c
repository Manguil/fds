#include <stdio.h>

int main(int argc, char **argv)
{
    FILE *f = fopen(argv[1], "r");

    if (f == NULL)
    {
        printf("probleme d'ouverture du fichier %s", argv[1]);
        return 1;
    }
    char c;
    int i = 0;
    while (fread(&c, sizeof(char) /*taille des objets lu*/, 1, f))
    {
        printf("%c", c);
        i++;
    }
    printf("il y a %i caracteres dans le fichier\n", i);
    fclose(f);
    return 0;
}