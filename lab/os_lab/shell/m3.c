#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
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
      printf("My Process id is %d and PPID is %d\n", getpid(), getppid());
      //execlp("/bin/ls", "ls",NULL);
        i+=10;
               
   } 
else { // Parent process 
      sleep(2);
      printf("This is parent process\n");
      i+=20;
      printf("My Process id is %d and PPID is %d\n", getpid(), getppid());
      
   }
   printf("i=%d\n",i);
   return 0;
}