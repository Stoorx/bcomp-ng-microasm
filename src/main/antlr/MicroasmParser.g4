parser grammar MicroasmParser;

options { tokenVocab = MicroasmLexer; }

microasmFile
    : BYTE_ORDER_MARK? (NewLineTrivia | NewLine)*? microasmStatementList? EOF
    ;

microasmStatementList
    : microasmStatementList (NewLineTrivia | NewLine) microasmStatement?
    | microasmStatement
    ;

microasmStatement
    : snippetStatement
    | macroStatememnt
    | labeledMcStatement
    ;

localLabel
    : DOT IdLiteral COLON
    ;

label
    : IdLiteral COLON
    ;

labeledMcStatement
    : label (NewLine | NewLineTrivia)? microcommandStatement?
    | localLabel (NewLine | NewLineTrivia)? microcommandStatement?
    | microcommandStatement
    ;

localLabeledMcStatement
    : localLabel (NewLine | NewLineTrivia)? microcommandStatement?
    | microcommandStatement
    ;

microcommandStatement
    : omcMicrocommand
    | cmcStatement
    | INVOKE IdLiteral
    ;

omcMicrocommand
    : DO omcOperandList
    ;

omcOperandList
    : omcOperandList COMMA omcOperand
    | omcOperand
    ;

omcOperand
    : valveLiteral
    | IdLiteral // For snippets
    ;

cmcOperandList
    : cmcOperandList COMMA cmcOperand
    | cmcOperand
    ;

cmcOperand
    : cmcValveLiteral
    | IdLiteral // For snippets
    ;

labelInvoke
    : DOT IdLiteral
    | IdLiteral
    ;

cmcStatement
    : IF cmcOperandList BIT Digit IS booleanLiteral GOTO labelInvoke
    | GOTO labelInvoke
    ;



snippetStatement
    : SNIPPET IdLiteral ASSIGN NewLine? omcOperandList
    ;

microcommandStatementList
    : microcommandStatementList (NewLine|NewLineTrivia) localLabeledMcStatement?
    | localLabeledMcStatement
    ;

macroStatememnt
    : MACRO IdLiteral (NewLine|NewLineTrivia)? BRACE_L (NewLine|NewLineTrivia)?
         microcommandStatementList? (NewLine | NewLineTrivia)?
      BRACE_R
    ;

valveLiteral
    : ValveWRAC
    | ValveRDAC
    | ValveWRBR
    | ValveRDBR
    | ValveWRPS
    | ValveRDPS
    | ValveRDIR
    | ValveWRCR
    | ValveRDCR
    | ValveWRIP
    | ValveRDIP
    | ValveWRSP
    | ValveRDSP
    | ValveWRAR
    | ValveRDAR
    | ValveWRDR
    | ValveRDDR
    | ValveSTOR
    | ValveLOAD
    | ValveCOML
    | ValveCOMR
    | ValveSORA
    | ValvePLS1
    | ValveSHLT
    | ValveSHL0
    | ValveSHRT
    | ValveSHRF
    | ValveLTOL
    | ValveHTOL
    | ValveLTOH
    | ValveHTOH
    | ValveSEXT
    | ValveSETC
    | ValveSETV
    | ValveSTNZ
    ;

cmcValveLiteral
    : ValveRDAC
    | ValveRDBR
    | ValveRDPS
    | ValveRDIR
    | ValveRDCR
    | ValveRDIP
    | ValveRDSP
    | ValveRDAR
    | ValveRDDR
    | ValveCOML
    | ValveCOMR
    | ValveSORA
    | ValvePLS1
    | ValveLTOL
    | ValveHTOL
    ;

booleanLiteral
    : Digit
    ;