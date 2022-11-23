package TP2.ASD;



import java.util.List;

import TP2.*;

public class VarIntExpression extends Expression {
	String varname;
	
	public VarIntExpression(String name){
		this.varname = name;
	}
	@Override
	public String pp() {
		
		return this.varname +" ";
	}

	@Override
	public RetExpression toIR(SymbolTable table) throws TypeException {
		List<Llvm.Instruction> code = Llvm.empty();
		String resultat ="";
		if(table.lookup(varname) == null) throw new RuntimeException("varible inconnue : " +varname);
        else{
        	resultat = Utils.newtmp();
        }
		code.add(new Llvm.VarIntExpression(varname,resultat));
		Llvm.IR ir = new Llvm.IR(Llvm.empty(), code);
		return new RetExpression(ir,new Int(),resultat);
	}

}
