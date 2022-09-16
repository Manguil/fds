#include <stdio.h>

int main(int argc, char* argv[], char* env[])
{
    printf("%i\n", argc);
    //...
    for (int i=0; env[i]!=NULL; ++i) printf("%s\n",env[i]);
}