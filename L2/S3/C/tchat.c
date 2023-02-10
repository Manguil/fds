#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char **argv) {
    mkfifo(argv[1], S_IRUSR | S_IWUSR | S_IROTH | S_IWOTH);
    mkfifo(argv[2], S_IRUSR | S_IWUSR | S_IROTH | S_IWOTH);
    pid_t id = fork();

    if (id == 0) {
        int fd = open(argv[1], O_WRONLY);
        while (1) {
            printf("Vous : \n");
            char tampon[10] = "";
            scanf("%s", tampon);
            if (strcmp(tampon, "exit\n") == 0) {
                break;
            }
            write(fd, tampon, strlen(tampon));
            write(fd, "\n", 1);
        }
        printf("Au revoir\n");
        close(fd);
    }

    else {
        int fd = open(argv[2], O_RDONLY);
        if (fd == -1) {
            printf("Erreur\n");
            return 1;
        }
        while (1) {
            char tampon[1];
            read(fd, tampon, 1);
            printf("%s", tampon);
        }
    }
    unlink(argv[1]);
    unlink(argv[2]);
}