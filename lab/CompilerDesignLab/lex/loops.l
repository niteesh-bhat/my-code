%{
	int forcount = 0, whilecount = 0;
	FILE *fp = NULL;
%}

	/* RULES */
chars [a-zA-Z]
digit [0-9]
us _
type ("int"|"float"|"void")
id {chars}({chars}|{digit}|{us})+
newline \n
blank " "
number (\+|-)?{digit}+\.{digit}+
relop "<"|">"|"=="|"!="|"<="|">="

for "for"{blank}*\((({type}{blank}+)?{id}{blank}*\={blank}*{number})*{blank}*\;({blank}*({id}|{number}){relop}{blank}*({id}|{number}){blank}*)*\;({blank}*{id}("++"|"--"){blank}*)*\)({blank}|{newline})*(\{)?(.|{newline})*(\})?
while "while"{blank}*\(({blank}*({id}|{number}){relop}{blank}*({id}|{number}){blank}*)*\)({blank}|{newline})*(\{)?(.|{newline})*(\})?

%%
for {forcount++;}
while {whilecount++;}
(.|{newline}) ;
%%

int yywrap() {}

int main()
{
	fp = (FILE *) fopen("input.c", "r");
	yyin = fp;
	printf("Reading \"input.c\".\n");
	yylex();
	printf("For count: %d\n", forcount);
	printf("While count: %d\n", whilecount);
	return 0;
}
