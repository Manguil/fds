#include "fibo3.h"

suite uFib = {0,1,2};

void viderBuffer()
{
  int c;
  while((c=getchar()) != EOF && c != '\n');
}

int saisieEntier(){
	int saisie = 0;
	char verif = 'a';
	printf("Rentre un entier : \n");
	if (scanf("%d%c", &saisie, &verif) != 2 || verif != '\n' || saisie < 0){
		viderBuffer();
		printf("la saisie n'est pas correcte\n");
		saisieEntier();
	}
	else {return saisie;}
}

int fibonacci(int n){
    int som = 0;
    if (n == uFib.u0 || n == uFib.u1) {return n;}
    for (int i = 1; i<=uFib.k; i++){
        som += fibonacci(n-i);
    }
    return som;
}