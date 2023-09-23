#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char** strsplit(char *s, char sep)
{
    int nbChamps = 0;
    int nbCaracteres = 0;
    int longueur = strlen(s);
    char **tab = NULL;

    for (int i = 0; i <= longueur; i++)
    {
        if (s[i] == sep || s[i] == '\0')
        {
            tab = realloc(tab, (nbChamps + 1) * sizeof(char *));

            tab[nbChamps] = malloc((nbCaracteres + 1) * sizeof(char));

            strncpy(tab[nbChamps], s + i - nbCaracteres, nbCaracteres);
            tab[nbChamps][nbCaracteres] = '\0';

            nbChamps++;
            nbCaracteres = 0;
        }
        else
        {
            nbCaracteres++;
        }
    }

    tab = realloc(tab, (nbChamps + 1) * sizeof(char *));
    tab[nbChamps] = NULL;

    return tab;
}

int main(int argc, char *argv[])
{
    const char *entree = argv[1];
    const char separateur = argv[2][0];

    char **tab = strsplit(entree, separateur);

    int nbChamps = 0;
    for (int i = 0; tab[i] != NULL; i++)
    {
        printf("%d --> %s\n", i, tab[i]);
        nbChamps++;
        free(tab[i]);
    }
    printf("%d --> %s\n", nbChamps, "NULL");

    free(tab);
    return 0;
}
