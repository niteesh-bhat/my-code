%{
	int scanf_count = 0, printf_count = 0;
	FILE *fip = NULL, *fop = NULL;
%}

%%
"scanf" {scanf_count++; fprintf(yyout, "READ");}
"printf" {printf_count++; fprintf(yyout, "WRITE");}
%%

int yywrap() {}

int main()
{
	fip = (FILE *) fopen("input.c", "r");
	fop = (FILE *) fopen("output.c", "w");
	yyin = fip;
	yyout = fop;
	printf("Reading \"input.c\".\n");
	yylex();
	printf("Number of scanf and printf statements: %d, %d\n", scanf_count, printf_count);
	return 0;
}
