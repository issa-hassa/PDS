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

	public InstructionRet(Expression e){
		this.e = e;
	}
	@Override
	public String pp(int profondeur) {
		
		return Utils.indent(profondeur)+ "RETURN  " +e.pp(0);
	}
	public void verifType(Type type){
		this.type = type;
	}
	@Override
	public RetExpression toIR(SymbolTable tab) throws TypeException {
		Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
		Expression.RetExpression irE = this.e.toIR(tab);
		if(!this.type.pp().equals(irE.type.pp())){
			throw new TypeException("Type miss match required: "+this.type.pp() + " found: "+ irE.type.pp() );
		}
		 ir.append(irE.ir);
		ir.appendCode(new Llvm.Ret(irE.result));
		return new RetExpression(ir,new Void(),"");
	}

}
