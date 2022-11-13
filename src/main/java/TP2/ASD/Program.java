package TP2.ASD;

import java.util.List;

import TP2.*;
import TP2.Llvm.IR;


public class Program {
    Expression e; // What a program contains. TODO : change when you extend the language
    List<TP2.ASD.Instruction> instructions;

    public Program( List<TP2.ASD.Instruction> instructions) {
      this.instructions = instructions;
    }

    /**
     * Pretty-printer
     */
    public String pp() {
    	String res = "";
    	for(Instruction i: instructions) {
    		res += i.pp();
    	}
      return res;
    }

    /**
     * IR generation
     */
    public Llvm.IR toIR() throws TypeException {
      // TODO : change when you extend the language

      // computes the IR of the expression
      SymbolTable table = new SymbolTable();
    
      Llvm.IR ir = new Llvm.IR(Llvm.empty(),Llvm.empty());
      for(Instruction i: instructions) {
  		ir.append(i.toIR(table));
  	}
      

      return ir;
    }
  }