#include <stdio.h>
#include <string.h>
#include <math.h>


int stringIntToInt(char* s){
    char tabInt[10] = {'0','1','2','3','4','5','6','7','8','9'};
    int nb = 0;
    printf("%i\n",strlen(s));
    for(int i = strlen(s); i > 0 ; i--){
        for (int k = 0; k < 11; k++){
            if (s[strlen(s)-i] == tabInt[k]){
                nb += k*pow(10,i-1);
            }
        }
    }
    return nb;
}

int main(){
    char* s = "2136";
    int i = 0;
    i = stringIntToInt(s);
    printf("%i\n",i);
    return 0;
}