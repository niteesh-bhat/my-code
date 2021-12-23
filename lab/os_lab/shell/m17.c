

//Simualate cat >> f1 f2
#include<stdio.h>
#include<stdlib.h>
 int main(int argc,char*argv[])
 {
     FILE*fp;
     FILE *fp1;
     fp=fopen(argv[1],"a");
     fp1=fopen(argv[2],"r");
     char ch;
     while((ch=fgetc(fp1))!=EOF)
         fprintf(fp,"%c",ch);
     fclose(fp);
     fclose(fp1);
     return 0;

 }
