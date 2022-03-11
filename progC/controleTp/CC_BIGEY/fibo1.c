#include <stdio.h>
#include <stdbool.h>

int fibonacci(int n){
    int u1=0,u2=1,u=0;
    for (int i=2;i<=n;i++){
        u=u1+u2;
        u1=u2;
        u2=u;
    }
    printf("%d\n",u);
    return u;
}

int main(){
    int n;
    printf("Saisir le nieme :");
    scanf("%d,",&n);
    fibonacci(n);
    return 0;
}