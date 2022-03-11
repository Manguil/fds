#include <stdio.h>
#include "fibo3.h"

int main(){
    suite uFib = {0,1,2};
    int fib = 0;
    printf("Rentre un entier positif :\n");
    scanf("%d",&fib);
    printf("le %d terme est %d\n",fib ,fibonacci(fib,&uFib));
    return 0;
}