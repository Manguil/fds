#include <stdio.h>
#include <signal.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>

 void handle_error(int sig){
    errno = sig;
    printf("%d %d %s\n",sig,errno,strerror(errno));
    exit(1);
 }

int main(void){
    struct sigaction action;
    action.sa_handler = handle_error;
    sigaction(SIGSEGV, &action, NULL);

    int t[4];
    t[200000] = 2;
    return 0;
}
