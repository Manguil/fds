#include "calcul.h"
#include <stdio.h>

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

}

void multiplication(int entierl, int entier2, int *entier3);

int monMax(cEntier unCoupleEntiers);

int main(){
	int nb = -1;
	nb = saisieEntier();
	printf("Entier ; %d\n",nb);
	return 0;
}