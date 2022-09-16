#include <stdio.h>
#include <stdbool.h>

typedef struct _Premierstermes{
    int terme1;
    int terme2;
} Ptermes;

int fibonacci(int n){
    int u0=Ptermes.terme1,u1=Ptermes.terme2,u=0;
    if (n==0 || n==1){
        printf("%d\n",n);
        return n;
        }
    else{
        for (int i=2;i<=n;i++){
        u=u1+u0;
        u0=u1;
        u1=u;
    }
    printf("%d\n",u);
    return u;
    }   
}

int main(){
    int n;
    //Ptermes fibo={0,1};
    printf("Saisir un entier positif :");
    scanf("%d,",&n);
    fibonacci(n);
    return 0;
}
