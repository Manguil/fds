#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(int argc, char* argv[])
{
    float op1, op2;
    switch(argc) {
        case 3 :
            op1 = atof(argv[2]);
            if(strcmp(argv[1],"sqr")==0) {
                printf("\tsquare(%f) = %f\n", op1, pow(op1,2));
                exit(EXIT_SUCCESS);
            } else if(strcmp(argv[1],"sqrt")==0) {
                printf("\tsquare_root(%f) = %f\n", op1, sqrt(op1));
                exit(EXIT_SUCCESS);
            } else break;
        case 4 :
            op1 = atof(argv[1]);
            op2 = atof(argv[3]);
            if(strcmp(argv[2],"+")==0) {
                printf("\t%f + %f = %f\n", op1, op2, op1+op2);
                exit(EXIT_SUCCESS);
            } else if(strcmp(argv[2],"-")==0) {
                printf("\t%f - %f = %f\n", op1, op2, op1-op2);
                exit(EXIT_SUCCESS);
            } else if(strcmp(argv[2],"*")==0) {
                printf("\t%f * %f = %f\n", op1, op2, op1*op2);
                exit(EXIT_SUCCESS);
            } else if(strcmp(argv[2],"/")==0) {
                printf("\t%f / %f = %f\n", op1, op2, op1/op2);
                exit(EXIT_SUCCESS);
            } else break;
    }
    printf("Usage: %s [operand] {sqr|sqrt|+|-|*|/} operand\n",argv[0]);
    exit(EXIT_FAILURE);
}

