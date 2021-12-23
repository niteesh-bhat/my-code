//ZOMBIE PROCESS
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include<stdlib.h>

int main() 
{
   pid_t pid;
   printf("Before fork: Process id is %d\n", getpid());
   pid = fork();

   if (pid < 0) 
   {
      perror("fork() failure\n");
      return 1;
   }
   // Child process
   if (pid == 0) 
   {
      //sleep(5);
      printf("This is child process with id=%d\n parent id=%d\n", getpid(), getppid());
      exit(0);
                      
   } 
else 
    { // Parent process 
      //wait(NULL);
      sleep(5);
      printf("This is parent process with id=%d\n and child id=%d\n", getpid(),pid);
    }
         
   return 0;
}