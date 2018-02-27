lexer grammar WACCLexer;

//binary operators
MULTIPLY: '*' ;
DIVIDE: '/' ;
MODULO: '%' ;
PLUS: '+' ;
MINUS: '-' ;
GREATER: '>' ;
GREATEREQ: '>=' ;
LESS: '<' ;
LESSEQ: '<=' ;
EQUALITY: '==' ;
NOTEQ: '!=' ;
AND: '&&' ;
OR: '||' ;

//unary operators
NOT: '!' ;
NEGATIVE: '-' ;
LENGTH: 'len' ;
ORDINAL: 'ord' ;
CHR: 'chr' ;

//special characters
LBRAC : '(' ;
RBRAC : ')' ;
LSQBRAC : '[' ;
RSQBRAC : ']' ;
COMMA : ',' ;
EQUAL : '=' ;
SEMICOLON : ';' ;
SINGLEQUOTE : '\'' ;
DOUBLEQUOTE : '"' ;
SLASH : '\\' ;

//whitespace
EOL : '\n' -> skip ;
WHITESPACE : ' ' -> skip ;
TAB : '\t' -> skip ;

//keywords
INT : 'int' ;
BOOL : 'bool' ;
CHAR : 'char' ;
STRING : 'string' ;
SKIP : 'skip' ;
READ : 'read' ;
FREE : 'free' ;
RETURN : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FI : 'fi' ;
WHILE : 'while' ;
DO : 'do' ;
DONE: 'done' ;
BEGIN: 'begin' ;
END: 'end' ;
CALL : 'call' ;
NEWPAIR: 'newpair' ;
FIRST: 'fst' ;
SECOND : 'snd' ;
IS : 'is' ;
NULL : 'null' ;
PAIR : 'pair' ;
TRUE : 'true' ;
FALSE : 'false' ;
FOR : 'for' ;
DOWHILE : 'do-while' ;
STRUCT : 'struct' ;

//characters
fragment CHARS: ~('\\' | '\'' | '"') | '\\'ESCCHAR ;

//integers
fragment DIGIT : '0'..'9' ;
INTEGER : DIGIT+ ;

//identifier pattern
IDENT : ( '_' | 'a'..'z' | 'A'..'Z' ) ( '_' | 'a'..'z' | 'A'..'Z' | '0'..'9' )* ;

//esc characters
ESCCHAR: '0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\' ;

//char lit
CHARLIT: SINGLEQUOTE CHARS SINGLEQUOTE ;

//str lit
STRLIT: DOUBLEQUOTE CHARS* DOUBLEQUOTE ;

//comment
COMMENT: ('#' (~[\n])* '\n') -> skip ;

//dot
DOT: '.' ;
