package TP2.ASD.Instruction;

import TP2.*;

/**
 * Abstract class representing the expressions
 */
public abstract class Instruction {
    public abstract String pp(int profondeur);
    public abstract  Llvm.IR toIR(SymbolTable tab) throws TypeException;

  
  }