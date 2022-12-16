package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;

import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;

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
    public String pp(int profondeur) {
      return Utils.indent(profondeur)+ variableName + " := " + variableValue.pp(0) +"\n";
    }

    /**
     * IR generation
     */
    public Expression.RetExpression toIR(TP2.SymbolTable tab) throws TypeException {
      if(tab.lookup(variableName) == null) {throw new RuntimeException("La variable; " + this.variableName + " n'est pas déclarée");}
      SymbolTable.Symbol sym = tab.lookup(variableName);
      if(sym instanceof SymbolTable.PoinTeurSymbol){
        variableName = ((SymbolTable.PoinTeurSymbol) sym).getV().getIdent();
      }
      Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
      Expression.RetExpression irExp = variableValue.toIR(tab);
      ir.append(irExp.ir);
      ir.appendCode(new Llvm.AffectInt(variableName, irExp.result));
      return new RetExpression(ir,variableValue.toIR(tab).type,"");
    }
  }