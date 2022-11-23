package TP2.ASD.Expression;

import TP2.ASD.Type.*;
import TP2.Llvm;
import TP2.SymbolTable;

/**
 * Concrete class for Expression: constant (integer) case
 */
public class IntegerExpression extends Expression {
  int value;
  public IntegerExpression(int value) {
    this.value = value;
  }

  public String pp() {
    return "" + value;
  }

  public RetExpression toIR(SymbolTable tab) {
    // Here we simply return an empty IR
    // the `result' of this expression is the integer itself (as string)
    return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new Int(), "" + value);
  }
}