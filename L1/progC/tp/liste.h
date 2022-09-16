#ifndef liste_h
#define liste_h

typedef struct cellule
{
    int valeur;
    struct cellule *suivant;
} * liste;

void afficher(liste li); // v

int longueur(liste li); // v

int longRec(liste li); // v

int nieme(int position, liste li); // v

liste insereTete(int element, liste lq); // v

liste supprimerTete(liste li); // v

liste inserer(int element, int position, liste li); // v

liste supprimer(int position, liste li); // v

liste modifier(int position, int valeur, liste li); // v

liste concatenerRec(liste li1, liste li2); // v

liste concatener(liste li1, liste li2); // v

liste permuter(int position1, int position2, liste li); // v

liste dupliquer(int choix, liste li1, liste li2);

_Bool insererBis(int element, int position, liste li);

liste extrairePairs(liste li);

#endif /* liste_h */
