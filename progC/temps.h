struct temps {
    int h; int m; float s;
};

typedef struct temps tps;

void afficherTemps(tps *t);
void verifTemps(tps *t);
void modifierTemps(tps *t);
float tempsEnSeconde(tps *t);
void secondeEnTemps(float s, tps *t);
float duree(tps *debut, tps *fin);