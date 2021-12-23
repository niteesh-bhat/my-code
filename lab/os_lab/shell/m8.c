//to demonstrate the use of I/O system calls for console
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main()
{
char buf[30];
int n;
//read(int __fd, void *__buf, size_t __nbytes)
//write(int __fd, const void *__buf, size_t __n)
n = read(0, buf, 30);//fd=0 for std. i/p device
//fd-file descriptor; buf-buffer to read data from; nbytes-length of buffer; n- number of bytes read on success
printf("n=%d\n",n);
write(1, buf, n);//fd=1 for std. o/p device
return 0;
}

