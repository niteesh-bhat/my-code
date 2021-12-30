%{
	#include<stdio.h>
	#include<stdlib.h>
	int yylex();
	void yyerror(char *msg);
%}

%token NUM NL

%left '+' '-'
%left '*' '/'
%left '(' ')'

%%
start: EXPR NL {printf("Result = %d\n", $1); exit(0);}
	;
EXPR: EXPR '+' EXPR {$$ = $1 + $3;}
	| EXPR '-' EXPR {$$ = $1 - $3;}
	| EXPR '*' EXPR {$$ = $1 * $3;}
	| EXPR '/' EXPR {$$ = $1 / $3;}
	| NUM {$$ = $1;}
	| '-' NUM {$$ = -$2;}
	| '(' EXPR ')' {$$ = $2;}
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
