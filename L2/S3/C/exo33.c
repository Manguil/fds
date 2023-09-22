#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>


int main(){
    pid_t pid;
    switch(pid = fork()){
        case -1:
        { // echec du fork
            printf("Probleme : echec du fork") ;
            break ;
        }
        case 0:
        { // c'est le descendant
            printf("descendant : valeur de retour de fork() :%d\n", pid);
            printf("descendant : je suis %d de parent %d \n",getpid(),getppid()) ;
            return 4;
        }
        default:
        { // c'est le parent
            printf("parent : valeur de retour de fork() :%d\n", pid);
            printf("parent : je suis %d de parent %d\n", getpid(),getppid());
        }
    }
    int s = 0;
    pid_t fils = waitpid(pid, &s, 0);
    printf("Mort de %d avec le code  %d\n", fils, WEXITSTATUS(s));
}