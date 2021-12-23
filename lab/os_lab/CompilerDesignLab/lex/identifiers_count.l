%{
	int count = 0;
	FILE *fp;
%}

/* Rules */
chars [a-zA-Z]
digit [0-9]
us _

%%
{digit}+({chars}|{digit}|{us})+ ; /* Ignore words starting with a number */
{chars}({chars}|{digit}|{us})+ {count++;}
(.|\n) ; /* Ignore anything else */
%%

int yywrap(void) {}

int main()
{
	fp = (FILE *) fopen("input.c", "r");
	yyin = fp;
	yylex();
	printf("Number of identifiers: %d\n", count);
	return 0;
}
