#include <stdio.h>

typedef struct suite {
    int u0;
    int u1;
}suite;

suite uFib ={0,1};

void viderBuffer(void)
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
    if (n == uFib.u0 || n == uFib.u1) {return n;}
    return fibonacci(n-1,uFib)+fibonacci(n-2,uFib);
}

int main(){
    suite uFib = {0,1};
    int fib = 0;
    fib = saisieEntier();
    printf("le %d terme est %d\n", fib, fibonacci(fib));
    return 0;
}