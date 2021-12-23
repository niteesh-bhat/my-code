%{
	#include"dec_def.tab.h"
%}

%%
("int"|"float"|"char"|"void") {return TYPE;}
[a-zA-Z]([a-zA-Z0-9_])* {return ID;}
. {return yytext[0];}
%%

int yywrap() {return 1;}

