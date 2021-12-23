#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
int main() 
{
   pid_t pid, mypid, myppid;
   int i=10;
   pid = getpid();
   printf("Before fork: Process id is %d\n", pid);
   pid = fork();
   if (pid < 0) 
   {
      perror("fork() failure\n");
      return 1;
   }
   // Child process
   if (pid == 0) 
   {
      printf("This is child process\n");
      execlp("./eg", "eg",NULL);// The object file name of ex.c; gcc ex.c -o eg
      printf("End of child process\n");//is executed only if there is error in execlp call               
   } 
else { // Parent process 
      wait(NULL);
      printf("This is parent process\n");
      exit(0);
      }
   printf("i=%d\n",i);
  return 0;
}