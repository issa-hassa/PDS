package TP2.ASD;

import java.util.ArrayList;

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
	public String pp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IR toIR(SymbolTable tab) throws TypeException {
		Llvm.IR irInstrucions = new Llvm.IR(Llvm.empty(),Llvm.empty());
		Llvm.IR irRes = new Llvm.IR(Llvm.empty(),Llvm.empty());
		
		ArrayList<VariableSymbol> argsS = new ArrayList<>();
		for(String s : args) {
			argsS.add(new VariableSymbol(new Int(), s));
			DeclarationInt d = new DeclarationInt(s);
			irInstrucions.append(d.toIR(tab));
		}
		SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(this.type,this.nom, argsS,true);
		tab.add(f);
		for(Instruction i : this.instructions) {
			irInstrucions.append(i.toIR(tab));
		}
		
		Llvm.instructionFunc func =new  Llvm.instructionFunc(this.nom,(this.type.toLlvmType()).toString(),this.args);
		irRes.appendCode(func);
		irRes.append(irInstrucions);
		irRes.appendCode(new Llvm.LC());
		return irRes;
	}

}
