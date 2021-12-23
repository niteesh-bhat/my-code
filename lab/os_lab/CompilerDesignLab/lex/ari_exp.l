%{
	int valid = 1, top = -1, i = 0, j = 0; // i - Operands, j - Operators
	int temp_oprnd = 0, temp_oprtr = 0; // Temporary variables to assume expression is valid
	char oprnds[10][10], oprtrs[10][10], stk[50];
%}

/* RULES */
chars [a-zA-Z]
digit [0-9]
us _
blank " "
id {chars}({chars}|{digit}|{us})*
number {digit}+
operand ({id}|{number})
operator ("+"|"-"|"*"|"/"|"^")

%%
"(" {stk[++top] = '(';}
"{" {stk[++top] = '{';}
"[" {stk[++top] = '[';}
")" {
	if (stk[top] != '(' | temp_oprnd - temp_oprtr != 1)
		valid = 0;
	else {
		--top;
		temp_oprnd = 1, temp_oprtr = 0;
	}
}
"}" {
	if (stk[top] != '{' | temp_oprnd - temp_oprtr != 1)
		valid = 0;
	else {
		--top;
		temp_oprnd = 1, temp_oprtr = 0;
	}
}
"]" {
	if (stk[top] != '[' | temp_oprnd - temp_oprtr != 1)
		valid = 0;
	else {
		--top;
		temp_oprnd = 1, temp_oprtr = 0;
	}
}
	/* Says valid for postfix and prefix expressions also */
{operand} {temp_oprnd++; strcpy(oprnds[i++], yytext);}
{operator} {temp_oprtr++; strcpy(oprtrs[j++], yytext);}
(.|\n) ;
%%

int yywrap() {}

int main()
{
	printf("Enter arithmetic expression:\n");
	yylex();
	printf("Operands count: %d\nOperators count: %d\n", i, j);
	printf("\nOperands: ");
	for(int k = 0; k <= i; k++)
		printf("%s ", oprnds[k]);
	printf("\nOperators: ");
	for(int k = 0; k <= j; k++)
		printf("%s ", oprtrs[k]);
	printf("\n");
	if(valid == 1 && top == -1 && i - j == 1)
		printf("Valid arithmetic expression\n");
	else
		printf("Invalid arithmetic expression\n");
	return 0;
}
