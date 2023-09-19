#include  <stdio.h>
#include <stdlib.h>

float saisieClavier(float nb)
{
    int saisi = 0;
    printf("Saisie au clavier (float): ");
    while (saisi < 1)
    {
        saisi = scanf("%f",&nb);
    }
    return nb;
}

int main(int argc, char* argv[], char* env[])
{
    if (argc == 1) return 1;
    int nbVal = atoi(argv[1]);
    float somme = 0;
    float nb = 0;
    for (int i = 1; i<=nbVal; i++)
    {
        somme += saisieClavier(nb)/(float)nbVal;
    }
    printf("%f\n",somme);
    return 0;
}