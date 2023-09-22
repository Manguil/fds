/** converts an integer to a char string representing it in base 10
*@param i a positive integer
*@param s a ptr on a sufficiently large char array
*@return NULL if i is negative, s otherwise
*/
#include <stdio.h>
#include <string.h>
#include <math.h>



char *itoa(int i, char *s) {
    if (i < 0) return NULL;
    int j = 0;
    do {
        s[j++] = i % 10 + '0';
    } while ((i /= 10) > 0);
    s[j] = '\0';
    return s;
}


int main(){
    int i = 2136;
    char* s = intToStringInt(i);
    printf("%i\n",i);
    return 0;
}