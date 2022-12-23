package TP2.ASD.Expression;



import java.util.List;

import TP2.*;
import TP2.ASD.Type.*;

public class VarIntExpression extends Expression {
	String varname;
	
	public VarIntExpression(String name){
		this.varname = name;
	}
	@Override
	public String pp(int profondeur) {
		
		return this.varname +" ";
	}

	@Override
	public RetExpression toIR(SymbolTable table) throws TypeException {
		List<Llvm.Instruction> code = Llvm.empty();
		String resultat ="";
		SymbolTable.Symbol var = table.lookup(varname);

		if(var == null) throw new RuntimeException("varible inconnue : " +varname);

		resultat = Utils.newtmp();

		if(var instanceof SymbolTable.PoinTeurSymbol){

			code.add(new Llvm.VarIntExpression(new Llvm.IntPointeur(),((SymbolTable.PoinTeurSymbol) var).getV().getIdent(),resultat));
		}
		else {
			code.add(new Llvm.VarIntExpression(new Llvm.Int(),varname,resultat));
		}
		Llvm.IR ir = new Llvm.IR(Llvm.empty(), code);
		return new RetExpression(ir,new Int(),resultat);
	}

}
