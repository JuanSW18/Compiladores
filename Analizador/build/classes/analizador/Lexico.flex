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
%type Tokens
letra = [a-zA-Z_]
digito = [0-9]
espacio = [\r\n]
tipo = entero | real

%{
public String lexema;
%}

%%
/*-------------------------------------------------------------*/


/*-------LOGICA - Reglas Lexicograficas-------*/
"=" {return ASSIGN;}
"==" {return EQUALS;}
"+" {return PLUS;}
"*" {return TIMES;}
"-" {return MINUS;}
"/" {return DIVIDE;}

{letra}({letra}|{digito})* {lexema=yytext(); return ID;}

