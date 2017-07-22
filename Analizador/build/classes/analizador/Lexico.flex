package analizador;

import java_cup.runtime.Symbol;
import java.io.FileReader;

%%

%class Lexico
%public
%line
%char
%cup
%column

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    
    private Symbol symbol(int type, int yyline, int yycolumn, String valor) {
        return new Symbol(type, yyline, yycolumn, valor);
    }
%}


letra = [a-zA-Z_]
digito = [0-9]
WHITE = [ \t|\r|\n]
cadena = \"[^\"]*\"
%%

{WHITE}  {}

"INICIO" {return symbol(sym.INICIO);}
"FIN" {return symbol(sym.FIN);}
"entero" {return symbol(sym.tipo_dato);}
"si" {return symbol(sym.SI);}
"fsi" {return symbol(sym.s_end);}
"mientras"  {return symbol(sym.w);}
"fmientras"  {return symbol(sym.w_end);}
"leer" {return symbol(sym.read);}
"escribir" {return symbol(sym.write);}
//{cadena} {return symbol(sym.CADENA);}
{letra}({letra}|{digito})* {return symbol(sym.ID, yyline, yycolumn, yytext());}
{digito}{digito}* {return symbol(sym.Num, yyline, yycolumn, yytext());}
//[:digit:] {return symbol(sym.Num);}
{cadena} {return symbol(sym.cadena);}
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
