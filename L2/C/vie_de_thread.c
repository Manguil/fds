#include <stdio.h>
#include <pthread.h>


void* salut() {
    for (int i = 0; i < 100; i++) {
        printf("salut \n");
    }
    return NULL;
}

void* bonjour() {
    for (int i = 0; i < 100; i++) {
        printf("bonjour \n");
    }
    return NULL;
}

int main() {
    pthread_t mon_thread;
    pthread_create(&mon_thread, NULL, salut, NULL);
    
    pthread_t mon_thread2;
    pthread_create(&mon_thread2, NULL, bonjour, NULL);

    //attendre que le thread finisse
    pthread_join(mon_thread, NULL);
    pthread_join(mon_thread2, NULL);

    return 0;
}