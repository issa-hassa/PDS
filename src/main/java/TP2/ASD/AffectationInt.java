package TP2.ASD;

import com.ibm.icu.text.SymbolTable;

import TP2.Llvm;
import TP2.Llvm.IR;
import TP2.TypeException;
import TP2.Utils;
import TP2.ASD.Expression.RetExpression;

/**
 * Concrete class for Expression: add case
 */
  public class AffectationInt extends Instruction {
    String variableName;
    Expression variableValue;

    public AffectationInt(String ident, Expression value) {
      this.variableName = ident;
      this.variableValue = value;
    }

    /**
     * Pretty-printer
     */
    public String pp() {
      return   variableName + " := " + variableValue.pp() ;
    }

    /**
     * IR generation
     */
    public Llvm.IR toIR(TP2.SymbolTable tab) throws TypeException {
      Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
      Expression.RetExpression irExp = variableValue.toIR(tab);
      ir.append(irExp.ir);
      ir.appendCode(new Llvm.AffectInt(variableName, irExp.result));
      return ir;
    }
  }