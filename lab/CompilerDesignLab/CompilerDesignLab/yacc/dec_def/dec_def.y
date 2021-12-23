%{
	#include<stdio.h>
	#include<stdlib.h>
	
	int yylex();
	void yyerror(char *msg);
	
	extern FILE *yyin;
%}

%%

%%


