/* --------------------- fonction tp4 exo 1 --------------------- */
int sommDiv(int n);
_Bool testParfait(int n);
int nbParfait(int a, int b);
int niemeParfait(int n);

/* --------------------- fonction tp4 exo 2 --------------------- */
typedef struct temps
{
    int h;
    int m;
    float s;
} tps;

void afficherTemps(tps *t);
void verifTemps(tps *t);
float tempsEnSeconde(tps *t);
void secondeEnTemps(float s, tps *t);
float duree(tps *debut, tps *fin);
void heureArriveeV1(tps *tempsDepart, tps *duree, float coeff, tps *tempsMax, tps *tempsMin);
