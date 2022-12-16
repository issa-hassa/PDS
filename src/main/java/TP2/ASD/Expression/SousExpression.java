package TP2.ASD.Expression;

import TP2.*;

/**
 * Concrete class for Expression: add case
 */
  public class SousExpression extends Expression {
    Expression left;
    Expression right;

    public SousExpression(Expression left, Expression right) {
      this.left = left;
      this.right = right;
    }

    /**
     * Pretty-printer
     */
    public String pp(int profondeur) {
      return "(" + left.pp(profondeur) + " - " + right.pp(profondeur) + ")";
    }

    /**
     * IR generation
     */
    public RetExpression toIR(SymbolTable table) throws TypeException {
      RetExpression leftRet = left.toIR(table);
      RetExpression rightRet = right.toIR(table);

      // We check if the types mismatches
      if(!leftRet.type.equals(rightRet.type)) {
        throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
      }

      // We base our build on the left generated IR:
      // append right code
      leftRet.ir.append(rightRet.ir);

      // allocate a new identifier for the result
      String result = Utils.newtmp();
      // new add instruction result = left + right
      Llvm.Instruction sous = new Llvm.Sous(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

      // append this instruction
      leftRet.ir.appendCode(sous);

      // return the generated IR, plus the type of this expression
      // and where to find its result
      return new RetExpression(leftRet.ir, leftRet.type, result);
    }
  }