//USING SHMGET, SHMAT SYSTEM CALLS
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/shm.h>
#include<sys/ipc.h>
int main() {
void * psm;
char buf[10];
int shmid;
//To get the shared memory id
shmid = shmget((key_t) 1122, 1024, 0666 | IPC_CREAT);
printf("Key of the shared memory: %d\n", shmid);
//To attach shared memory segment to an address space
psm = shmat(shmid, NULL, 0666);
printf("memory attached at:%p\n", psm);
printf("enter some data to write to shared memory\n");
read(0, buf, 10);
sprintf(psm, "%s", buf);
//To detach the shared memory segment from the address space of the calling process.
shmdt(psm);
return 0;
}