#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 'Z'+1

char* ctos(char c)
{
    char* s = malloc(1);
    s[0] = c;
    return s;
}


char* encoder(char** codage, char* s) 
{
    char* result = malloc(sizeof(char)*strlen(s));
    for(int i=0; s[i] != 0; i++)
    {
        strcat(result, codage[s[i]]);
    }
    return result;
}


char* decoder(char** codage, char* s) 
{
    char* temp = malloc(sizeof(char)*3);
    char* result = malloc(sizeof(char)*strlen(s)/2);
    int i=0;
    while(s[i] != 0)
    {
        for(int j='A'; j <= 'Z'; j++)
        {
            if (codage[j] == temp)
            {
                strcat(result, ctos(j));
                temp = "";
                i+=j;
                break;
            }
            strcat(temp, s[i]);
        }
    }
    return result;
}



int main(int argc, char **argv)
{
    char* codage[MAX_SIZE];
    for(int i='A'; i<='Z'; i++)
    {
        codage[i] = "";
    }
    codage['A'] = "01";
    codage['B'] = "11";
    codage['C'] = "101";
    char* s = "CAC";
    char* result = encoder(codage,s);
    char* result2 = decoder(codage,s);
    printf("%s\n", result2);
}