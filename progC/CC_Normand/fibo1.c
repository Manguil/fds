#include <stdio.h>

int fibonacci(int n){
    if (n == 0 || n == 1) {return n;}
    return fibonacci(n-1)+fibonacci(n-2);
}

int main(){
    int fib = 0;
    printf("Rentre un entier positif :\n");
    scanf("%d",&fib);
    printf("le %d terme est %d\n", fib, fibonacci(fib));
    return 0;
}