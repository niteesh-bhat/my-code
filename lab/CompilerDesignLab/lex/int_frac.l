%{
	int pint = 0, nint = 0, pfrac = 0, nfrac = 0;
%}

/* Rules */
digit [0-9]

%%

\+?{digit}+ {pint++;}
\-{digit}+ {nint++;}
\+?{digit}+\.{digit}+ {pfrac++;}
\-{digit}+\.{digit}+ {nfrac++;}

%%

int yywrap() {}

int main()
{
	printf("Enter string\n");
	printf("Press Ctrl + D to exit.\n\n");
	yylex();
	printf("Positive integers: %d\nNegative integers: %d\n", pint, nint);
	printf("Positive fractions: %d\nNegative fractions: %d\n", pfrac, nfrac);
	return 0;
}
