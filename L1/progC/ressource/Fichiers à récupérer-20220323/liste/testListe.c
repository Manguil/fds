#include <stdio.h>
#include "liste.h"

int main()
{
    liste l[2];
    l[0] = insereTete(133, insereTete(15, insereTete(4, insereTete(34, insereTete(23, NULL)))));
    l[1] = NULL;

    char choix = '0';
    int i = 2, pos = '0', elem = 0;
    do
    {
        printf("\n*************************************************\n");
        printf("l[0] contient %d elements : ", longueur(l[0]));
        afficher(l[0]);
        printf("\n");
        printf("l1 contient %d elements : ", longueur(l[1]));
        afficher(l[1]);
        printf("\n");
        printf("Menu\n");
        printf("(A)fficher n-ieme element\n");
        printf("(M)odifier n-ieme element de liste\n");
        printf("(I)nserer element a une position\n");
        printf("(S)upprimer n-ieme element\n");
        printf("(V)ider liste\n");
        printf("(P)ermuter 2 elements de la liste\n");
        printf("(C)oncatener liste a l'autre liste\n");
        printf("(D)upliquer liste dans l'autre liste\n");
        printf("Inserer(B)is element a une position\n");
        printf("(E)xtraire pairs de liste dans l'autre\n");
        printf("(Q)uitter\n");
        printf("Votre Choix (Lettre suivie de 0 ou 1) => ");
        int nb = scanf("%c%d", &choix, &i);
        while ((nb != 2 && (nb != 1 || choix != 'Q')) || (choix != 'A' && choix != 'M' && choix != 'I' && choix != 'S' && choix != 'V' && choix != 'P' && choix != 'C' && choix != 'D' && choix != 'B' && choix != 'E' && choix != 'Q') || (i != 0 && i != 1 && choix != 'Q'))
        {
            // printf("Mauvais choix => ");
            nb = scanf("%c%d", &choix, &i);
        }
        switch (choix)
        {
        case 'A':
            printf("Nieme element : quelle position ? ");
            scanf("%d", &pos);
            printf("==> Le %d-ieme element de l%d est %d\n\n", pos, i, nieme(pos, l[i]));
            break;
        case 'M':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'I':
            printf("Inserer element : quel element ? ");
            scanf("%d", &elem);
            printf("Quelle position ? ");
            scanf("%d", &pos);
            l[i] = inserer(elem, pos, l[i]);
            printf("\n");
            break;
        case 'S':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'V':
            while (l[i]!= NULL) l[i]=supprimerTete(l[i]);
            printf("liste supprimée \n\n");
            break;
        case 'P':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'C':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'D':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'B':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'E':
            printf("==> Fonction non implantee \n\n");
            break;
        case 'Q':
            printf("==> Au revoir !\n\n");
        default:;
        }
    } while (choix != 'Q');
    return 0;
}
