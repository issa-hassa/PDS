package TP2.ASD.Instruction;

import TP2.ASD.Expression.Expression;
import TP2.ASD.Type.Type;
import TP2.ASD.Type.Void;
import TP2.Llvm.IR;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;
import TP2.Utils;

public class InstructionRet extends Instruction {
	Expression e;
	Type type;

	public InstructionRet(Expression e,Type type){

		this.type = type;
		this.e = e;
	}
	public InstructionRet(Type type){

		this.type = type;

	}
	@Override
	public String pp(int profondeur) {
		StringBuilder res = new StringBuilder(Utils.indent(profondeur)+"RETURN ");
		if(this.e != null){
			res.append(e.pp(0));
		}
		return res.toString();
	}
	@Override
	public RetExpression toIR(SymbolTable tab) throws TypeException {
		Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
		if(e != null){
			Expression.RetExpression irE = this.e.toIR(tab);
			if(!this.type.equals(irE.type)){
				throw new TypeException("Type miss match required: "+this.type.pp() + " found: "+ irE.type.pp() );
			}
			ir.append(irE.ir);
			ir.appendCode(new Llvm.Ret(irE.result));
		}
		else {
			if(!this.type.equals(new Void())){
				throw new TypeException("Type miss match required: "+this.type.pp() + " found: "+ " Void");
			}
			ir.appendCode(new Llvm.Ret());
		}


		return new RetExpression(ir,new Void(),"");
	}

}
