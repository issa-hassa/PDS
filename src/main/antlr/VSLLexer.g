lexer grammar VSLLexer;

options {
  language = Java;
}

@header {
  package TP2;
}

WS : (' '|'\n'|'\t') -> skip
   ;

COMMENT : '//' (~'\n')* -> skip
        ;

fragment LETTER : 'a'..'z' ;
fragment DIGIT  : '0'..'9' ;
fragment ASCII  : ~('\n'|'"');

// keywords
LP    : '(' ; // Left parenthesis
RP    : ')' ;
LC : '{';
RC : '}';
LB : '[';
RB : ']';
VG : ',';
VAR : 'INT';
VOID : 'VOID';
RETURN : 'RETURN';
PLUS      : '+'      ;
SOUS : '-';
MULT : '*';
DIV : '/';
IF : 'IF';
ELSE : 'ELSE';
THEN : 'THEN';
FI : 'FI';
WHILE : 'WHILE';
DO : 'DO';
DONE : 'DONE';
AFFSYMBOL : ':=';
PROTO : 'PROTO';
FUNC : 'FUNC';
PRINT : 'PRINT';
READ : 'READ';


// other tokens (no conflict with keywords in VSL)
IDENT   : LETTER (LETTER|DIGIT)*;
TEXT    : '"' (ASCII)* '"' { setText(getText().substring(1, getText().length() - 1)); };
INTEGER : (DIGIT)+ ;
