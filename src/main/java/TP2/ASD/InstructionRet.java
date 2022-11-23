package TP2.ASD;

import TP2.Llvm.IR;
import TP2.Llvm.Ret;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;

public class InstructionRet extends Instruction {
	Expression e;
	public InstructionRet(Expression e){
		this.e = e;
	}
	@Override
	public String pp() {
		
		return "RETURN + " +e.pp();
	}

	@Override
	public IR toIR(SymbolTable tab) throws TypeException {
		Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
		Expression.RetExpression irE = this.e.toIR(tab);
		 ir.append(irE.ir);
		ir.appendCode(new Llvm.Ret(irE.result));
		return ir;
	}

}
