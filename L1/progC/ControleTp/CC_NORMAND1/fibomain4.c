#include <stdio.h>
#include "fibo3.h"

int main(){
    suite uFib = {0,1,2};
    int fib = 0;
    fib = saisieEntier();
    printf("le %d terme est %d\n",fib ,fibonacci(fib));
    return 0;
}