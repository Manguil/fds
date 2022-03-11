#include <stdio.h>

typedef struct suite {
    int u0;
    int u1;
}suite;

int fibonacci(int n,suite *uFib){
    if (n == (*uFib).u0 || n == (*uFib).u1) {return n;}
    return fibonacci(n-1,uFib)+fibonacci(n-2,uFib);
}

int main(){
    suite uFib = {0,1};
    int fib = 0;
    printf("Rentre un entier positif :\n");
    scanf("%d",&fib);
    printf("le %d terme est %d\n", fib, fibonacci(fib, &uFib));
    return 0;
}