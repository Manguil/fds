#include <stdio.h>
#include <stdbool.h>

int fibonacci(int n){
    int u0=0,u1=1,u=0;
    if (n==0){
        printf("%d\n",u0);
        return 0;
        }
    else { 
        if (n==1){
            printf("%d",u1);
            return u1;
        }
    }
    else{
        for (int i=1;i<=n;i++){
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
    printf("Saisir le nieme :");
    scanf("%d,",&n);
    fibonacci(n);
    return 0;
}