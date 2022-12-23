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



program
	returns[TP2.ASD.Program out]

	:

	i = listFunc EOF { $out = new TP2.ASD.Program($i.out);};

listFunc
	returns[ArrayList<TP2.ASD.Instruction.Instruction> out]:
	{$out = new ArrayList<>();}

	 (f = instructionfunction {$out.add($f.out);} )*;
instructionRet[TP2.ASD.Type.Type retType]
	returns[TP2.ASD.Instruction.Instruction  out]:
	RETURN e = expression {$out = new TP2.ASD.Instruction.InstructionRet($e.out,retType);}
	|
	RETURN {$out = new TP2.ASD.Instruction.InstructionRet(new TP2.ASD.Type.Void());};

instructions[TP2.ASD.Type.Type retType ]
	returns[TP2.ASD.Instruction.Instruction out]
	@init{
	 ArrayList<TP2.ASD.Expression.Expression> inst = new ArrayList<>();
	}
	:

    (d = declarations { inst.addAll($d.out);})*
    (i = instruction[retType] {inst.add($i.out);} |e=expression {inst.add($e.out);})+
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

    IDENT LB INTEGER RB {$out = new TP2.ASD.Declaration.DeclarationTab($IDENT.getText(), $INTEGER.int);}
    |
	IDENT { $out = new TP2.ASD.Declaration.DeclarationInt ($IDENT.getText()); };


instruction[TP2.ASD.Type.Type retType]
	returns[TP2.ASD.Instruction.Instruction out]:


	a = affectation { $out = $a.out; }
	| i = instructionif[retType] { $out = $i.out ;}
//	| f = instructionfunction { $out = $f.out ;}
	| w = instructionwhile[retType] { $out = $w.out; }
	| b = instructionBlock[retType] {$out = $b.out;  }
	| ret = instructionRet[retType] {$out = $ret.out;  }
	| PRINT p = instructionprint { $out = $p.out; }
	| READ r = instructionRead { $out = $r.out ;};

instructionRead
	returns[TP2.ASD.Instruction.Instruction out]:


	{ ArrayList<String> idents = new ArrayList<>(); } i = IDENT {idents.add($i.getText());} (
		VG i = IDENT {idents.add($i.getText());}
	)* { $out = new  TP2.ASD.Instruction.InstructionRead(idents) ;};
instructionprint
	returns[TP2.ASD.Instruction.Instruction out]:
	p = printItems {$out = new  TP2.ASD.Instruction.InstructionPrint($p.out) ;};

printItems
	returns[ArrayList <TP2 .ASD .Expression .Expression> out]
	@init{
        	 String globalString = "";
        	 String globalVar = TP2.Utils.newglob("@.fmt");
        	}
	:
	{$out = new ArrayList<>();}
	e = printItem {$out.add($e.out); }
	 (
		VG e = printItem {$out.add($e.out);}
	)*;

printItem
	returns[TP2.ASD.Expression.Expression out, String print]:
	t = stringConst {$out = $t.out; }
	| e = expression { $out = $e.out;};

stringConst
	returns[TP2.ASD.Expression.Expression out, String string]:
	t = TEXT { $out = new TP2.ASD.Expression.TextExpression($t.getText());};

instructionBlock[TP2.ASD.Type.Type retType]
	returns[TP2.ASD.Instruction.Instruction out]:

	LC i = instructions[retType] RC { $out = new TP2.ASD.Instruction.InstructionBlock($i.out);}
	;

instructionBlockUnique[TP2.ASD.Type.Type retType]
	returns[TP2.ASD.Instruction.Instruction out]:
	 i = instructions[retType]  { $out = new TP2.ASD.Instruction.InstructionBlock($i.out);}
	;



affectation
	returns[TP2.ASD.Instruction.Instruction out]:

	IDENT LB index = expression RB AFFSYMBOL e=expression
	 {$out = new TP2.ASD.Instruction.AffectationTabElement($IDENT.getText(),$index.out,$e.out);}

    |

	IDENT AFFSYMBOL e = expression
	{$out = new TP2.ASD.Instruction.AffectationInt($IDENT.getText(),$e.out);};



instructionif[TP2.ASD.Type.Type retType]
	returns[TP2.ASD.Instruction.Instruction out]:
	IF e = expression THEN i = instructionBlockUnique[retType] FI {$out = new TP2.ASD.Instruction.InstructionIf($e.out,$i.out);
		}
	| IF e = expression THEN i = instructionBlockUnique[retType] ELSE i2 = instructionBlockUnique[retType] FI {$out = new TP2.ASD.Instruction.InstructionIf($e.out,$i.out,$i2.out);
		};



instructionfunction
	returns[TP2.ASD.Instruction.Instruction out, ArrayList<String>readPrint]:

	FUNC t = type id = IDENT LP l = listArg RP b = instructionBlock[$t.out] {$out = new TP2.ASD.Instruction.InstructionFunc($id.getText(),$t.out,$l.out,$b.out);
		}
	|
	FUNC t = type id = IDENT LP l = listArg RP  i= instructionBlockUnique[$t.out] {$out = new TP2.ASD.Instruction.InstructionFunc($id.getText(),$t.out,$l.out,$i.out);
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

instructionwhile[TP2.ASD.Type.Type retType]
	returns[TP2.ASD.Instruction.Instruction out]:
	WHILE e = expression DO s = instructionBlockUnique[retType] DONE {$out = new TP2.ASD.Instruction.InstructionWhile($e.out,$s.out);
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
	| i = IDENT LP l = listeExpression RP {$out  = new TP2.ASD.Expression.AppelFun($i.getText(),$l.out);
		}
	| i = IDENT LB e = expression RB {$out  = new TP2.ASD.Expression.VarTableauExpression($i.getText(),$e.out);}
	| IDENT {$out = new TP2.ASD.Expression.VarIntExpression($IDENT.getText());}
	;


// TODO : that's all?

