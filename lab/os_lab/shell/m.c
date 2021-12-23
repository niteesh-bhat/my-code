#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main() 
{
   printf("Before fork\n");
   fork();
   //fork();
   //fork();
   printf("After first fork() call\n");
   fork();
   printf("After Second fork() call\n");
   fork();
   printf("After Third fork() call\n");
   return 0;
}