#include "calcul.h"
#include <stdio.h>
COUCOU

void viderBuffer(void)
{
  int c;
  while((c=getchar()) != EOF && c != '\n');
}

int saisieEntier(){
	int saisie = 0;
	char verif = 'a';
	printf("Rentre un entier : \n");
	if (scanf("%d%c", &saisie, &verif) != 2 || verif != '\n'){
		viderBuffer();
		printf("la saisie n'est pas correcte\n");
		saisieEntier();
	}
	else {return saisie;}
}

int addition(int entier1, int entier2){
	return entier1 + entier2;
}

void multiplication(int entierl, int entier2, int *entier3){
	*entier3 = entier2 * entierl;
}

int monMax(cEntier unCoupleEntiers){
	if (unCoupleEntiers.Entier1 >= unCoupleEntiers.Entier2) {return unCoupleEntiers.Entier1;}
	return unCoupleEntiers.Entier2;
}

COUCOU