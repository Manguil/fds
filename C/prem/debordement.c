#include <stdio.h>

int main() {
    int j = 1023;
    char c = 'Z';
    char d = 'X';
    short i = 100;
    printf("i vaut %d, j vaut %d, c vaut <%c> et d vaut <%c>\n",i,j,c,d);
    printf("Saisir un entier pour i : ");
    scanf("%d",&i);
    printf("i vaut %d, j vaut %d, c vaut <%c> et d vaut <%c>\n",i,j,c,d);
    printf("Saisir un caractère pour c : ");
    scanf("%s",&c);
    printf("i vaut %d, j vaut %d, c vaut <%c> et d vaut <%c>\n",i,j,c,d);
    return 0;
}