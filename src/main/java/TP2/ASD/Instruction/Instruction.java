package TP2.ASD.Instruction;

import TP2.*;
import TP2.ASD.Expression.Expression;

/**
 * Abstract class representing the expressions
 */
public abstract class Instruction extends Expression {
    public abstract String pp(int profondeur);
    public abstract  Expression.RetExpression toIR(SymbolTable tab) throws TypeException;

  
  }