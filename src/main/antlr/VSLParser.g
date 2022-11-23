parser grammar VSLParser;

options {
  language = Java;
  tokenVocab = VSLLexer;
}

@header {
  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;
}


// TODO : other rules

program returns [TP2.ASD.Program out]
    : i = instructionfunction    EOF { $out = new TP2.ASD.Program($i.out); } // TODO : change when you extend the language
    ;


listInstructions returns [List<TP2.ASD.Instruction> out] 
	:{$out = new ArrayList<>();} (d=declarations { $out.addAll($d.out);})?  i=instructions { $out.addAll($i.out);}
	;
instructionRet returns [TP2.ASD.Instruction  out] :
	RETURN e = expression {$out = new TP2.ASD.InstructionRet($e.out);};
	

instructions returns [ArrayList<TP2.ASD.Instruction> out]
	:{$out = new ArrayList<>();} i=instruction {$out.add($i.out) ;} (i=instruction  {$out.add($i.out) ;})*
	;

	
declarations returns [List<TP2.ASD.Declaration> out]:
	{$out = new ArrayList<>(); } (VAR d=declaration {$out.add($d.out);} (VG  d=declaration {$out.add($d.out);})*);
	

	
declaration returns [ TP2.ASD.Declaration out]
	:IDENT { $out = new TP2.ASD.DeclarationInt ($IDENT.getText()); }
	|IDENT LB INTEGER RB {$out = new TP2.ASD.DeclarationTab($IDENT.getText(), $INTEGER.int);}
	;
		

instruction returns[TP2.ASD.Instruction out] :
	a = affectation { $out = $a.out; }
	|i = instructionif { $out = $i.out ;}
	|f = instructionfunction    { $out = $f.out ;}
	|w = instructionwhile { $out = $w.out; }
	//|b = blockInstruction {$out = $b.out;  }
	//|r = instructionread { $out = $r.out; }
	//|PRINT p = instructionprint { $out = $p.out ;}

	;


									

//instructionprint [ArrayList<TP2.ASD.Expression>expr, ArrayList<String> texts] returns [TP2.ASD.Instruction out] :
//	(TEXT {$texts.add(TEXT.text());} | e = expression { $expr.add($e.out);})* {$out = new TP2.ASD.InstructionPrint($expr, texts);};
	

affectation returns [TP2.ASD.Instruction out] 
	: IDENT AFFSYMBOL e=expression {$out = new TP2.ASD.AffectationInt($IDENT.getText(),$e.out);};

instructionif  returns [TP2.ASD.Instruction out]
	:IF e = expression THEN i = instructions FI {$out = new TP2.ASD.InstructionIf($e.out,$i.out); } 
	
	|IF e = expression THEN i = instructions   ELSE i2 = instructions FI  {$out = new TP2.ASD.InstructionIf($e.out,$i.out,$i2.out); } 
;


instructionfunction returns [TP2.ASD.InstructionFunc out]: FUNC t=type id=IDENT LP l = listArg* RP  LC i = corps RC {$out = new TP2.ASD.InstructionFunc($id.getText(),$t.out,$l.out,$i.out);} ;


corps  returns [ArrayList<TP2.ASD.Instruction> out] :
	{$out = new ArrayList<TP2.ASD.Instruction>();} i = instructions iret = instructionRet {$out.addAll($i.out); $out.add($iret.out);};

listArg returns [ArrayList<String> out] :{$out = new ArrayList<String>();} IDENT {$out.add($IDENT.getText());} (VG IDENT  {$out.add($IDENT.getText());}  )* ;

type  returns [TP2.ASD.Type out]:
	VAR {$out = new TP2.ASD.Int();} 
	|VOID {$out = new TP2.ASD.Void();}
	;



instructionwhile returns [TP2.ASD.Instruction out] :
	 WHILE e = expression DO LC s = instruction RC DONE {$out = new TP2.ASD.InstructionWhile($e.out,$s.out);};
	 
	  
expression returns [TP2.ASD.Expression out]
    :   r=expression PLUS l=factor  { $out = new TP2.ASD.AddExpression($l.out, $r.out); } 
    
    | r=expression SOUS l=factor     { $out = new TP2.ASD.SousExpression($r.out, $l.out); }
    
   
    |  f=factor {$out =$f.out; }
    
    ;

factor returns [TP2.ASD.Expression out]
    : p=primary { $out = $p.out; }
    | l=primary MULT r = primary { $out = new TP2.ASD.MultExpression($l.out, $r.out); }
    | r = primary DIV l=primary   { $out =new  TP2.ASD.DivExpression($r.out, $l.out); }
    // TODO : that's all?
    ;

primary returns [TP2.ASD.Expression out]
    : INTEGER { $out = new TP2.ASD.IntegerExpression($INTEGER.int); }
    | LP e=expression RP { $out = $e.out ;}
    |IDENT {$out = new TP2.ASD.VarIntExpression($IDENT.getText());}
    ;
    // TODO : that's all?
    
