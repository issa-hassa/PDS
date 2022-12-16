package TP2.ASD;

import TP2.*;
import TP2.ASD.Expression.Expression;
import TP2.ASD.Instruction.Instruction;
import TP2.ASD.Instruction.InstructionFunc;

import java.util.ArrayList;


public class Program {
  //  Expression e; // What a program contains. TODO : change when you extend the language
    ArrayList<Instruction> list;;

    public Program(ArrayList<Instruction> list) {
        this.list = list;
    }

    /**
     * Pretty-printer
     */
    public String pp() {
    	String res ="";
        for (Instruction i : list) {
            res +=i.pp(0);
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
    //  for(Instruction i: instructions) {
  	//	ir.append(i.toIR(table));
  	//}
     // System.out.println(f== null );
        for (Instruction i : list) {

            ir.append(i.toIR(table).ir);
        }



      return ir;
    }
  }