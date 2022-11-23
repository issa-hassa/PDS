package TP2.ASD.Declaration;

import TP2.*;
import TP2.Llvm.IR;
import TP2.ASD.Type.*;


public class DeclarationInt extends Declaration{
	String name;
	public DeclarationInt(String name) {
		this.name = name;
	}
	@Override
	public String pp() {
		
		return "INT" + name + "\n";
	}



	@Override
	public IR toIR(SymbolTable tab) throws TypeException {
		
		  Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());

	        SymbolTable.VariableSymbol vSymbol = new SymbolTable.VariableSymbol(new Int(), name);
	        if(!tab.add(vSymbol)){
	            throw new RuntimeException(name+" est déjà présent dans la table de symbole.");
	        }
	        ir.appendCode(new Llvm.DeclarationInt(name));

	        return ir;	
	        }



	
	

}
