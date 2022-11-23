package TP2.ASD;

import TP2.Llvm;
import TP2.Llvm.Br;
import TP2.Llvm.IR;
import TP2.Llvm.Label;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;
import TP2.ASD.Expression.RetExpression;

public class InstructionWhile extends Instruction{
	Expression expression;
	Instruction instruction;
	int level;
	public InstructionWhile(Expression e, Instruction i ) {
		this.expression = e;
		this.instruction = i;
		//this.level = level;
	}
	@Override
	public String pp() {
		return "WHILE "+ expression.pp() + "\n" + "{ " + instruction.pp() + "\n" + "DONE"; 
		
	}

	@Override
	public IR toIR(SymbolTable tab) throws TypeException {
		Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
		RetExpression retIR = expression.toIR(tab);
		String branchDo = Utils.newlab("do");
		String branchFin = Utils.newlab("done");
		String branchCondition = Utils.newlab("while");
		ir.appendCode(new Llvm.Br(branchCondition));
		ir.appendCode(new Llvm.Label(branchCondition));
		ir.append(retIR.ir);
		ir.appendCode(new Llvm.instructionWhile(branchDo, branchFin, retIR.result));
		ir.appendCode(new Llvm.Label(branchDo));
		ir.append(instruction.toIR(tab));
		ir.appendCode(new Llvm.Br(branchCondition));
		ir.appendCode(new Llvm.Label(branchFin));
	
		
		
		
		
		return ir;
	}

}