package TP2.ASD;

import java.util.ArrayList;

import TP2.*;
import TP2.Llvm.IR;
import TP2.Llvm.Label;
import TP2.ASD.Expression.RetExpression;

public class InstructionIf extends Instruction {
	Expression e;
	ArrayList<Instruction> i1;
	ArrayList<Instruction> i2;
	
	
	public InstructionIf(Expression e,ArrayList<Instruction> i1){
		this.e = e;
		this.i1 = i1;
	}
	public InstructionIf(Expression e,ArrayList<Instruction> i1,ArrayList<Instruction> i2){
		this.e = e;
		this.i1 = i1;
		this.i2 = i2;
		
	}
	
	@Override
	public String pp() {
		String ppi1 = "";
		String ppi2 = "";
		String res = "";
		for(Instruction i : i1) ppi1 += i.pp();
			res += "IF " + e.pp() + "\n" + "THEN " + Utils.indent(0) + ppi1 + 
				  "\n"; 
			if(i2 != null) {
				for(Instruction i : i2) ppi2 += i.pp();
				res += "ELSE " + Utils.indent(0) + ppi2;
			}
			
		
		return res;
	}

	@Override
	public IR toIR(SymbolTable tab) throws TypeException {
		Llvm.IR ir =new Llvm.IR(Llvm.empty(),Llvm.empty());
		RetExpression irE = e.toIR(tab);
		
		String eRes = irE.result;
		String branchIF = Utils.newlab("then"); // branchement si la condition du if est verifiée
		String branchFI = Utils.newlab("fi"); // branchement fin if 
		
		
		String branchElse = (i2 == null)? branchFI : Utils.newlab("else");
		ir.append(irE.ir);
		if(i2 == null) {
			ir.appendCode(new Llvm.instructionIf(eRes,  Utils.newtmp(), branchIF,branchElse, branchFI,false));
		}
		else {
			ir.appendCode(new Llvm.instructionIf(eRes,  Utils.newtmp(), branchIF,branchElse, branchFI,true));

			
		}
		
		ir.appendCode(new Llvm.Label(branchIF));
		for(Instruction i : i1){
       	 ir.append(i.toIR(tab)); 
       }
		
		ir.appendCode(new Llvm.Br(branchFI));
		
		
		if(i2 == null) {
			ir.appendCode(new Llvm.Label(branchFI));
		}
		 else{ 
	            ir.appendCode(new Llvm.Label(branchElse));
	            for(Instruction i : i2){
	            	 ir.append(i.toIR(tab)); 
	            }
	           
	            ir.appendCode(new Llvm.Br(branchFI));
	            ir.appendCode(new Llvm.Label(branchFI)); 
	        }
		
		
		return ir;
	}
	
}
