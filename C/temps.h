struct temps {
    int h; int m; float s;
};

typedef struct temps tps;

void modifierTemps(tps *t);
void tempToSeconde(tps *t);