package TP2.ASD.Expression;

import TP2.ASD.Type.Type;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;

/**
 * Abstract class representing the expressions
 */
public abstract class Expression {
    public abstract String pp(int profondeur);
    public abstract Expression.RetExpression toIR(SymbolTable table) throws TypeException;

    /**
     * Object returned by toIR on expressions, with IR + synthesized attributes
     */
    static public class RetExpression {
      /**
       * The LLVM IR:
       */
      public Llvm.IR ir;

      // And additional stuff:

      /**
       * The type of the expression
       */
      public Type type;
      /**
       * The name containing the expression's result
       * (either an identifier, or an immediate value)
       */
      public String result; // 

      /**
       * Construct the object returned by toIR() on expressions.
       * @param ir the IR corresponding to the expression
       * @param type the type of the expression
       * @param result the name containing the expressions's result (either an identifier, or an immediate value)
       */
      public RetExpression(Llvm.IR ir, Type type, String result) {
        this.ir = ir;
        this.type = type;
        this.result = result;
      }
    }
  }