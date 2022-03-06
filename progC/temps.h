struct temps {
    int h; int m; float s;
};

typedef struct temps tps;

void afficherTemps(tps *t);
void modifierTemps(tps *t);
long tempsEnSeconde(tps *t);
void secondeEnTemps(long s, tps *t);