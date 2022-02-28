#include "parfait.h"
#include <math.h>


int sommDiv(int n){
    int div = 0;
    for (int i=1; i<floor(n/2)+1; i++){
        if (n%i == 0) div+=i;
    }
    return div;
}



_Bool testParfait(int n){
    return (sommDiv(n) == n);
} 



int nbParfait(int a, int b){
    int nb = 0;
    for (int i = a; i <= b; i++){
        if (testParfait(i)) nb++;
    }
    return nb;
}



int niemeParfait(int n){
    int i = 0,dernierParfait = 1;
    while (i<=n){
        if (testParfait(i)){
            dernierParfait = i;
        }
        i++;
    }
    return dernierParfait;
}