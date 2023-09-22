#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[], char* env[])
{
    if (argc == 1) return 1;
    float somme = 0;
    for (int i = 1; i<(argc); i++) somme += atoi(argv[i]);
    somme /= (argc-1);
    printf("%f\n",somme);
}