//the main thread catching the returned status of child thread
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
void *sum(void *arg);
int a[5]={1,2,3,4,5};
int sm=0;
void *res;
void main()
{
  pthread_t T1;
  pthread_attr_t attr;
  pthread_attr_init(&attr);
  pthread_create(&T1, &attr, sum, (void *)a);
  pthread_join(T1,&res);//&res is the pointer to the location where the exit status of the thread mentioned in th is stored
  printf("Inside main thread\n");
  printf("sum=%d\n",sm);
  printf("thread returned: %s\n",(char *)res);
 }
void *sum(void *parm) 
{ 
  int i; 
   //n = atoi(parm);
   int *x=parm;
   printf("inside thread\n");
   for(i=0;i<5;i++)
    sm+=x[i]; 
      
 pthread_exit("sum calculated");  

}
