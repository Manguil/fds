#include <stdio.h>
#include <stdlib.h>
#include "pair.h"
#include "impair.h"

int main(int argc, char** argv)
{
    if (argc<=1) 
    {
        printf("Il n'y a pas d'argument...\n");
        return 1;
    }
    int nb = atoi(argv[1]);
    if (pair(nb)) printf("%i est pair !\n", nb);
    else printf("%i est impair !\n", nb);
    return 0;
}