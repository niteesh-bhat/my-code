//CONSUMER PROGRAM SHARED MEMORY
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/shm.h>
#include<sys/ipc.h>
#include<sys/stat.h>
#include<fcntl.h>
#include<sys/mman.h>
int main() 
{
void * psm;
int shmid;
shmid = shm_open("OS", O_RDONLY, 0666);
ftruncate(shmid, 1024);
psm = mmap(0, 1024, PROT_READ, MAP_SHARED, shmid, 0);
printf("Key/ID/fs of the shared memory: %d\n", shmid);
printf("shared memory for consumer is attached at:%p\n", psm);
printf("%s", (char * ) psm);
printf("\n");
shm_unlink("OS");
return 0;
}