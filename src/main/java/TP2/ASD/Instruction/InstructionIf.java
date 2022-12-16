package TP2.ASD.Instruction;

import java.util.ArrayList;

import TP2.*;
import TP2.ASD.Expression.Expression;
import TP2.ASD.Type.Type;
import TP2.ASD.Type.Void;
import TP2.Llvm.IR;
import TP2.ASD.Expression.Expression.RetExpression;

public class InstructionIf extends Instruction {
	Expression e;
	//InstructionList i1;
	InstructionBlock i1;
	//InstructionList i2;
	InstructionBlock i2;
	Type type;
	
	public InstructionIf(Expression e,Instruction i1){
		this.e = e;
		this.i1 = (InstructionBlock)i1;
	}
	public InstructionIf(Expression e,Instruction i1,Instruction i2){
		this.e = e;
		this.i1 = (InstructionBlock)i1;
		this.i2 = (InstructionBlock)i2;
		
	}

	public void verifType(Type type) {
	    this.type = type;
	}
	@Override
	public String pp(int profondeur) {
		StringBuilder  ppi1 = new StringBuilder();
		StringBuilder ppi2 = new StringBuilder();
		StringBuilder res = new StringBuilder();
	 	ppi1.append(i1.pp(profondeur + 1));
			res.append(Utils.indent(profondeur)+ res);
			res.append("IF " + e.pp(0) + "\n"+Utils.indent(profondeur) + "THEN \n" + ppi1);
				  ;
			if(i2 != null) {

			 ppi2.append(i2.pp(profondeur+1));
				res.append(Utils.indent(profondeur));
				res.append("ELSE \n" + Utils.indent(profondeur) + ppi2);
			}
			
		
		return res.toString();
	}

	@Override
	public RetExpression toIR(SymbolTable tab) throws TypeException {
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
		i1.verifType(this.type);
		ir.append(i1.toIR(tab).ir);
		
		ir.appendCode(new Llvm.Br(branchFI));
		
		

		if(i2 != null){
				i2.verifType(this.type);
	            ir.appendCode(new Llvm.Label(branchElse));
	            ir.append(i2.toIR(tab).ir);
	            ir.appendCode(new Llvm.Br(branchFI));
	        }
		ir.appendCode(new Llvm.Label(branchFI));

		return new RetExpression(ir,new Void(),"if");
	}
	
}
