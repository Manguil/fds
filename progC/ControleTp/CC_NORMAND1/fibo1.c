#include <stdio.h>

int fibonacci(int n){
    if (n == 0 || n == 1) {return n;}
    return fibonacci(n-1)+fibonacci(n-2);
}

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

int main(){
    int fib = 0;
    fib = saisieEntier();
    printf("le %d terme est %d\n", fib, fibonacci(fib));
    return 0;
}