#include <stdio.h>


char* associe(char* s)
{
    switch (atoi(s))
    {
        case 11 : "A"
        case 101 : "B"
        case 100 : "C"
        default : "\0"
    }
}

char* decode(char* s)
{
    int i = 0;
    char* temp = ""
    char* res = "";
    while (s!=0)
    {
        temp = associe(s[i]);
        if (temp!=0){
            strcat(res,temp);
        else return "pas possible de decoder";
        }
    }
}

int main(int argc, char **argv)
{

}