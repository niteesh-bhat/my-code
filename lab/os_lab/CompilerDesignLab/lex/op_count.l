%{
	int oprtrs = 0, oprnds = 0;
%}

%%
("+"|"-"|"*"|"/") {oprtrs++;}
[0-9]+(\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9_]* {oprnds++;}
(.|\n) ;
%%

int yywrap() {}

int main()
{
	printf("Enter arithmetic expression:\n");
	yylex();
	printf("Operators: %d\nOperands: %d\n",oprtrs, oprnds);
	return 0;
}
