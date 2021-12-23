%{
	int count = 0;
%}

/* Rules */
chars [a-zA-Z]
digit [0-9]
us _

%%
{digit}+({chars}|{digit}|{us})+ ; /* Ignore */
{chars}({chars}|{digit}|{us})+ {count++;}
. /* Ignore anything else */
%%

int yywrap(void) {}

int main()
{
	printf("Enter string\n");
	printf("Press Ctrl + D to exit.\n\n");
	yylex();
	printf("Identifiers: %d\n", count);
	return 0;
}
