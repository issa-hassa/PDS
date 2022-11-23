package TP2.ASD.Instruction;

import java.util.ArrayList;

import TP2.ASD.Declaration.DeclarationInt;
import TP2.ASD.Type.Int;
import TP2.ASD.Type.Type;
import TP2.Llvm.IR;
import TP2.Llvm;
import TP2.SymbolTable;
import TP2.SymbolTable.VariableSymbol;
import TP2.TypeException;

public class InstructionFunc extends Instruction {
	String nom;
	Type type;
	ArrayList<String> args;
	ArrayList<Instruction> instructions;
	
	public InstructionFunc(String nom, Type type, ArrayList<String> args, ArrayList<Instruction> instructions){
		this.nom = nom;
		this.args = args;
		this.type = type;
		this.instructions = instructions;	
	}
	
	@Override
	public String pp(int profondeur) {
		String res = "Func " + this.type.pp() + " " + nom +"(";
		for (int i = 0; i < args.size(); i++) {
		    String s = args.get(i);
			if(i < args.size() - 1) s +=",";
			res +=s;
		}
		res += ")\n{\n";
		for (Instruction i : this.instructions){
			res +=i.pp(profondeur+1);
		}
		res +="\n}\n";
		return res;
	}

	@Override
	public IR toIR(SymbolTable tab) throws TypeException {
		Llvm.IR irInstructions = new Llvm.IR(Llvm.empty(),Llvm.empty());
		Llvm.IR irRes = new Llvm.IR(Llvm.empty(),Llvm.empty());
		
		ArrayList<VariableSymbol> argsS = new ArrayList<>();
		for(String s : args) {
			argsS.add(new VariableSymbol(new Int(), s));
			DeclarationInt d = new DeclarationInt(s);
			irInstructions.append(d.toIR(tab));
		}
		SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(this.type,this.nom, argsS,true);
		tab.add(f);
		for(Instruction i : this.instructions) {
			irInstructions.append(i.toIR(tab));
		}
		
		Llvm.instructionFunc func =new  Llvm.instructionFunc(this.nom,(this.type.toLlvmType()).toString(),this.args);
		irRes.appendCode(func);
		irRes.append(irInstructions);
		irRes.appendCode(new Llvm.LC());
		return irRes;
	}

}
