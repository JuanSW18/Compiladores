/*-------Codigo de usuario-------*/
//Este seccion es la que queremos que aparezca en el archivo generado

package analizador;

import static analizador.Tokens.*;

/*------------------------------*/


/*----------------------Declaraciones FLEX----------------------*/
%%
//Nombre de la clase que se va a generar
%class Lexico

//Declaraciones de Expresiones Regulares
%line
%column
%type Tokens
letra = [a-zA-Z_]
digito = [0-9]
espacio = [\n]
tipo = real | entero

%{
public String lexema;
%}

%%
/*-------------------------------------------------------------*/


/*-------LOGICA - Reglas Lexicograficas-------*/
{letra}({letra}|{digito})* {return ID;}
"(" {return LPARENT;}
")" {return RPARENT;}
"!=" {return DIF;}
"==" {return EQUALS;}
">="  {return MAYOR_IGUAL;}
"<="  {return MENOR_IGUAL;}
">"   {return MAYOR;}
"<"   {return MENOR;}
"=" {return ASSIGN;}
"+" {return PLUS;}
"*" {return TIMES;}
"-" {return MINUS;}
"/" {return DIVIDE;}
"si" {return s;}
"fsi" {return s_end;}
"mientras"  {return w;}
"fmientras"  {return w_end;}
"leer" {return read;}
"escribir" {return write;}
"{" {return llaveI;}
"}" {return llaveD;}
"[" {return corcheteI;}
"]" {return corcheteD;}
{tipo} {return tipo_dato;}
"," {return coma;}
{espacio} {return salto;}
