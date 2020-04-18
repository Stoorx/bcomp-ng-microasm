lexer grammar MicroasmLexer;

BYTE_ORDER_MARK: '\u00EF\u00BB\u00BF';

ASSIGN: '=';
ASTERISK: '*';
BRACE_L: '{';
BRACE_R: '}';
DOT: '.';
COLON: ':';
COMMA: ',';
SLASH: '/';

NewLine: ('\r'? '\n');
NewLineTrivia: NewLine+;

// Comments
LineComment: SLASH SLASH ~('\r' | '\n')* -> channel(HIDDEN);
BlockComment: BlockCommentBegin (BlockComment | .)*? BlockCommentEnd -> channel(HIDDEN);
BlockCommentBegin: SLASH ASTERISK;
BlockCommentEnd: ASTERISK SLASH;

WhiteSpace: [ \t]+ -> skip;

// Directives
DO: (D O);
IF: (I F);
BIT: (B I T);
IS: (I S);
GOTO: (G O T O);
MACRO: (M A C R O);
SNIPPET: (S N I P P E T);
INVOKE: (I N V O K E);
TRUE: (T R U E);
FALSE: (F A L S E);

// Valves
// AC
ValveWRAC: (W R A C);
ValveRDAC: (R D A C);
// BR
ValveWRBR: (W R B R);
ValveRDBR: (R D B R);
// PS
ValveWRPS: (W R P S);
ValveRDPS: (R D P S);
// IR
ValveRDIR: (R D I R);


// CR
ValveWRCR: (W R C R);
ValveRDCR: (R D C R);
// IP
ValveWRIP: (W R I P);
ValveRDIP: (R D I P);
// SP
ValveWRSP: (W R S P);
ValveRDSP: (R D S P);
// AR
ValveWRAR: (W R A R);
ValveRDAR: (R D A R);
// DR
ValveWRDR: (W R D R);
ValveRDDR: (R D D R);

// MEM
ValveSTOR: (S T O R);
ValveLOAD: (L O A D);

// ALU
ValveCOML: (C O M L);
ValveCOMR: (C O M R);
ValveSORA: (S O R A);
ValvePLS1: (P L S '1');

// Commutator
ValveSHLT: (S H L T);
ValveSHL0: (S H L '0');
ValveSHRT: (S H R T);
ValveSHRF: (S H R F);
ValveLTOL: (L T O L);
ValveHTOH: (H T O H);
ValveHTOL: (H T O L);
ValveLTOH: (L T O H);
ValveSEXT: (S E X T);

// Flags checker
ValveSETC: (S E T C);
ValveSETV: (S E T V);
ValveSTNZ: (S T N Z);

IdLiteral: [_a-zA-Z][_a-zA-Z0-9]*;
Digit: [0-9];

// Fragments
fragment A : ('a' | 'A');
fragment B : ('b' | 'B');
fragment C : ('c' | 'C');
fragment D : ('d' | 'D');
fragment E : ('e' | 'E');
fragment F : ('f' | 'F');
fragment G : ('g' | 'G');
fragment H : ('h' | 'H');
fragment I : ('i' | 'I');
fragment J : ('j' | 'J');
fragment K : ('k' | 'K');
fragment L : ('l' | 'L');
fragment M : ('m' | 'M');
fragment N : ('n' | 'N');
fragment O : ('o' | 'O');
fragment P : ('p' | 'P');
fragment Q : ('q' | 'Q');
fragment R : ('r' | 'R');
fragment S : ('s' | 'S');
fragment T : ('t' | 'T');
fragment U : ('u' | 'U');
fragment V : ('v' | 'V');
fragment W : ('w' | 'W');
fragment X : ('x' | 'X');
fragment Y : ('y' | 'Y');
fragment Z : ('z' | 'Z');