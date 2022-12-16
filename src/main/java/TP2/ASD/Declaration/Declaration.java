package TP2.ASD.Declaration;


import TP2.*;
import TP2.ASD.Instruction.Instruction;


public abstract class Declaration extends Instruction {
	    public abstract String pp(int profondeur);
	    public abstract  RetExpression toIR(SymbolTable tab) throws TypeException;
 
}
