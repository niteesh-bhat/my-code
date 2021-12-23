%{
	#include<stdio.h>
	#include<stdlib.h>
	int yylex();
	void yyerror(char *msg);
%}

%token OPRND OPRTR NL

%left '(' ')'

%%
start: EXPR NL {printf("Valid arithmetic expression\n"); exit(0);}
	;
EXPR: OPRND A
	| '(' EXPR ')' A
	;
A: OPRTR EXPR A |
	;
%%

void yyerror(char *msg) {
	printf("Invalid  expression\n");
	exit(0);
}

int main() {
	printf("Enter aritmetic expression:\n");
	yyparse();
	return 0;
}
