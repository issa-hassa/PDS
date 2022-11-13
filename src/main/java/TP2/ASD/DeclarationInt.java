package TP2.ASD;

import TP2.*;
import TP2.Llvm.IR;


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
	            throw new RuntimeException(name+" already is the Symbol Tab.");
	        }
	        ir.appendCode(new Llvm.DeclarationInt(name));

	        return ir;	
	        }



	
	

}
