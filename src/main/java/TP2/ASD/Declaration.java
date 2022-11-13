package TP2.ASD;


import TP2.*;


public abstract class Declaration extends Instruction{
	    public abstract String pp();
	    public abstract  Llvm.IR toIR(SymbolTable tab) throws TypeException;
 
}
