#include "fibo3.h"


void maodifieK(suite *uFib, int nk){
    (*uFib).k = nk;
}

int kNacci(int n){}

int fibonacci(int n,suite *uFib){
    int som = 0;
    if (n == (*uFib).u0 || n == (*uFib).u1) {return n;}
    for (int i = 1; i<=(*uFib).k; i++){
        som += fibonacci(n-i,uFib);
    }
    return som;
}