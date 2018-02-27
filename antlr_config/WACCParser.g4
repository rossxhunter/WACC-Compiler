parser grammar WACCParser;

options {
  tokenVocab=WACCLexer;
}

program: begin structDec* func* stat end EOF;

func : type ident LBRAC paramList? RBRAC IS statFunc* (ret | exit) end ;

paramList : param ( COMMA param )* ;

param : type ident ;

assign : assignLHS EQUAL assignRHS ;

declare : type ident EQUAL assignRHS ;

ret : RETURN expr ;

free : FREE expr ;

print : PRINT expr ;

println : PRINTLN expr ;

read : READ assignLHS ;

begin : BEGIN ;

end : END ;

exit : EXIT expr;

ifStat : IF expr THEN stat ELSE stat FI ;

whileStat : WHILE expr DO stat DONE ;

doWhileStat : DOWHILE expr DO stat DONE ;

comparison : ident compareOper expr ;

forStat : FOR LBRAC declare SEMICOLON expr SEMICOLON assign RBRAC DO stat DONE ;

fieldList : param (SEMICOLON param)* ;

structDec : STRUCT ident fieldList end ;

block : begin stat end ;

statFunc : SKIP
    | declare
    | assign
    | read
    | free
    | print
    | println
    | ifStat
    | whileStat
    | forStat
    | doWhileStat
    | structDec
    | block
    | stat SEMICOLON stat
    | statFunc SEMICOLON
    ;

stat : SKIP
    | declare
    | assign
    | read
    | free
    | ret
    | exit
    | print
    | println
    | ifStat
    | whileStat
    | forStat
    | doWhileStat
    | structDec
    | block
    | stat SEMICOLON stat
    ;

structField : ident DOT ident ;

assignLHS : ident | arrayElem | pairElem | structField ;

assignRHS : expr | arrayLit | newPair | pairElem
    | call | structField ;

newPair : NEWPAIR LBRAC expr COMMA expr RBRAC ;

call : CALL ident LBRAC (argList)? RBRAC ;

argList : expr (COMMA expr)* ;

pairElem : FIRST expr | SECOND expr ;

type : baseType | type LSQBRAC RSQBRAC | pairType ;

baseType : baseT=(INT | BOOL | CHAR | STRING) ;

arrayType : type LSQBRAC RSQBRAC ;

pairType : PAIR LBRAC pairElemType COMMA pairElemType RBRAC ;

pairElemType : baseType | arrayType | PAIR ;

expr : intLit
    | boolLit
    | charLit
    | strLit
    | pairLit
    | ident
    | arrayElem
    | unary
    | expr binaryOp1 expr
    | expr binaryOp2 expr
    | expr compareOper expr
    | expr boolOper expr
    | LBRAC expr RBRAC
    ;

unary : unaryOper expr ;

ord : ORDINAL ;

unaryOper : NOT | MINUS | LENGTH | ord | CHR ;

boolOper : OR | AND ;

compareOper : GREATER | GREATEREQ | LESS | LESSEQ | EQUALITY | NOTEQ ;

binaryOp1 : MULTIPLY | DIVIDE | MODULO ;

binaryOp2 : MINUS | PLUS ;

ident: IDENT ;

arrayElem : ident (LSQBRAC expr RSQBRAC)+ ;

intLit : intSign? INTEGER ;

intSign : PLUS | MINUS ;

boolLit : TRUE | FALSE ;

charLit : CHARLIT ;

strLit : STRLIT ;

arrayLit : LSQBRAC ( expr (COMMA expr)* )? RSQBRAC ;

pairLit: NULL ;
