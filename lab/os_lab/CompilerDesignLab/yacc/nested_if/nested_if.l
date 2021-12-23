%{
	#include"nested_if.tab.h"
%}

id [a-zA-Z][a-zA-Z0-9_]*
num [0-9]+
relop ("<"|">"|"<="|">="|"=="|"!=")
unaryop ("++"|"--")
binaryop ("+"|"-"|"*"|"/")

%%
"if" {return IF;}
"else" {return ELSE;}
{id} {return ID;}
{num} {return NUM;}
{relop} {return RELOP;}
{unaryop} {return UNARYOP;}
{binaryop} {return BINARYOP;}
[ \t\n] ;
. {return yytext[0];}
%%

int yywrap() {return 1;}
