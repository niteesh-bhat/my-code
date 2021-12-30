%{
        #include<stdio.h>
        #include<stdlib.h>

        int yylex();
        void yyerror(char *msg);
        
        extern FILE *yyin;
        int count = 0;
%}

%token IF ELSE ID RELOP UNARYOP BINARYOP NUM

%%
start: if_stmt {printf("Valid if statement\n");}
    ;
if_stmt: IF '(' expr ')' '{'
        statements
    '}'
        {count++;}
    | IF '(' expr ')' '{'
        statements
    '}' ELSE '{'
        statements
    '}'
        {count++;}
    ;
expr: ID
    | NUM
    | ID '=' expr
    | expr BINARYOP expr
    | expr UNARYOP
    | expr RELOP expr
    |
    ;
statements: statement statements
    |
    ;
statement: if_stmt
    | expr ';'
    ;
%%

void yyerror(char *msg) {
        printf("Invalid statement\n");
        exit(0);
}

int main() {
    yyin = fopen("input.txt", "r");
    if(!yyin) {
        printf("File not found!\n");
        return;
    }

    do {
        yyparse();
    } while (!feof(yyin));

    printf("IF statements: %d\n", count);
    return 0;
}