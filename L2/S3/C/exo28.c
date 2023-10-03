#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv)
{
    if (argc != 5)
    {
        printf("format de la commande : fichier separateur nchamps contenuChamps");
        return 1;
    }

    FILE *f = fopen(argv[1], "r");

    
}