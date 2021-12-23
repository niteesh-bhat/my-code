//read from file and write into a new file
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
int main()
{
char buf[100];
int n, fd1, fd2;
fd1 = open("m6.c", O_RDONLY);
n = read(fd1, buf, 100);
//("n=%d\n",n);
fd2 = open("m12.c", O_CREAT | O_WRONLY,0642);
write(fd2, buf, n);
write(1, buf, n);
printf("\n");
return 0;
}
//read-4 permission
//wr-2
//exe-1, user, group, others