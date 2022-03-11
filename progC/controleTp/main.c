#include <stdio.h>
#include "calcul.h"

int main(){
	int nb = -1;
	int nb1 = -1;
	int choix = 0;
	printf("choisi un nombre :\n");
	scanf("%d",&choix);
	switch (choix){
		case 1: {
			nb = saisieEntier(); nb1 = saisieEntier();
			printf("somme = %d\n", addition(nb,nb1));
			break;
		}
		case 2:{
			nb = saisieEntier(); nb1 = saisieEntier();
			int mul = 1;
			multiplication(nb, nb1, &mul);
			//printf("mul = %d\n", mul);
			break;
		}
		case 3 :{
			/*nb = saisieEntier(); nb1 = saisieEntier();
			cEntier couple = {nb,nb1}; */
			//cEntier couple = {0,0};
            printf("donne un couple N*N (format: (a,b))");
			//scanf("(%d,%d)",&couple.Entier1,&couple.Entier2);
			//printf("max = %d\n", monMax(couple));
			break;
		}
		default:{
			break;
		}
	}
	return 0;
}
