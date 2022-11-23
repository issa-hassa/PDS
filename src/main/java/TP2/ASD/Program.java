package TP2.ASD;

import TP2.*;
import TP2.ASD.Expression.Expression;
import TP2.ASD.Instruction.InstructionFunc;


public class Program {
    Expression e; // What a program contains. TODO : change when you extend the language
    InstructionFunc f;;

    public Program( InstructionFunc f) {
      this.f = f;
    }

    /**
     * Pretty-printer
     */
    public String pp() {
    	
      return f.pp();
    }

    /**
     * IR generation
     */
    public Llvm.IR toIR() throws TypeException {
      // TODO : change when you extend the language

      // computes the IR of the expression
      SymbolTable table = new SymbolTable();
      
      Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
    //  for(Instruction i: instructions) {
  	//	ir.append(i.toIR(table));
  	//}
     // System.out.println(f== null );
     ir.append(f.toIR(table));

      return ir;
    }
  }