#include <stdio.h>
#include "impair.h"


int impair(unsigned int i){
    if (i==0)
        return 0;
    else
        return pair(i-1);
}