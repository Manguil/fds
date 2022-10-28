#include <unistd.h>
#include <stdio.h>
#include <signal.h>

void hangleSigalarm(int sig) {
    printf("yo\n");
}


int main() {
    struct sigaction  event;
    event.sa_handler = hangleSigalarm;
    sigaction(SIGALRM, &event, NULL);
    alarm(2);
    while(1)
}