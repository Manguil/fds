#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *intToStringInt(int nb)
{
    char *stringNb = malloc(sizeof(char));

    int i = 0;
    while (nb > 0)
    {
        stringNb = realloc(stringNb, (i + 2) * sizeof(char));
        int unite = nb % 10;
        stringNb[i] = (char)unite + 48;
        nb -= unite;
        nb /= 10;
        i++;
    }

    stringNb[i] = '\0';
    i--;
    for (int j = 0; j < (i / 2) + 1; j++)
    {
        char temp = stringNb[j];
        stringNb[j] = stringNb[i];
        stringNb[i] = temp;
        i--;
    }
    return stringNb;
}

int main()
{
    int nb = 0;
    scanf("%i", &nb);
    char *stringNb = intToStringInt(nb);
    printf("la chaine correspondant à %i est %s\n", nb, stringNb);
    free(stringNb);
}