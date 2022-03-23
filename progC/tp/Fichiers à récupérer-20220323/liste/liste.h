#ifndef liste_h
#define liste_h

struct cellule {
    int valeur;
    struct cellule *suivant;
};

typedef struct cellule * liste;

int longueur(liste li);

int longRec(liste li);

int nieme(int position, liste li);

liste insereTete(int element, liste lq);

liste supprimerTete(liste li);

liste inserer(int element, int position, liste li);

liste supprimer(int position, liste li);

liste modifier(int position, int valeur, liste li);

liste concatener(liste li1, liste li2);

liste permuter(liste li);

liste dupliquer(liste li);

_Bool insererBis(int element, int position, liste *li);

#endif /* liste_h */
