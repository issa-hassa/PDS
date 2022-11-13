package TP2.ASD;

import TP2.*;

/**
 * Abstract class representing the expressions
 */
public abstract class Instruction {
    public abstract String pp();
    public abstract  Llvm.IR toIR(SymbolTable tab) throws TypeException;

  
  }