#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char **strsplit(const char *s, const char sep)
{
    int nbChamps = 0;
    int nbCaracteres = 0;
    int longueur = strlen(s);
    char **tab = NULL;

    for (int i = 0; i <= longueur; i++)
    {
        if (s[i] == sep || s[i] == '\0')
        {
            // Allouer de la mémoire pour le champ
            tab = (char **)realloc(tab, (nbChamps + 1) * sizeof(char *));
            if (tab == NULL)
            {
                perror("Erreur d'allocation de mémoire");
                exit(1);
            }

            // Allouer de la mémoire pour le champ et le copier
            tab[nbChamps] = (char *)malloc((nbCaracteres + 1) * sizeof(char));
            if (tab[nbChamps] == NULL)
            {
                perror("Erreur d'allocation de mémoire");
                exit(1);
            }

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

    // Ajouter un pointeur NULL à la fin du tableau
    tab = (char **)realloc(tab, (nbChamps + 1) * sizeof(char *));
    if (tab == NULL)
    {
        perror("Erreur d'allocation de mémoire");
        exit(1);
    }
    tab[nbChamps] = NULL;

    return tab;
}

int main(int argc, char *argv[])
{
    const char *entree = argv[1];
    const char separateur = argv[2][0];

    char **tab = strsplit(entree, separateur);
    for (int i = 0; tab[i] != NULL; i++)
    {
        printf("%d --> %s\n", i, tab[i]);
        free(tab[i]);
    }

    free(tab);
    return 0;
}
