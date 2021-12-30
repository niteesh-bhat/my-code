%{
	#include"ari_exp.tab.h"
%}

%%
([a-zA-Z]([a-zA-Z0-9_])*|[0-9]+(\.[0-9]+)?) {return OPRND;}
[\+\-\*\/] {return OPRTR;}
[ ] ;
\n {return NL;}
. {return yytext[0];}
%%

int yywrap() {return 1;}

