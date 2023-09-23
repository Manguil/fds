#include <stdio.h>
#include <string.h>
#include <math.h>

int stringIntToInt(char *s)
{
    char *tableauInt = "0123456789";
    int longueur = strlen(s);
    int nb = 0;
    for (int i = 0; s[i]; i++)
    {
        for (int k = 0; k <= 9; k++)
        {
            printf("%c, %c\n", s[i], tableauInt[k]);
            if (s[i] == tableauInt[k])
            {
                nb += k * pow(10, longueur - (i + 1));
                break;
            }
        }
    }

    return nb;
}

int main(int argc, char **argv)
{
    int nb = stringIntToInt(argv[1]);
    printf("l'entier correspondant à la chaine de caractère %s est %i\n", argv[1], nb);
}