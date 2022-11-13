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
    : i = listInstructions    EOF { $out = new TP2.ASD.Program($i.out); } // TODO : change when you extend the language
    ;


listInstructions returns [List<TP2.ASD.Instruction> out] 
	:{$out = new ArrayList<>();} (d=declarations { $out.addAll($d.out);})?  i=instructions { $out.addAll($i.out);}
	;

instructions returns [List<TP2.ASD.Instruction> out]
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
	//|i = if { $out = $i.out ;}
	//|w = while { $out = $w.out; }
	//|r = read { $out = $r.out; }
	//|PRINT p = print { $out = $p.out ;}
	//|f = function    { $out = $f.out ;}
	;

									



affectation returns [TP2.ASD.Instruction out] 
	: IDENT AFFSYMBOL e=expression {$out = new TP2.ASD.AffectationInt($IDENT.getText(),$e.out);};


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
    
