package analizador;

import static analizador.Tokens.*;
import java_cup.runtime.*;
import java.io.FileReader;

%%

%class Lexico

%line
%column
%cup
%type Tokens
letra = [a-zA-Z_]
digito = [0-9]
espacio = [\n]

%{
public String lexeme;
%}

%%
("entero") {return tipo_dato;}
("si") {lexeme=yytext(); return SI;}
("fsi") {lexeme=yytext(); return s_end;}
("mientras")  {lexeme=yytext(); return w;}
("fmientras")  {lexeme=yytext(); return w_end;}
("leer") {lexeme=yytext(); return read;}
("escribir") {lexeme=yytext(); return write;}
({letra}({letra}|{digito})*) {return ID;}
({espacio}) {return salto;}
({digito}{digito}*) {return NUM;}
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
("{") {return llaveI;}
("}") {return llaveD;}
("[") {return corcheteI;}
("]") {return corcheteD;}
(",") {return coma;}

