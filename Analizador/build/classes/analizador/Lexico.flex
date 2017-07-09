package analizador;

import static analizador.Tokens.*;


%%

%class Lexico

%line
%column
%type Tokens
letra = [a-zA-Z_]
digito = [0-9]
espacio = [\n]
tipo = real | entero

%{
public String lexeme;
%}

%%

({letra}({letra}|{digito})*) {return ID;}
("(") {return LPARENT;}
(")") {return RPARENT;}
("!=") {return DIF;}
("==") {return EQUALS;}
(">=")  {return MAYOR_IGUAL;}
("<=")  {return MENOR_IGUAL;}
(">")   {return MAYOR;}
("<")   {return MENOR;}
("=") {return ASSIGN;}
("+") {return PLUS;}
("*") {return TIMES;}
("-") {return MINUS;}
("/") {return DIVIDE;}
("%") {return MOD;}
("si") {lexeme=yytext(); return si;}
("fsi") {lexeme=yytext(); return s_end;}
("mientras")  {lexeme=yytext(); return w;}
("fmientras")  {lexeme=yytext(); return w_end;}
("leer") {lexeme=yytext(); return read;}
("escribir") {lexeme=yytext(); return write;}
("{") {return llaveI;}
("}") {return llaveD;}
("[") {return corcheteI;}
("]") {return corcheteD;}
({tipo}) {return tipo_dato;}
(",") {return coma;}
({espacio}) {return salto;}
({digito}{digito}*) {return NUM;}
