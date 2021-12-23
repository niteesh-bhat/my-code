#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#define   BUF_SIZE   100

int main() 
{
   char   buf[BUF_SIZE];
   printf("Before fork\n");
   fork();
   fork();
   fork();
   sprintf(buf, "After fork() system call\n");
   write(1, buf, strlen(buf));
   //fork();
   //printf("Second fork call\n");
   return 0;
}