#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    mkfifo("ma_file", S_IRUSR | S_IWUSR | S_IROTH | S_IWOTH);
    int fd = open("fds/L2/C/ma_file", O_WRONLY);
    write(fd, "salut", 5);
    while (1) {

    }
    close(fd);
}