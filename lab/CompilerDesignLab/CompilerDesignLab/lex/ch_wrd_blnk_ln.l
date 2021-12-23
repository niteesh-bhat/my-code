%{
	int ch = 0, wrd = 0, blnk = 0, ln = 0;
%}

%%

	/* yyleng contains length of matched string */

[a-zA-z0-9]+ {wrd++; ch += yyleng;}
" " {blnk++; ch++;}
\n {ln++; ch++;}

%%

int yywrap() {}

int main()
{
	printf("Enter string\n");
	printf("Press Ctrl + D to exit.\n\n");
	yylex();
	printf("\nCharacters: %d\nWords: %d\nBlanks: %d\nLines: %d\n", ch, wrd, blnk, ln);
	return 0;
}
