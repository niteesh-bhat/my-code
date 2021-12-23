%{
	// #include<file.h>
	int valid = 0;
	FILE *fp = NULL;
%}

/* Rules */
chars [a-zA-Z]
digit [0-9]
us _
id {chars}({chars}|{digit}|{us})+
newline \n
blank " "
preprocessor "#define"{blank}+{id}{blank}+(\+|-)?{digit}+(\.{digit}+)?
include "#include"{blank}*\<{id}\."h"\>

%%
({include}|{newline}|{preprocessor})*"int main\(\)"({newline}|{blank})*\{(.|{newline}|{blank})*\} {valid = 1;}
%%

int yywrap() {}

int main()
{
	fp = (FILE *) fopen("input.c", "r");
	yyin = fp;
	printf("Reading \"input.c\".\n");
	yylex();
	if (valid == 1)
		printf("Valid C pogram\n");
	else
		printf("Invalid C program\n");
	return 0;
}
