#include <stdio.h>

int addition(int a,int b){
    return a+b;
}

int main(){
    printf("%d\n",addition(5,4));
    return 0;
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

///Makefile
main : main.o calcul.o
	gcc main.o calcul.o -o main
	

main.o : main.c calcul.h
	gcc -Wall -c main.c

calcul.o : calcul.c calcul.h
	gcc -Wall -c calcul.c

.PHONY: clean

clean:
	rm -f *.o


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

typedef struct coupleEntier
{
    int Entier1;
    int Entier2;
}cEntier;

int saisiEntier();

int addition(int entier1, int entier2);

void multiplication(int entierl, int entier2, int *entier3);

int monMax(cEntier unCoupleEntiers);