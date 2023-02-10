#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 'Z'+1

char* ctos(char c)
{
    char* s = malloc(sizeof(char*));
    s[0] = c;
    return s;
}

int estPresent(char* s1, char* s2)
{
    int tailleMin = 0;
    if (strlen(s1) <= strlen(s2))
    {
        tailleMin = strlen(s1);
    }
    else
    {
        return 0;
    }
    if (tailleMin == 0) return 0;
    for (int k = 0; k < tailleMin ; k++)
        {
            if (s1[k]!= s2[k])
                return 0;
        } 
    return 1;
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
            if (estPresent(codage[j], temp))
            {
                i+=strlen(temp);
                strcat(result, temp);
                temp = "";
                break;
            }
        }
        printf("efv\n");
        printf("%s\n", ctos(s[i]));
        strcat(temp, ctos(s[i]));
        printf("efv\n");
        i++;
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
    printf("%s\n", result);
    char* result2 = decoder(codage,result);
    printf("%s\n", result2);
}