package analizador;

import java_cup.runtime.Symbol;
import java.io.FileReader;

%%

%class Lexico
%cup
%line
%column


%{
StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}


letra = [a-zA-Z_]
digito = [0-9]
espacio = [\n]

%%

"entero" {return symbol(sym.tipo_dato);}
"si" {return symbol(sym.SI);}
"fsi" {return symbol(sym.ENDSI);}
"mientras"  {return symbol(sym.WHILE);}
"fmientras"  {return symbol(sym.ENDWHILE);}
"leer" {return symbol(sym.read);}
"escribir" {return symbol(sym.write);}
{letra}({letra}|{digito})* {return symbol(sym.ID);}
{espacio} {return symbol(sym.salto);}
{digito}{digito}* {return symbol(sym.Num);}
"(" {return symbol(sym.LPARENT);}
")" {return symbol(sym.RPARENT);}
"!=" {return symbol(sym.DIF);}
"==" {return symbol(sym.EQUALS);}
">="  {return symbol(sym.MAYOR_IGUAL);}
"<="  {return symbol(sym.MENOR_IGUAL);}
">"   {return symbol(sym.MAYOR);}
"<"   {return symbol(sym.MENOR);}
"=" {return symbol(sym.ASSIGN);}
"+" {return symbol(sym.PLUS);}
"*" {return symbol(sym.TIMES);}
"-" {return symbol(sym.MINUS);}
"/" {return symbol(sym.DIVIDE);}
"%" {return symbol(sym.MOD);}
"{" {return symbol(sym.llaveI);}
"}" {return symbol(sym.llaveD);}
"[" {return symbol(sym.corcheteI);}
"]" {return symbol(sym.corcheteD);}
"," {return symbol(sym.coma);}