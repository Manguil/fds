#include <stdlib.h>
#include <stdio.h>
#include "liste.h"

void afficher(liste li)
{
    printf("(");
    while (li != NULL)
    {
        printf(" %d", li->valeur);
        li = li->suivant;
    }
    printf(" )\n");
}

liste modifier(int position, int valeur, liste li)
{
    liste li2 = li;
    if (position == 1)
    {
        li->valeur = valeur;
        return li2;
    }
    return modifier(position - 1, valeur, li->suivant);
}

int longueur(liste li)
{
    int lg = 0;
    while (li != NULL)
    {
        lg++;
        li = li->suivant;
    }
    return lg;
}

int longRec(liste li)
{
    return li == NULL ? 0 : 1 + longRec(li->suivant);
}

int nieme(int position, liste li)
{
    int i = 1;
    while (i < position && li != NULL)
    {
        li = li->suivant;
        i++;
    }
    if (position < 1 || li == NULL)
    {
        printf("Erreur nieme : position incorrecte\n");
        exit(2);
    }
    else
        return li->valeur;
}

liste insereTete(int element, liste lq)
{
    liste li = (liste)malloc(sizeof(struct cellule));
    if (li == NULL)
    {
        printf("Erreur insertion : plus de memoire\n");
        exit(1);
    }
    else
    {
        li->valeur = element;
        li->suivant = lq;
        return li;
    }
}

liste supprimerTete(liste li)
{
    if (li == NULL)
        return NULL;
    liste lq = li->suivant;
    free(li);
    return lq;
}

liste supprimer(int position, liste li)
{
    liste li2 = li;
    if (position == 1)
    {
        li2 = supprimerTete(li);
    }
    else
    {
        li2 = supprimer(position - 1, li->suivant);
    }
    return li2;
}

liste inserer(int element, int position, liste li)
{
    if (position < 1)
    {
        printf("Erreur insertion : position incorrecte\n");
        exit(2);
    }
    if (position == 1)
        return insereTete(element, li);
    int i = 2;
    liste prec = li;
    while (i < position && prec != NULL)
    {
        prec = prec->suivant;
        i++;
    }
    if (prec == NULL)
    {
        printf("Erreur insertion : position incorrecte\n");
        exit(2);
    }
    liste nouvCellule = (liste)malloc(sizeof(struct cellule));
    if (nouvCellule == NULL)
    {
        printf("Erreur insertion : plus de memoire\n");
        exit(1);
    }
    else
    {
        nouvCellule->valeur = element;
        nouvCellule->suivant = prec->suivant;
        prec->suivant = nouvCellule;
        return li;
    }
}

liste concatenerRec(liste li1, liste li2)
{
    if (li2 == NULL)
    {
        return li1;
    }
    else
    {
        int lg = longueur(li1);
        li2 = concatener(inserer(nieme(1, li2), lg + 1, li1), li2->suivant);
        return li2;
    }
}

liste concatener(liste li1, liste li2)
{
    liste liConcatene = li1;
    while (li1 != NULL)
    {
        li1 = li1->suivant;
    }
    li1 = li2;
    afficher(li1);
    return liConcatene;
}