%{
	#include<stdio.h>
	#include<stdlib.h>
	#include<string.h>
	int vow = 0, cons = 0;
%}

%%
[aeiouAEIOU] {vow++;}
[a-zA-Z] 	{cons++;}
%%

int yywrap(void) {}

int main()
{
	printf("Enter string of alphabets:\n");
	printf("Press Ctrl + D to exit.\n\n");
	yylex();
	printf("Vowels: %d\nConsonants: %d\n", vow, cons);
	return 0;
}
