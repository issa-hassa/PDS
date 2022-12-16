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
	public String pp(int profondeur) {
		
		return "INT " + name + "\n";
	}



	@Override
	public RetExpression toIR(SymbolTable tab) throws TypeException {
		
		  Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());

	        SymbolTable.VariableSymbol vSymbol = new SymbolTable.VariableSymbol(new Int(), name);
	        if(tab.lookInTable(vSymbol)){
	            throw new RuntimeException(name+" est déjà présent dans la table de symbole.");
	        }
			SymbolTable.Symbol s = tab.lookup(name);

			if((s != null)){
				 if(s instanceof SymbolTable.VariableSymbol){
					 String newName = Utils.newglob(name);
					SymbolTable.Symbol pointer = new SymbolTable.PoinTeurSymbol(
							new SymbolTable.VariableSymbol(new Int(),newName),
							name);
					tab.add(pointer);
					ir.appendCode(new Llvm.DeclarationInt(newName));
				} else if (s instanceof SymbolTable.PoinTeurSymbol) {
					 String newName = Utils.newglob(((SymbolTable.PoinTeurSymbol)s).getV().getIdent());
					 SymbolTable.Symbol pointer = new SymbolTable.PoinTeurSymbol(
							 new SymbolTable.VariableSymbol(new Int(),newName),
							 name);
					 tab.add(pointer);
					 ir.appendCode(new Llvm.DeclarationInt(newName));

				 }
			}

			else {
				tab.add(vSymbol);
				ir.appendCode(new Llvm.DeclarationInt(name));
			}


	        return new RetExpression(ir,new Int(),"");
	        }



	
	

}
