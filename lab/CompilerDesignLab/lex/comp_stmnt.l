%{
	#include<string.h>
	int compound = 0;
%}

word [a-zA-Z]+

%%
{word} {
	if (strcmp(yytext, "and") == 0
	 || strcmp(yytext, "or") == 0
	 || strcmp(yytext, "but") == 0
	 || strcmp(yytext, "so") == 0) {
			compound = 1;
	 }
}
(.|\n) ;
%%

int yywrap() {}

int main() {
	printf("Enter a sentence:\n");
	yylex();
	if (compound)
		printf("Compound sentence.\n");
	else
		printf("Simple sentence.\n");
	return 0;
}
