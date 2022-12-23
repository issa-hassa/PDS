package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;

import TP2.ASD.Type.Void;
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

    String funcArg;

    public AffectationInt(String ident, Expression value) {
      this.variableName = ident;
      this.variableValue = value;
    }
  public AffectationInt(String ident, String arg) {
    this.variableName = ident;
    this.funcArg = arg;
  }


    /**
     * Pretty-printer
     */
    public String pp(int profondeur) {
      if(variableValue == null) return "";
      return Utils.indent(profondeur)+ variableName + " := " + variableValue.pp(0) +"\n";
    }

    /**
     * IR generation
     */
    public Expression.RetExpression toIR(TP2.SymbolTable tab) throws TypeException {

      SymbolTable.Symbol var = tab.lookup(variableName);
      if(var == null) {throw new RuntimeException("unKnown variable : " + this.variableName );}
      if(var instanceof SymbolTable.FunctionSymbol){
        throw new RuntimeException(this.variableName+ " is a function" );
      }


      SymbolTable.Symbol sym = tab.lookup(variableName);
      if(sym instanceof SymbolTable.PoinTeurSymbol){
        variableName = ((SymbolTable.PoinTeurSymbol) sym).getV().getIdent();
      }
      Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
      if(this.variableValue == null){
        ir.appendCode(new Llvm.AffectInt(variableName, funcArg));
        return new RetExpression(ir,new Void(),"");
      }
      Expression.RetExpression irExp = variableValue.toIR(tab);

      if(!sym.getType().equals(irExp.type)){
        throw new RuntimeException("incompatible type : required " +sym.getType().pp() + " found :"+irExp.type.pp());
      }
      ir.append(irExp.ir);
      ir.appendCode(new Llvm.AffectInt(variableName, irExp.result));
      return new RetExpression(ir,variableValue.toIR(tab).type,"");
    }
  }