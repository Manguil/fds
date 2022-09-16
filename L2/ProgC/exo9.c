#include <stdio.h>
#include <string.h>

char **strsplit(const char *s,const char sep)
{
    int nbSep = 0;
    int compteNbCararc = 0;
    for (int i = 0; s[i]!=NULL; i++)
    {
        if (s[i] == ":") nbSep ++;
        
    }
    char* tab[nbSep+2]
    for (int i = 0; s[i]!=NULL; i++)
    {
        int posTab = 0;
        if (s[i]==sep) posTab++;
        else strncat(tab[posTab])
    }
}