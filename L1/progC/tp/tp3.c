#include <stdio.h>
#include <math.h>
#include "tp3.h"

/* --------------------- fonction tp3 exo 1 --------------------- */
float saisiNote()
{
    float note = -1;
    printf("Rentre ta note : \n");
    scanf("%f", &note);
    if (note < 0 || note > 20)
        return -1;
    return note;
}

float moyenne(int n)
{
    float note = 0;
    float moy = 0;
    for (int i = 0; i < n; i++)
    {
        note = saisiNote();
        while (note == -1)
            note = saisiNote();
        moy = moy + note;
    }
    moy = moy / n;
    return moy;
}

/* --------------------- fonction tp3 exo 2 --------------------- */
int unite(int n)
{
    return n % 10;
}

int dizaine(int n)
{
    return unite(n / 10);
}

int centaine(int n)
{
    return unite(n / 100);
}

_Bool testeProp(int n)
{
    if (pow(unite(n), 3) + pow(dizaine(n), 3) + pow(centaine(n), 3) == n)
        return 1;
    return 0;
}

/* --------------------- fonction tp3 exo 3 --------------------- */
_Bool bissextile(int n)
{
    if (n % 400 == 0)
        return 1;
    else if (n % 100 == 0)
        return 0;
    else if (n % 4 == 0)
        return 1;
    else
        return 0;
}

_Bool dateValide(int jour, int mois, int annee)
{
    _Bool a = 0;
    if (annee > 1582)
    {
        /*
        if (mois > 0 && mois <= 12){
            if (mois == 2 && bissextile(annee) && jour > 0 && jour <= 29)
                a = 1;
            else if (mois == 2 && !bissextile(annee) && jour > 0 && jour <= 28)
                a = 1;
            else if (mois <= 7 && mois%2 == 1 && jour > 1 && jour <= 31)
                a = 1;
            else if (mois > 7 && mois%2 == 0 && jour > 1 && jour <= 30)
                a = 1;
            else if (mois <= 7 && mois%2 == 0 && jour > 1 && jour <= 30)
                a = 1;
            else if (mois > 7 && mois%2 == 1 && jour > 1 && jour <= 31)
                a = 1;
            */
        switch (mois)
        {
        case 1:
            if (jour > 0 && jour <= 31)
                a = 1;
            break;
        case 2:
            if (bissextile(annee))
            {
                if (jour > 0 && jour <= 29)
                    a = 1;
                break;
            }
            else
            {
                if (jour > 0 && jour <= 28)
                    a = 1;
                break;
            }
        case 3:
            if (jour > 0 && jour <= 31)
                a = 1;
            break;
        case 4:
            if (jour > 0 && jour <= 30)
                a = 1;
            break;
        case 5:
            if (jour > 0 && jour <= 31)
                a = 1;
            break;
        case 6:
            if (jour > 0 && jour <= 30)
                a = 1;
            break;
        case 7:
            if (jour > 0 && jour <= 31)
                a = 1;
            break;
        case 8:
            if (jour > 0 && jour <= 31)
                a = 1;
            break;
        case 9:
            if (jour > 0 && jour <= 30)
                a = 1;
            break;
        case 10:
            if (jour > 0 && jour <= 31)
                a = 1;
            break;
        case 11:
            if (jour > 0 && jour <= 30)
                a = 1;
            break;
        case 12:
            if (jour > 0 && jour <= 31)
                a = 1;
        }
    }
    return a;
}

int nbJourMois(int mois, int annee)
{
    if (mois == 2 && bissextile(annee))
        return 29;
    else if (mois == 2 && !bissextile(annee))
        return 28;
    else if (mois <= 7 && mois % 2 == 1)
        return 31;
    else if (mois <= 7 && mois % 2 == 0)
        return 30;
    else if (mois > 7 && mois % 2 == 0)
        return 31;
    else if (mois > 7 && mois % 2 == 1)
        return 30;
    else
        return 0;
}

void compteJours(int anneeCourante, int jour, int mois, int annee)
{
    int nbJour = 0;
    int diffAnnee;
    if (anneeCourante <= annee)
    {
        diffAnnee = annee - anneeCourante;
        for (int i = 0; i < diffAnnee; i++)
        {
            if (bissextile(anneeCourante + i))
                nbJour++;
        }
        nbJour += 365 * diffAnnee;
        for (int i = mois - 1; i > 0; i--)
        {
            nbJour += nbJourMois(mois - i, annee);
        }
        if (diffAnnee == 0)
            nbJour += (jour - (1 * (mois - 1)));
        else
            nbJour += (jour - 1);
        printf("Il y a %d jours entre le 1/1/%d et le %d/%d/%d", nbJour, anneeCourante, jour, mois, annee);
    }
}

void compteNombresAnneesBissextiles(int nbAnnee)
{
    printf("%d", nbAnnee / 4 - nbAnnee / 100 + nbAnnee / 400 + 2);
}