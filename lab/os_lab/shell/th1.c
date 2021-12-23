//Simple multitreading program; to compile - gcc th1.c -pthread
#include<stdio.h>
#include<unistd.h>
#include<pthread.h>
void * threadfun(); // the Thread routine with no parameters
int i, j, n;
void main()
{
  pthread_t T1; //thread id
  pthread_create(&T1, NULL, threadfun, NULL);//create thread
  //pthread_create(&tid, &attr, threadfun, args);
  pthread_join(T1,NULL);//the main thread waits for child thread to complete
  printf("Inside main thread\n");
  for(i=10; i<=15;i++)
  {
   printf("i=%d\n",i);
   sleep(1);
  }
 }
void * threadfun() 
{  
  printf("inside thread\n");
  for(j=1; j<=5;j++)
  {
   printf("j=%d\n",j);
   sleep(1);
  }
}