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

program
	returns[TP2.ASD.Program out]:
	i = listFunc EOF { $out = new TP2.ASD.Program($i.out); };
// TODO : change when you extend the language

// listFuncProtoreturns[ArrayList<TP2.ASD.Instruction.Instruction> out]: {$out = new ArrayList<>();}
// ( p = listProto {$out.addAll($p.out);}

// )? (f = listFunc {$out.addAll($f.out);})?;

listFunc
	returns[ArrayList<TP2.ASD.Instruction.Instruction> out]:
	{$out = new ArrayList<>();}
	 (f = instructionfunction {$out.add($f.out);} )*;
instructionRet
	returns[TP2.ASD.Instruction.Instruction  out]:
	RETURN e = expression {$out = new TP2.ASD.Instruction.InstructionRet($e.out);};

instructions
	returns[TP2.ASD.Instruction.Instruction out]
	@init{
	 ArrayList<TP2.ASD.Expression.Expression> inst = new ArrayList<>();
	}
	:
    (d = declarations { inst.addAll($d.out);})?
    (i = instruction {inst.add($i.out);} |e=expression {inst.add($e.out);})+
    {$out = new TP2.ASD.Instruction.InstructionList(inst);}
    ;

declarations
	returns[List<TP2.ASD.Declaration.Declaration> out]:
	{$out = new ArrayList<>(); } (
		VAR d = declaration {$out.add($d.out);} (
			VG d = declaration {$out.add($d.out);}
		)*
	);

declaration
	returns[ TP2.ASD.Declaration.Declaration out]:
	IDENT { $out = new TP2.ASD.Declaration.DeclarationInt ($IDENT.getText()); }
	| IDENT LB INTEGER RB {$out = new TP2.ASD.Declaration.DeclarationTab($IDENT.getText(), $INTEGER.int);
		};

instruction
	returns[TP2.ASD.Instruction.Instruction out]:
	a = affectation { $out = $a.out; }
	| i = instructionif { $out = $i.out ;}
	| f = instructionfunction { $out = $f.out ;}
	| w = instructionwhile { $out = $w.out; }
	| b = instructionBlock {$out = $b.out;  }
	| ret = instructionRet {$out = $ret.out;  }
	| PRINT p = instructionprint { $out = $p.out ;}
	| READ r = instructionRead { $out = $r.out ;};

instructionRead
	returns[TP2.ASD.Instruction.Instruction out]:
	{ ArrayList<String> idents = new ArrayList<>(); } (
		i = IDENT {idents.add($i.getText());}
	)+ { $out = new  TP2.ASD.Instruction.InstructionRead(idents) ; };
//essai brachne
instructionprint
	returns[TP2.ASD.Instruction.Instruction out]:
	printItems {$out = new  TP2.ASD.Instruction.InstructionPrint($printItems.out) ;};

printItems
	returns[ArrayList <TP2 .ASD .Expression .Expression> out]:
	{$out = new ArrayList<>();} e = printItem {$out.add($e.out); } (
		VG e = printItem {$out.add($e.out);}
	)*;
printItem
	returns[TP2.ASD.Expression.Expression out]:
	t = stringConst {$out = $t.out;}
	| e = expression { $out = $e.out;};

stringConst
	returns[TP2.ASD.Expression.Expression out]:
	TEXT { $out = new TP2.ASD.Expression.TextExpression($TEXT.getText()); };

instructionBlock
	returns[TP2.ASD.Instruction.Instruction out]:
	LC i = instructions RC { $out = new TP2.ASD.Instruction.InstructionBlock($i.out);}
	;

instructionBlockIF
	returns[TP2.ASD.Instruction.Instruction out]:
	 i = instructions  { $out = new TP2.ASD.Instruction.InstructionBlock($i.out);}
	;



affectation
	returns[TP2.ASD.Instruction.Instruction out]:
	IDENT AFFSYMBOL e = expression {$out = new TP2.ASD.Instruction.AffectationInt($IDENT.getText(),$e.out);
		};

instructionif
	returns[TP2.ASD.Instruction.Instruction out]:
	IF e = expression THEN i = instructionBlockIF FI {$out = new TP2.ASD.Instruction.InstructionIf($e.out,$i.out);
		}
	| IF e = expression THEN i = instructionBlockIF ELSE i2 = instructionBlockIF FI {$out = new TP2.ASD.Instruction.InstructionIf($e.out,$i.out,$i2.out);
		};


//instructionif
//	returns[TP2.ASD.Instruction.Instruction out]:
//	IF e = expression THEN i = instructions FI {$out = new TP2.ASD.Instruction.InstructionIf($e.out,$i.out);}
//	| IF e = expression THEN i = instructions ELSE i2 = instructions FI {$out = new TP2.ASD.Instruction.InstructionIf($e.out,$i.out,$i2.out);
//		};

instructionfunction
	returns[TP2.ASD.Instruction.Instruction out]:
	FUNC t = type id = IDENT LP l = listArg RP b = instructionBlock {$out = new TP2.ASD.Instruction.InstructionFunc($id.getText(),$t.out,$l.out,$b.out);
		}
	|
	FUNC t = type id = IDENT LP l = listArg RP  i= instruction {$out = new TP2.ASD.Instruction.InstructionFunc($id.getText(),$t.out,$l.out,$i.out);
    		}
	| PROTO t = type id = IDENT LP l = listArg RP {$out = new TP2.ASD.Instruction.InstructionProto($id.getText(),$t.out,$l.out);
		};


listArg
	returns[ArrayList<String> out]:
	{$out = new ArrayList<String>();} (
		IDENT {$out.add($IDENT.getText());} (
			VG IDENT {$out.add($IDENT.getText());}
		)*
	)?;

type
	returns[TP2.ASD.Type.Type out]:
	VAR {$out = new TP2.ASD.Type.Int();}
	| VOID {$out = new TP2.ASD.Type.Void();};

instructionwhile
	returns[TP2.ASD.Instruction.Instruction out]:
	WHILE e = expression DO s = instructionBlock DONE {$out = new TP2.ASD.Instruction.InstructionWhile($e.out,$s.out);
		};

listeExpression
	returns[ArrayList<TP2.ASD.Expression.Expression> out]:
	{$out = new ArrayList<>();} (
		e = expression { $out.add($e.out); } (
			VG e = expression { $out.add($e.out); }
		)*
	)*;

expression
	returns[TP2.ASD.Expression.Expression out]:
	r = factor  PLUS l = expression { $out = new TP2.ASD.Expression.AddExpression($l.out, $r.out);
			}
	| r = factor  SOUS l  = expression  { $out = new TP2.ASD.Expression.SousExpression($r.out, $l.out);
		}
	| f = factor {$out =$f.out; };

factor
	returns[TP2.ASD.Expression.Expression out]:
	p = primary { $out = $p.out; }
	| l = primary MULT r = primary { $out = new TP2.ASD.Expression.MultExpression($l.out, $r.out); 
			}
	| r = primary DIV l = primary { $out =new  TP2.ASD.Expression.DivExpression($r.out, $l.out); 
			};
// TODO : that's all?

primary
	returns[TP2.ASD.Expression.Expression out]:
	INTEGER { $out = new TP2.ASD.Expression.IntegerExpression($INTEGER.int); }
	| LP e = expression RP { $out = $e.out ;}
	| IDENT {$out = new TP2.ASD.Expression.VarIntExpression($IDENT.getText());}
	| i = IDENT LP l = listeExpression RP {$out  = new TP2.ASD.Expression.AppelFun($i.getText(),$l.out);
		};

// TODO : that's all?

