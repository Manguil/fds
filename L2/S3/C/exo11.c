#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *intToStringInt(int nb)
{
    char *stringNb = "0";

    int i = 0;
    while (nb > 0)
    {
        stringNb = realloc(stringNb, (i+1) * sizeof(char));
        int unite = nb % 10;
        stringNb[i] = (char)unite + 48;
        nb -= unite;
        nb /= 10;
        i++;
    }

    stringNb = realloc(stringNb, (i+1) * sizeof(char));
    
    return stringNb;
}

int main()
{
    int nb = 0;
    scanf("%i", &nb);
    char *stringNb = intToStringInt(nb);
    printf("la chaine correspondant à %i est %s\n", nb, stringNb);
}